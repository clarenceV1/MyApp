package com.wodejia.myapp.data;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.data.community.BlockRequestDO;

import com.wodejia.myapp.data.AccountDODao;
import com.wodejia.myapp.data.community.BlockRequestDODao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig accountDODaoConfig;
    private final DaoConfig blockRequestDODaoConfig;

    private final AccountDODao accountDODao;
    private final BlockRequestDODao blockRequestDODao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        accountDODaoConfig = daoConfigMap.get(AccountDODao.class).clone();
        accountDODaoConfig.initIdentityScope(type);

        blockRequestDODaoConfig = daoConfigMap.get(BlockRequestDODao.class).clone();
        blockRequestDODaoConfig.initIdentityScope(type);

        accountDODao = new AccountDODao(accountDODaoConfig, this);
        blockRequestDODao = new BlockRequestDODao(blockRequestDODaoConfig, this);

        registerDao(AccountDO.class, accountDODao);
        registerDao(BlockRequestDO.class, blockRequestDODao);
    }
    
    public void clear() {
        accountDODaoConfig.clearIdentityScope();
        blockRequestDODaoConfig.clearIdentityScope();
    }

    public AccountDODao getAccountDODao() {
        return accountDODao;
    }

    public BlockRequestDODao getBlockRequestDODao() {
        return blockRequestDODao;
    }

}
