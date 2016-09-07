package com.wodejia.myapp.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.clarence.corelibrary.ConfigSwitch;
import com.wodejia.myapp.dagger.components.ActivityComponent;
import com.wodejia.myapp.dagger.components.AppComponent;
import com.wodejia.myapp.dagger.components.DaggerActivityComponent;
import com.wodejia.myapp.dagger.module.ActivityModule;

import javax.inject.Inject;

/**
 * 提供必要的组件
 * Created by clarence on 16/4/4.
 */
public abstract class AppActivity extends AppCompatActivity {
    @Inject
    public ConfigSwitch configSwitch;
    @Inject
    public Navigator navigator;

    public ActivityComponent activityComponent;

    public abstract void initVariables();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initConfig();
        initVariables();
    }

    public void initConfig() {
        initDagger();
    }

    private void initDagger() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
        activityComponent.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return ((AppAplication) getApplication()).getApplicationComponent();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(containerViewId, fragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        configSwitch.evenBusSwitch(false);
        super.onDestroy();
    }
}
