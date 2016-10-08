package com.wodejia.myapp.controller.contacts;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.contacts.OfficeDetailDO;
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
public class OfficeDetailController extends AppController {

    @Inject
    public OfficeDetailController() {
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

    public OfficeDetailDO getMockData(int officeId) {
        OfficeDetailDO officeDetailRequestDO = new OfficeDetailDO();
        officeDetailRequestDO.setOfficeId(1);
        officeDetailRequestDO.setOfficeAddress("东垵居委会");
        officeDetailRequestDO.setOfficeIcon("http://tz.sinzhu.com/UploadSoftPic/200710/20071009153755599.jpg");
        officeDetailRequestDO.setOfficeName("居委会");
        officeDetailRequestDO.setUserId(1);
        return officeDetailRequestDO;
    }
}
