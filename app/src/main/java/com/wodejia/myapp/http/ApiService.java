package com.wodejia.myapp.http;


import com.wodejia.myapp.data.QiniuTokenDO;
import com.wodejia.myapp.data.WeatherInfoDO;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;


public interface ApiService {
    @GET("/data/cityinfo/101230201.html")
    Observable<WeatherInfoDO> getWeather(@Query("test") String test);

    @GET("/api/quick_start/simple_image_example_token.php")
    Observable<QiniuTokenDO> getUploadToken(@Query("test") String test);
}
