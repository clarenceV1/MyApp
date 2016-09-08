package com.wodejia.myapp.controller;

import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.ContactsMenuRequestDO;
import com.wodejia.myapp.data.ContactsLogisticsRequestDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;

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
 * Created by clarence on 16/9/5.
 */
public class ContactsLogisticsController {

    @Inject
    public ContactsLogisticsController() {
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

    public static List<ContactsLogisticsRequestDO> getMockData(ContactsMenuRequestDO contactsRequestDO) {
        List<ContactsLogisticsRequestDO> result = new ArrayList<>();
        if (contactsRequestDO != null) {
            String key = contactsRequestDO.getKey();
            String value = contactsRequestDO.getValue();
            if (key.equals(Constant.LOGISTICS_TYPE)) {
                for (int i = 0; i < 2; i++) {
                    ContactsLogisticsRequestDO logisticsRequetDO = new ContactsLogisticsRequestDO();
                    if (i == 0) {
                        logisticsRequetDO.setUserId(1);
                        logisticsRequetDO.setLogisticsId(1);
                        logisticsRequetDO.setUserName("小顺");
                        logisticsRequetDO.setLogisticsIcon("http://image.suning.cn/content/catentries/00000000012355/000000000123557813/fullimage/000000000123557813_1f.jpg");
                        logisticsRequetDO.setUserTelephone("6666666666");
                        logisticsRequetDO.setLogisticsName("顺丰");
                    } else {
                        logisticsRequetDO.setUserId(2);
                        logisticsRequetDO.setLogisticsId(2);
                        logisticsRequetDO.setUserName("小圆");
                        logisticsRequetDO.setLogisticsIcon("http://pic2.ooopic.com/10/44/57/44b1OOOPICb8.jpg");
                        logisticsRequetDO.setUserTelephone("55555555");
                        logisticsRequetDO.setLogisticsName("圆通");
                    }
                    result.add(logisticsRequetDO);
                }
            }
        }
        return result;
    }

}
