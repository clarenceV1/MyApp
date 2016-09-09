package com.wodejia.myapp.controller.contacts;

import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.ContactsMenuRequestDO;
import com.wodejia.myapp.data.ContactsShopRequestDO;
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
 * 店铺
 * Created by clarence on 16/9/5.
 */
public class ContactsShopController {

    @Inject
    public ContactsShopController() {
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

    public static List<ContactsShopRequestDO> getMockData(ContactsMenuRequestDO contactsRequestDO) {
        List<ContactsShopRequestDO> result = new ArrayList<>();
        if (contactsRequestDO != null) {
            int key = contactsRequestDO.getKey();
            String value = contactsRequestDO.getValue();
            if (key == Constant.SHOP_TYPE){
                for (int i = 0; i < 2; i++) {
                    ContactsShopRequestDO shopRequetDO = new ContactsShopRequestDO();
                    if (i == 0) {
                        shopRequetDO.setUserId(1);
                        shopRequetDO.setUserName("一笑");
                        shopRequetDO.setShopIcon("http://img1.imgtn.bdimg.com/it/u=3957342138,1132542497&fm=21&gp=0.jpg");
                        shopRequetDO.setUserTelephone("1111111");
                        shopRequetDO.setShopId(1);
                        shopRequetDO.setShopName("理发店");
                    } else {
                        shopRequetDO.setUserId(2);
                        shopRequetDO.setShopIcon("http://img1.imgtn.bdimg.com/it/u=3957342138,1132542497&fm=21&gp=0.jpg");
                        shopRequetDO.setUserName("笑话");
                        shopRequetDO.setUserTelephone("2222");
                        shopRequetDO.setShopId(2);
                        shopRequetDO.setShopName("五金店");
                    }
                    result.add(shopRequetDO);
                }
            }
        }
        return result;
    }

}
