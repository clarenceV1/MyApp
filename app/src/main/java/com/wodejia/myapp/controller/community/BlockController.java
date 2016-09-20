package com.wodejia.myapp.controller.community;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.http.ApiService;
import com.wodejia.myapp.http.ApiUrl;
import com.wodejia.myapp.manager.AccountManager;
import com.wodejia.myapp.manager.manager.BlockDOManager;
import com.wodejia.myapp.table.BlockDO;

import java.util.List;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by clarence on 16/9/9.
 */
public class BlockController extends AppController {

    @Inject
    BlockDOManager blockDOManager;

    @Inject
    public BlockController() {
    }

    public List<BlockDO> getMockData(){
        return blockDOManager.getBlockList();
    }

    /**
     * 获取板块列表
     *
     * @param subscriber
     */
    public void requestBlockList(Subscriber subscriber) {
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
}
