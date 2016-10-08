package com.wodejia.myapp.controller.community;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.community.TipsDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.manager.manager.TipsDOManager;

import java.util.List;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by clarence on 16/9/29.
 */

public class TipsController extends AppController {
    @Inject
    TipsDOManager tipsDOManager;

    @Inject
    public TipsController() {

    }

    /**
     * 获取贴士列表
     *
     * @param blockId
     * @param subscriber
     */
    public void requestTipsList(int blockId, Subscriber subscriber) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUrl.searchWeather)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            ApiService apiService = retrofit.create(ApiService.class);
            apiService.getWeather("test")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TipsDO> getMockData(int blockId) {
        return tipsDOManager.getTipsList(blockId);
    }
}
