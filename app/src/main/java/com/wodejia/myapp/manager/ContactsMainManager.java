package com.wodejia.myapp.manager;

import com.wodejia.myapp.app.AppManager;
import com.wodejia.myapp.server.ServerManager;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/5.
 */
public class ContactsMainManager extends AppManager {

    @Inject
    ServerManager serverManager;

    @Inject
    public ContactsMainManager() {

    }
}
