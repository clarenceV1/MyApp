package com.wodejia.myapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ACCOUNT_DO".
*/
public class AccountDODao extends AbstractDao<AccountDO, Long> {

    public static final String TABLENAME = "ACCOUNT_DO";

    /**
     * Properties of entity AccountDO.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Account = new Property(1, String.class, "account", false, "ACCOUNT");
        public final static Property UserId = new Property(2, int.class, "userId", false, "USER_ID");
        public final static Property UserNickname = new Property(3, String.class, "userNickname", false, "USER_NICKNAME");
        public final static Property UserIcon = new Property(4, String.class, "userIcon", false, "USER_ICON");
        public final static Property UserName = new Property(5, String.class, "userName", false, "USER_NAME");
    }


    public AccountDODao(DaoConfig config) {
        super(config);
    }
    
    public AccountDODao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACCOUNT_DO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ACCOUNT\" TEXT," + // 1: account
                "\"USER_ID\" INTEGER NOT NULL ," + // 2: userId
                "\"USER_NICKNAME\" TEXT," + // 3: userNickname
                "\"USER_ICON\" TEXT," + // 4: userIcon
                "\"USER_NAME\" TEXT);"); // 5: userName
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACCOUNT_DO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AccountDO entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(2, account);
        }
        stmt.bindLong(3, entity.getUserId());
 
        String userNickname = entity.getUserNickname();
        if (userNickname != null) {
            stmt.bindString(4, userNickname);
        }
 
        String userIcon = entity.getUserIcon();
        if (userIcon != null) {
            stmt.bindString(5, userIcon);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(6, userName);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AccountDO entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(2, account);
        }
        stmt.bindLong(3, entity.getUserId());
 
        String userNickname = entity.getUserNickname();
        if (userNickname != null) {
            stmt.bindString(4, userNickname);
        }
 
        String userIcon = entity.getUserIcon();
        if (userIcon != null) {
            stmt.bindString(5, userIcon);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(6, userName);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AccountDO readEntity(Cursor cursor, int offset) {
        AccountDO entity = new AccountDO( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // account
            cursor.getInt(offset + 2), // userId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // userNickname
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // userIcon
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // userName
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AccountDO entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAccount(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUserId(cursor.getInt(offset + 2));
        entity.setUserNickname(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUserIcon(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUserName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AccountDO entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AccountDO entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AccountDO entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
