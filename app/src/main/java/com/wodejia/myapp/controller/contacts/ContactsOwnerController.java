package com.wodejia.myapp.controller.contacts;

import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.ContactsMenuRequestDO;
import com.wodejia.myapp.data.ContactsOwnerRequestDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.manager.ContactsMainManager;

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
 * 业主
 * Created by clarence on 16/9/5.
 */
public class ContactsOwnerController {
    @Inject
    ContactsMainManager contactsMainManager;

    @Inject
    public ContactsOwnerController() {
    }

    public void request(Subscriber subscriber) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUrl.searchWeather)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            ApiService apiService = retrofit.create(ApiService.class);
            apiService.getWeather("test").subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ContactsOwnerRequestDO> getMockData(ContactsMenuRequestDO contactsRequestDO) {
        List<ContactsOwnerRequestDO> result = new ArrayList<>();
        if (contactsRequestDO != null) {
            int key = contactsRequestDO.getKey();
            String value = contactsRequestDO.getValue();
            if (key == Constant.AREAS_TYPE){
                int userId = 0;
                for (int x = 1; x < 12; x++) { //哪栋
                    for (int i = 1; i < 12; i++) {// 哪层
                        for (int j = 1; j < 12; j++) { //哪间
                            userId++;
                            ContactsOwnerRequestDO userInfoRequetDO = new ContactsOwnerRequestDO();
                            userInfoRequetDO.setUserId(userId);
                            userInfoRequetDO.setUserIcon("http://img4.imgtn.bdimg.com/it/u=639941756,2707761062&fm=15&gp=0.jpg");
                            userInfoRequetDO.setUserName("用户" + userId);
                            userInfoRequetDO.setUserTelephone("1111111");
                            String dong;
                            if (x < 10) {
                                dong = "0" + x;
                            } else {
                                dong = "" + x;
                            }
                            userInfoRequetDO.setHouseNum("#" + dong);
                            String floor;
                            if (i < 10) {
                                floor = "0" + i;
                            } else {
                                floor = "" + i;
                            }
                            String num;
                            if (j < 10) {
                                num = "0" + j;
                            } else {
                                num = "" + j;
                            }
                            userInfoRequetDO.setHouseFloor(floor + num);
                            result.add(userInfoRequetDO);
                        }
                    }
                }
            }
        }
        return result;
    }
}
