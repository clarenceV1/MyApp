package com.wodejia.myapp.data;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.data.community.BlockDO;
import com.wodejia.myapp.data.community.TipsDO;

import com.wodejia.myapp.data.AccountDODao;
import com.wodejia.myapp.data.community.BlockDODao;
import com.wodejia.myapp.data.community.TipsDODao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig accountDODaoConfig;
    private final DaoConfig blockDODaoConfig;
    private final DaoConfig tipsDODaoConfig;

    private final AccountDODao accountDODao;
    private final BlockDODao blockDODao;
    private final TipsDODao tipsDODao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        accountDODaoConfig = daoConfigMap.get(AccountDODao.class).clone();
        accountDODaoConfig.initIdentityScope(type);

        blockDODaoConfig = daoConfigMap.get(BlockDODao.class).clone();
        blockDODaoConfig.initIdentityScope(type);

        tipsDODaoConfig = daoConfigMap.get(TipsDODao.class).clone();
        tipsDODaoConfig.initIdentityScope(type);

        accountDODao = new AccountDODao(accountDODaoConfig, this);
        blockDODao = new BlockDODao(blockDODaoConfig, this);
        tipsDODao = new TipsDODao(tipsDODaoConfig, this);

        registerDao(AccountDO.class, accountDODao);
        registerDao(BlockDO.class, blockDODao);
        registerDao(TipsDO.class, tipsDODao);
    }
    
    public void clear() {
        accountDODaoConfig.clearIdentityScope();
        blockDODaoConfig.clearIdentityScope();
        tipsDODaoConfig.clearIdentityScope();
    }

    public AccountDODao getAccountDODao() {
        return accountDODao;
    }

    public BlockDODao getBlockDODao() {
        return blockDODao;
    }

    public TipsDODao getTipsDODao() {
        return tipsDODao;
    }

}
