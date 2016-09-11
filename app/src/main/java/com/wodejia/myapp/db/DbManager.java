package com.wodejia.myapp.db;

import android.content.Context;

import com.wodejia.myapp.table.DaoMaster;
import com.wodejia.myapp.table.DaoSession;


/**
 * Created by clarence on 16/9/11.
 */
public class DbManager {

    private static final String dbName = "myapp.db";
    private DbHelper dbHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static class LazyHolder {
        private static final DbManager instance = new DbManager();
    }

    public static final DbManager getInstance() {
        return LazyHolder.instance;
    }

    private DbManager() {

    }

    public void init(Context context){
        dbHelper = new DbHelper(context, dbName);
        mDaoMaster = new DaoMaster(dbHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        if (mDaoMaster != null) {
            mDaoSession = mDaoMaster.newSession();
        }
        return mDaoSession;
    }

    public DbHelper getDbHelper() {
        return dbHelper;
    }
}