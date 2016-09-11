package com.wodejia.myapp.app;

import com.example.clarence.corelibrary.CApplication;
import com.example.clarence.corelibrary.ConfigManager;
import com.example.clarence.imageloaderlibrary.ImageLoaderFactory;
import com.wodejia.myapp.dagger.components.AppComponent;
import com.wodejia.myapp.dagger.components.DaggerAppComponent;
import com.wodejia.myapp.dagger.module.AppModule;
import com.wodejia.myapp.db.DbManager;

import javax.inject.Inject;

/**
 * Created by clarence on 16/4/4.
 */
public class AppAplication extends CApplication {

    @Inject
    ConfigManager configManager;

    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        ImageLoaderFactory.initFresco(this);
        DbManager.getInstance().init(this);
    }

    private void initializeInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }

}
