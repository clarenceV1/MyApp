package com.wodejia.myapp.table;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wodejia.myapp.table.AreasDO;

import com.wodejia.myapp.table.AreasDODao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig areasDODaoConfig;

    private final AreasDODao areasDODao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        areasDODaoConfig = daoConfigMap.get(AreasDODao.class).clone();
        areasDODaoConfig.initIdentityScope(type);

        areasDODao = new AreasDODao(areasDODaoConfig, this);

        registerDao(AreasDO.class, areasDODao);
    }
    
    public void clear() {
        areasDODaoConfig.clearIdentityScope();
    }

    public AreasDODao getAreasDODao() {
        return areasDODao;
    }

}
