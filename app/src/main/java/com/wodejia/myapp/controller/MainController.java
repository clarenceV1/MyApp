package com.wodejia.myapp.controller;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.data.WeatherDO;
import com.wodejia.myapp.data.WeatherInfoDO;
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
 * Created by clarence on 16/9/5.
 */
public class MainController extends AppController {

    @Inject
    AccountManager accountManager;

    @Inject
    public MainController() {
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

    public String getWeather(WeatherInfoDO weatherInfoResponseDO) {
        if (weatherInfoResponseDO != null && weatherInfoResponseDO.getWeatherinfo() != null) {
            StringBuffer stringBuffer = new StringBuffer();
            WeatherDO weather = weatherInfoResponseDO.getWeatherinfo();
            stringBuffer.append(weather.getCity()).append(" ");
            stringBuffer.append(weather.getWeather()).append(" ");
            stringBuffer.append(weather.getTemp1()).append("-");
            stringBuffer.append(weather.getTemp2());
            return stringBuffer.toString();
        }
        return null;
    }

    public AccountDO getAccount(){
      return accountManager.getAccount();
    }
}
