package com.wodejia.myapp.controller;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import com.example.clarence.utillibrary.DownloadUtils;
import com.example.clarence.utillibrary.LogUtils;
import com.example.clarence.utillibrary.ToastUtils;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.utils.AsyncRun;
import com.wodejia.myapp.data.QiniuTokenDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.manager.QiniuManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by clarence on 16/9/19.
 */
public class QiniuController {

    @Inject
    QiniuManager manager;

    @Inject
    public QiniuController() {

    }

    public void requestUploadToken(Subscriber subscriber) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUrl.QINIU_SERVER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            ApiService apiService = retrofit.create(ApiService.class);
            apiService.getUploadToken("test")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadImage(final Context context, final String uploadFilePath, final UploadOptions uploadOptions, final UpCompletionHandler upCompletionHandler) {
        requestUploadToken(new Subscriber<QiniuTokenDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(context, "token is error");
            }

            @Override
            public void onNext(final QiniuTokenDO token) {
                if (token == null) {
                    return;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        manager.getUploadManager().put(new File(uploadFilePath), null, token.getUptoken(), upCompletionHandler, uploadOptions);
                    }
                }).start();
            }
        });
    }
}
