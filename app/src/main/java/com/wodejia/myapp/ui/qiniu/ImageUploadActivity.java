package com.wodejia.myapp.ui.qiniu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.clarence.utillibrary.DownloadUtils;
import com.example.clarence.utillibrary.FileUtils;
import com.example.clarence.utillibrary.IntentUtils;
import com.example.clarence.utillibrary.LogUtils;
import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.utils.AsyncRun;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.controller.QiniuController;
import com.wodejia.myapp.data.QiniuTokenDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.http.ApiUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/18.
 */
public class ImageUploadActivity extends AppActivity {
    @Inject
    QiniuController controller;

    @BindView(R.id.uploadProgressBar)
    ProgressBar uploadProgressBar;
    @BindView(R.id.uploadStatusLayout)
    LinearLayout uploadStatusLayout;
    @BindView(R.id.uploadSpeedTextView)
    TextView uploadSpeedTextView;
    @BindView(R.id.uploadFileLengthTextView)
    TextView uploadFileLengthTextView;
    @BindView(R.id.uploadPercentageTextView)
    TextView uploadPercentageTextView;
    @BindView(R.id.uploadLogTextView)
    TextView uploadLogTextView;
    @BindView(R.id.simpleDraweeView)
    SimpleDraweeView simpleDraweeView;

    private static final int REQUEST_CODE = 8090;

    private String uploadFilePath;
    private long uploadLastTimePoint;
    private long uploadLastOffset;
    private long uploadFileLength;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_upload);
        ButterKnife.bind(this);
        initView();
        load();
    }

    private void load() {

    }

    private void initView() {
        uploadProgressBar.setProgress(0);
        uploadProgressBar.setMax(100);
        uploadStatusLayout.setVisibility(View.INVISIBLE);
    }

    public void selectUploadFile(View view) {
        Intent target = IntentUtils.createGetContentIntent();
        Intent intent = Intent.createChooser(target, "选择文件");
        try {
            this.startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        final Uri uri = data.getData();
                        try {
                            final String path = FileUtils.getPath(this, uri);
                            this.uploadFilePath = path;
                            this.clearLog();
                            LogUtils.d("tag",uploadFilePath);
                            this.writeLog("选择文件:" + path);
                        } catch (Exception e) {
                            ToastUtils.showToast(this, "选择上传文件失败!");
                        }
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void uploadFile(View view) {
        if (uploadFilePath == null) {
            return;
        }
        File uploadFile = new File(uploadFilePath);
        uploadFileLength = uploadFile.length();
        uploadLastTimePoint = System.currentTimeMillis();
        uploadLastOffset = 0;
        prepareUpLoad(uploadFileLength);
        UploadOptions uploadOptions = new UploadOptions(null, null, false, new UpProgressHandler() {
            @Override
            public void progress(String key, double percent) {
                updateStatus(percent);
            }
        }, null);
        UpCompletionHandler upCompletionHandler = new UpCompletionHandler() {
            @Override
            public void complete(String key, ResponseInfo respInfo, JSONObject jsonData) {
                if (respInfo.isOK()) {
                    uoloadComplete(key,respInfo,jsonData);
                }
            }
        };
        controller.uploadImage(this, uploadFilePath, uploadOptions, upCompletionHandler);
    }

    private void uoloadComplete(String key, ResponseInfo respInfo, JSONObject jsonData) {
        try {
            long lastMillis = System.currentTimeMillis() - uploadLastTimePoint;
            String fileKey = jsonData.getString("key");
            String fileHash = jsonData.getString("hash");
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            final int width = dm.widthPixels;
            final String imageUrl = ApiUrl.QINIU_IMAGE_SERVER + fileKey + "?imageView2/0/w/" + width + "/format/jpg";
            LogUtils.d("tag", imageUrl);
            AsyncRun.run(new Runnable() {
                @Override
                public void run() {
                    Uri uri = Uri.parse(imageUrl);
                    simpleDraweeView.setImageURI(uri);
                }
            });

            writeLog("File Size: " + DownloadUtils.formatSize(uploadFileLength));
            writeLog("File Key: " + fileKey);
            writeLog("File Hash: " + fileHash);
            writeLog("Last Time: " + DownloadUtils.formatMilliSeconds(lastMillis));
            writeLog("Average Speed: " + DownloadUtils.formatSpeed(uploadFileLength, lastMillis));
            writeLog("X-Reqid: " + respInfo.reqId);
            writeLog("X-Via: " + respInfo.xvia);
            writeLog("--------------------------------");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void clearLog() {
        this.uploadLogTextView.setText("");
    }

    public void prepareUpLoad(long fileLength) {
        uploadPercentageTextView.setText("0 %");
        uploadSpeedTextView.setText("0 KB/s");
        uploadFileLengthTextView.setText(DownloadUtils.formatSize(fileLength));
        uploadStatusLayout.setVisibility(LinearLayout.VISIBLE);
    }

    private void updateStatus(final double percentage) {
        long now = System.currentTimeMillis();
        long deltaTime = now - uploadLastTimePoint;
        long currentOffset = (long) (percentage * uploadFileLength);
        long deltaSize = currentOffset - uploadLastOffset;
        if (deltaTime <= 100) {
            return;
        }

        final String speed = DownloadUtils.formatSpeed(deltaSize, deltaTime);
        // update
        uploadLastTimePoint = now;
        uploadLastOffset = currentOffset;

        AsyncRun.run(new Runnable() {
            @Override
            public void run() {
                int progress = (int) (percentage * 100);
                uploadProgressBar.setProgress(progress);
                uploadPercentageTextView.setText(progress + " %");
                uploadSpeedTextView.setText(speed);
            }
        });
    }

    private void writeLog(final String msg) {
        AsyncRun.run(new Runnable() {
            @Override
            public void run() {
                uploadLogTextView.append(msg);
                uploadLogTextView.append("\r\n");
            }
        });
    }
}
