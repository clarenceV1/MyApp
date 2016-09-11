package com.wodejia.myapp.controller.user;

import android.text.TextUtils;

import com.example.clarence.utillibrary.CommonUtils;
import com.wodejia.myapp.app.AppController;
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
 * Created by clarence on 16/9/9.
 */
public class RegisterController extends AppController {

    @Inject
    public RegisterController() {
    }

    /**
     * 获取验证码
     *
     * @param subscriber
     */
    public void requestVerifyCode(Subscriber subscriber) {
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

    /**
     * 注册账号
     *
     * @param subscriber
     */
    public void registComit(Subscriber subscriber) {
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

    /**
     * 检查账号
     *
     * @param account
     * @return
     */
    public boolean checkAccunt(String account) {
        return TextUtils.isEmpty(account) || !CommonUtils.isMobilePhone(account);
    }

    /**
     * 检查验证码
     *
     * @param verifyCode
     * @return
     */
    public boolean checkVerifyCode(String verifyCode) {
        return TextUtils.isEmpty(verifyCode) || verifyCode.length() == 6;
    }

    /**
     * 检查密码
     *
     * @param password
     * @return
     */
    public boolean checkPassword(String password) {
        return TextUtils.isEmpty(password) || password.length() < 6 || password.length() > 12;
    }
}
