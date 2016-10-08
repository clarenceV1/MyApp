package com.wodejia.myapp.controller.contacts;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.contacts.OwnerDetailRequestDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.data.UserBaseInfoDO;
import com.wodejia.myapp.data.UserAnnexinfoDO;

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
public class UserDetailController extends AppController {

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

    /**
     * 获取用户信息
     *
     * @param userId
     * @param sendRelative  是否是所有信息
     * @return
     */
    public OwnerDetailRequestDO getMockData(int userId, boolean sendRelative) {
        OwnerDetailRequestDO userInfoDetailRequestDO = new OwnerDetailRequestDO();
        UserBaseInfoDO baseDO = new UserBaseInfoDO();
        baseDO.setUserId(userId);
        baseDO.setUserName("猜猜");
        baseDO.setUserIcon("http://img4.imgtn.bdimg.com/it/u=639941756,2707761062&fm=15&gp=0.jpg");
        baseDO.setUserNickname("小猜");
        baseDO.setUserTelephone("13779926287");
        userInfoDetailRequestDO.setUserInfoBaseDO(baseDO);

        if (sendRelative) {
            UserAnnexinfoDO annexDO = new UserAnnexinfoDO();
            annexDO.setAreasId(1);
            annexDO.setHouseId(1);
            annexDO.setLogisticsId(1);
            annexDO.setOfficeId(1);
            annexDO.setPropertyId(1);
            annexDO.setShopId(1);
            annexDO.setUserId(1);
            userInfoDetailRequestDO.setUserinfoAnnexDO(annexDO);
        }
        return userInfoDetailRequestDO;
    }
}
