package com.wodejia.myapp.controller.manager;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.community.BlockRequestDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.manager.manager.BlockDOManager;
import com.wodejia.myapp.ui.MainActivity;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by clarence on 16/9/19.
 */
public class ManagerAddBlockController extends AppController {
    @Inject
    BlockDOManager manager;

    @Inject
    public ManagerAddBlockController() {
    }

    /**
     * 添加模块
     */
    public void addBlock(BlockRequestDO blockDO, Subscriber subscriber) {
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

    /**
     * 测试用
     *
     * @param blockDO
     */
    public void saveMockData(BlockRequestDO blockDO) {
        blockDO.setManagerName(MainActivity.accountDO.getUserNickname());
        manager.insert(blockDO);
    }
}
