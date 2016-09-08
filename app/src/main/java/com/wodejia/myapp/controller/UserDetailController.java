package com.wodejia.myapp.controller;

import com.wodejia.myapp.data.UserInfoDetailRequestDO;
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
public class UserDetailController {

    @Inject
    public UserDetailController() {
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

    public UserInfoDetailRequestDO getMockData(int userId) {
        UserInfoDetailRequestDO userInfoDetailRequestDO = new UserInfoDetailRequestDO();
        userInfoDetailRequestDO.setUserId(userId);
        userInfoDetailRequestDO.setUserName("猜猜");
        userInfoDetailRequestDO.setUserIcon("http://img4.imgtn.bdimg.com/it/u=639941756,2707761062&fm=15&gp=0.jpg");
        userInfoDetailRequestDO.setUserNickname("小猜");
        userInfoDetailRequestDO.setUserTelephone("13779926287");
        return userInfoDetailRequestDO;
    }
}
