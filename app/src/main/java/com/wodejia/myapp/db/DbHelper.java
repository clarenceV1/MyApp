package com.wodejia.myapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.wodejia.myapp.data.DaoMaster;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

/**
 * Created by clarence on 16/4/16.
 */
public class DbHelper extends DatabaseOpenHelper {
    public static final int SCHEMA_VERSION = 2;

    public DbHelper(Context context, String name) {
        super(context, name, SCHEMA_VERSION);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(Database db) {
        Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
        DaoMaster.createAllTables(db, false);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
    }
}
