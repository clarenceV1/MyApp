package com.wodejia.myapp.manager;

import com.wodejia.myapp.app.AppManager;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.data.AccountDODao;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/10.
 */
public class AccountManager extends AppManager {
    AccountDODao accountDODao;

    @Inject
    public AccountManager() {
        accountDODao = mDaoSession.getAccountDODao();
    }

    public void insert(AccountDO accountDO) {
        accountDODao.insert(accountDO);
    }

    public AccountDO getAccount() {
        List<AccountDO> accountDOList = accountDODao.queryBuilder().build().list();
        if (accountDOList != null && accountDOList.size() > 0) {
            return accountDOList.get(0);
        }
        return null;
    }
}
