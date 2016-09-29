package com.wodejia.myapp.controller;

import com.wodejia.myapp.app.AppController;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/29.
 */

public class GuideController extends AppController {

    @Inject
    public GuideController() {

    }

    public void hideGuide(){
        sharePreferenceManager.setHideGuide();
    }
}
