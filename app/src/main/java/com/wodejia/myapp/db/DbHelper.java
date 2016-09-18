package com.wodejia.myapp.db;

import android.content.Context;
import android.util.Log;


import com.wodejia.myapp.data.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Created by clarence on 16/4/16.
 */
public class DbHelper extends DaoMaster.OpenHelper {

    public DbHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
    }
}
