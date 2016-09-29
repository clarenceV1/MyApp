package com.wodejia.myapp.ui;

import android.os.Bundle;
import android.os.Handler;

import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.controller.WelcomeController;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by clarence on 16/9/29.
 */

public class WelcomeActivity extends AppActivity {

    @Inject
    WelcomeController welcomeController;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        titleBarCommon.setCustomTitleBar(-1);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        goActivity();
    }

    private void goActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (welcomeController.isShowGuide()) {
                    navigator.navigateTo(WelcomeActivity.this, GuideActivity.class);
                } else {
                    navigator.navigateTo(WelcomeActivity.this, MainActivity.class);
                }
                finish();
            }
        }, 2000);
    }
}
