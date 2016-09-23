package com.wodejia.myapp.controller.contacts;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.contacts.LogisticsDetailRequestDO;
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
public class LogisticsDetailController extends AppController {

    @Inject
    public LogisticsDetailController() {
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

    public LogisticsDetailRequestDO getMockData(int logisticsId) {
        LogisticsDetailRequestDO logisticsDetailRequestDO = new LogisticsDetailRequestDO();
        logisticsDetailRequestDO.setLogisticsId(1);
        logisticsDetailRequestDO.setUserId(1);
        logisticsDetailRequestDO.setLogisticsName("顺丰");
        logisticsDetailRequestDO.setLogisticsIcon("http://image.suning.cn/content/catentries/00000000012355/000000000123557813/fullimage/000000000123557813_1f.jpg");
        return logisticsDetailRequestDO;
    }
}
