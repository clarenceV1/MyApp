package com.wodejia.myapp.controller;

import com.example.clarence.utillibrary.LogUtils;
import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.Weather;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.db.DbManager;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.table.AreasDO;
import com.wodejia.myapp.table.AreasDODao;
import com.wodejia.myapp.table.DaoMaster;
import com.wodejia.myapp.table.DaoSession;

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
public class MainController extends AppController {

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

    public String getWeather(WeatherInfoResponseDO weatherInfoResponseDO) {
        if (weatherInfoResponseDO != null && weatherInfoResponseDO.getWeatherinfo() != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Weather weather = weatherInfoResponseDO.getWeatherinfo();
            stringBuffer.append(weather.getCity()).append(" ");
            stringBuffer.append(weather.getWeather()).append(" ");
            stringBuffer.append(weather.getTemp1()).append("-");
            stringBuffer.append(weather.getTemp2());
            return stringBuffer.toString();
        }
        return null;
    }

    public void test() {
        AreasDODao areasDODao = mDaoSession.getAreasDODao();
        AreasDO areasDO = new AreasDO();
        areasDO.setEstateId(1);
        areasDO.setAreasAddress("222");
        areasDO.setAreasName("2111");
        areasDODao.insert(areasDO);
        List<AreasDO> areasDOList = areasDODao.queryBuilder().build().list();
        if (areasDOList != null) {
            LogUtils.d("testsql",areasDOList.toString());
        }
    }
}
