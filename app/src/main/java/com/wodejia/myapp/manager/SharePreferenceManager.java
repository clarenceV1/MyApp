package com.wodejia.myapp.manager;

import com.example.clarence.datastorelibrary.StoreFactory;
import com.example.clarence.datastorelibrary.StoreSharePreference;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/29.
 */

public class SharePreferenceManager {

    public StoreSharePreference sharePreference;

    @Inject
    public SharePreferenceManager() {
        init();
    }

    private void init() {
        sharePreference = StoreFactory.getStoreSharePreference();
    }

    public void setHideGuide() {
        sharePreference.setBooleanValue("ShowGuide", false);
    }

    public boolean getIsShowGuide() {
        return sharePreference.getBooleanValue("ShowGuide", true);
    }
}
