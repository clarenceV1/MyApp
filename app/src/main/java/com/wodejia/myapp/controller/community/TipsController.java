package com.wodejia.myapp.controller.community;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.community.TipsRequestDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.manager.manager.TipsDOManager;

import java.util.ArrayList;
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
    public void requestTipsList(Long blockId, Subscriber subscriber) {
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

    public List<TipsRequestDO> getMockData() {
        List<TipsRequestDO> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TipsRequestDO tipsRequestDO = new TipsRequestDO();
            tipsRequestDO.setProducterId(i);
            tipsRequestDO.setProducterName("xiaocai_" + i);
            tipsRequestDO.setReplyNum(tipsRequestDO.getReplyNum()*10);
            tipsRequestDO.setTipId(Long.valueOf(i));
            tipsRequestDO.setTipTitle("帖子标题——"+i);
            tipsRequestDO.setUpdateTime(i*5+"分钟前");
            list.add(tipsRequestDO);
        }
        return list;/*tipsDOManager.getTipsList();*/
    }
}
