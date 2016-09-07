package com.wodejia.myapp.controller;

import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.ContactsRequestDO;
import com.wodejia.myapp.data.ShopRequetDO;
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
public class ContactsShopFragmentController {

    @Inject
    public ContactsShopFragmentController() {
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

    public static List<ShopRequetDO> getMockData(ContactsRequestDO contactsRequestDO) {
        List<ShopRequetDO> result = new ArrayList<>();
        if (contactsRequestDO != null) {
            String key = contactsRequestDO.getKey();
            String value = contactsRequestDO.getValue();
            if (key.equals(Constant.SHOP_TYPE)) {
                for (int i = 0; i < 2; i++) {
                    ShopRequetDO shopRequetDO = new ShopRequetDO();
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
