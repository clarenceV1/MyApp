package com.wodejia.myapp.controller;

import com.wodejia.myapp.app.AppController;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/29.
 */

public class WelcomeController extends AppController {

    @Inject
    public WelcomeController() {

    }

    public boolean isShowGuide() {
        return sharePreferenceManager.getIsShowGuide();
    }
}
