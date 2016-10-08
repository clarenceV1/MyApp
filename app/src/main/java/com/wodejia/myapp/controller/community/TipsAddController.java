package com.wodejia.myapp.controller.community;

import android.text.TextUtils;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.community.TipsAddRequestDO;
import com.wodejia.myapp.data.community.TipsRequestDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.manager.manager.TipsDOManager;
import com.wodejia.myapp.ui.MainActivity;

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

public class TipsAddController extends AppController {
    @Inject
    TipsDOManager tipsDOManager;

    @Inject
    public TipsAddController() {

    }

    /**
     * 标题不能为空并且大于6个字符
     *
     * @param tipTitle
     * @return
     */
    public boolean checkTipTitle(String tipTitle){
        //TODO 临时的条件
        return !TextUtils.isEmpty(tipTitle)&&tipTitle.length()>=6;
    }

    /**
     * 内容不能为空并且大于6个字符
     *
     * @param tipContent
     * @return
     */
    public boolean checkTipContent(String tipContent){
        //TODO 临时的条件
        return !TextUtils.isEmpty(tipContent)&&tipContent.length()>=6;
    }
    /**
     * 发表帖子
     *
     * @param tipsAddRequestDO
     * @param subscriber
     */
    public void commitTip(TipsAddRequestDO tipsAddRequestDO, Subscriber subscriber) {
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

    public void saveMockData(TipsAddRequestDO tipsAddRequestDO) {
        TipsRequestDO tipsRequestDO=new TipsRequestDO();
        tipsRequestDO.setBlockId(tipsAddRequestDO.getBlockId());
        tipsRequestDO.setUpdateTime("2016-10-8 10:00");
        tipsRequestDO.setProducterId(tipsAddRequestDO.getProducterId());
        tipsRequestDO.setTipTitle(tipsAddRequestDO.getTipTitle());
        tipsRequestDO.setTipContent(tipsAddRequestDO.getTipContent());
        tipsRequestDO.setProducterName(MainActivity.accountDO.getUserNickname());
        tipsRequestDO.setReplyNum(9);
        tipsDOManager.insert(tipsRequestDO);
    }
}
