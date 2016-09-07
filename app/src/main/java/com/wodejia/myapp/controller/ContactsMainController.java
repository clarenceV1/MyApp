package com.wodejia.myapp.controller;

import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.ContactsRequestDO;
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
 * Created by clarence on 16/9/5.
 */
public class ContactsMainController {
    @Inject
    ContactsMainManager contactsMainManager;

    @Inject
    public ContactsMainController() {
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

    public List<ContactsRequestDO> mockData() {
        List<ContactsRequestDO> contactsRequestDOList = new ArrayList<>();

        ContactsRequestDO t1 = new ContactsRequestDO();
        t1.setTitle("一期");
        t1.setKey(Constant.AREAS_TYPE);
        t1.setValue("1");
        contactsRequestDOList.add(t1);

        ContactsRequestDO t2 = new ContactsRequestDO();
        t2.setTitle("物流");
        t2.setKey(Constant.LOGISTICS_TYPE);
        t2.setValue("1");
        contactsRequestDOList.add(t2);

        ContactsRequestDO t4 = new ContactsRequestDO();
        t4.setTitle("办事处");
        t4.setKey(Constant.OFFICE_TYPE);
        t4.setValue("1");
        contactsRequestDOList.add(t4);

        ContactsRequestDO t5 = new ContactsRequestDO();
        t5.setTitle("店铺");
        t5.setKey(Constant.SHOP_TYPE);
        t5.setValue("1");
        contactsRequestDOList.add(t5);

        return contactsRequestDOList;
    }
}
