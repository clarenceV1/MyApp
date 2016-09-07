package com.wodejia.myapp.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clarence.corelibrary.BaseFragment;
import com.example.clarence.corelibrary.ConfigSwitch;
import com.wodejia.myapp.dagger.components.ActivityComponent;
import com.wodejia.myapp.dagger.components.AppComponent;
import com.wodejia.myapp.dagger.components.DaggerActivityComponent;
import com.wodejia.myapp.dagger.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by clarence on 16/9/5.
 */
public abstract class AppFragment extends BaseFragment {
    @Inject
    public ConfigSwitch configSwitch;
    @Inject
    public Navigator navigator;

    public ActivityComponent activityComponent;

    public abstract void initVariables();
    protected abstract int getLayout();
    protected abstract void initView(View view);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initDagger();
        initVariables();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initDagger() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(new ActivityModule(getActivity()))
                .build();
        activityComponent.inject(this);
    }

    private AppComponent getApplicationComponent() {
        return ((AppAplication) getActivity().getApplication()).getApplicationComponent();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public void onDestroy() {
        configSwitch.evenBusSwitch(false);
        super.onDestroy();
    }
}
