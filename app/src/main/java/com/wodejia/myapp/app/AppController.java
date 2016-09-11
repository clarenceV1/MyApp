package com.wodejia.myapp.app;

import com.wodejia.myapp.db.DbManager;
import com.wodejia.myapp.table.DaoMaster;
import com.wodejia.myapp.table.DaoSession;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/10.
 */
public class AppController {

    public DaoMaster mDaoMaster;
    public DaoSession mDaoSession;

    @Inject
    public AppController() {
        mDaoMaster = DbManager.getInstance().getMaster();
        mDaoSession = DbManager.getInstance().getSession();
    }
}
