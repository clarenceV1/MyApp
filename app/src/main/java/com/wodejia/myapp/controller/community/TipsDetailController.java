package com.wodejia.myapp.controller.community;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.community.TipsRequestDO;
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

public class TipsDetailController extends AppController {
    @Inject
    TipsDOManager tipsDOManager;

    @Inject
    public TipsDetailController() {

    }

    /**
     * 获取贴士详情
     *
     * @param tipId
     * @param subscriber
     */
    public void requestTipsDetail(int tipId, Subscriber subscriber) {
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

    public List<TipsRequestDO> getMockData(int blockId) {
        return tipsDOManager.getTipsList(blockId);
    }
}
