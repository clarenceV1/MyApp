package com.wodejia.myapp.controller.user;

import android.text.TextUtils;

import com.example.clarence.utillibrary.CommonUtils;
import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.data.AccountDODao;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.manager.AccountManager;

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
public class LoginController extends AppController {

    @Inject
    AccountManager accountManager;

    @Inject
    public LoginController() {
    }

    /**
     * 账号登录
     *
     * @param subscriber
     */
    public void loginComit(Subscriber subscriber) {
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
     * mock服务器返回的数据
     *
     * @return
     */
    public AccountDO getMockData() {
        AccountDO account = new AccountDO();
        account.setAccount("13779926287");
        account.setUserId(1);
        account.setUserName("caicai");
        account.setUserNickname("xiaocai");
        account.setUserIcon("http://e.hiphotos.baidu.com/image/pic/item/8d5494eef01f3a29913f38ca9b25bc315c607c3b.jpg");
        return account;
    }

    /**
     * 保存到数据库
     *
     * @param accountDO
     */
    public void saveAccount(AccountDO accountDO) {
        accountManager.insert(accountDO);
    }
}
