package com.wodejia.myapp.controller;

import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.ContactsRequestDO;
import com.wodejia.myapp.data.OfficeRequetDO;
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
 * 办事处
 * Created by clarence on 16/9/5.
 */
public class ContactsOfficeFragmentController {

    @Inject
    public ContactsOfficeFragmentController() {
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

    public static List<OfficeRequetDO> getMockData(ContactsRequestDO contactsRequestDO) {
        List<OfficeRequetDO> result = new ArrayList<>();
        if (contactsRequestDO != null) {
            String key = contactsRequestDO.getKey();
            String value = contactsRequestDO.getValue();
            if (key.equals(Constant.OFFICE_TYPE)) {
                for (int i = 0; i < 3; i++) {
                    OfficeRequetDO officeRequetDO = new OfficeRequetDO();
                    if (i == 0) {
                        officeRequetDO.setUserId(1);
                        officeRequetDO.setUserTelephone("1111111");
                        officeRequetDO.setOfficeId(1);
                        officeRequetDO.setOfficeIcon("http://tz.sinzhu.com/UploadSoftPic/200710/20071009153755599.jpg");
                        officeRequetDO.setOfficeName("居委会");
                        officeRequetDO.setOfficeAddress("东安北1里");
                    } else if(i==1){
                        officeRequetDO.setUserId(2);
                        officeRequetDO.setUserTelephone("222222222");
                        officeRequetDO.setOfficeId(2);
                        officeRequetDO.setOfficeIcon("http://tz.sinzhu.com/UploadSoftPic/200710/20071009153755599.jpg");
                        officeRequetDO.setOfficeName("派出所");
                        officeRequetDO.setOfficeAddress("东安北3里");
                    }else{
                        officeRequetDO.setUserId(3);
                        officeRequetDO.setUserTelephone("33333333");
                        officeRequetDO.setOfficeId(3);
                        officeRequetDO.setOfficeIcon("http://tz.sinzhu.com/UploadSoftPic/200710/20071009153755599.jpg");
                        officeRequetDO.setOfficeName("物业");
                        officeRequetDO.setOfficeAddress("东安北3里");
                    }
                    result.add(officeRequetDO);
                }
            }
        }
        return result;
    }

}
