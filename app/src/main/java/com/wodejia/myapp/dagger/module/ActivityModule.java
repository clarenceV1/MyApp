package com.wodejia.myapp.dagger.module;

import android.app.Activity;

import com.example.clarence.corelibrary.ConfigSwitch;
import com.wodejia.myapp.dagger.components.ScopeActivity;
import com.wodejia.myapp.db.DbManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by clarence on 16/4/4.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ScopeActivity
    Activity providesActivity() {
        return this.activity;
    }

    @Provides
    @ScopeActivity
    ConfigSwitch providesConfigSwitch() {
        return new ConfigSwitch(activity);
    }
}

