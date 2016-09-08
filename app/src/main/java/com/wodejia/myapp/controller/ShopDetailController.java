package com.wodejia.myapp.controller;

import com.wodejia.myapp.data.ShopDetailRequestDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by clarence on 16/9/5.
 */
public class ShopDetailController {

    @Inject
    public ShopDetailController() {
    }

    public void request(Subscriber subscriber) {
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

    public ShopDetailRequestDO getMockData(int shopId) {
        ShopDetailRequestDO shopDetailRequestDO = new ShopDetailRequestDO();
        shopDetailRequestDO.setShopId(shopId);
        shopDetailRequestDO.setShopName("五金店");
        shopDetailRequestDO.setShopIcon("http://img1.imgtn.bdimg.com/it/u=3957342138,1132542497&fm=21&gp=0.jpg");
        shopDetailRequestDO.setShopAddress("软件园二期");
        shopDetailRequestDO.setUserId(1);
        return shopDetailRequestDO;
    }
}
