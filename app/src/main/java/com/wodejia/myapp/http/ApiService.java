package com.wodejia.myapp.http;


import com.wodejia.myapp.data.WeatherInfoResponseDO;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;


public interface ApiService {
    @GET("/data/cityinfo/101230201.html")
    Observable<WeatherInfoResponseDO> getWeather(@Query("test") String test);
}
