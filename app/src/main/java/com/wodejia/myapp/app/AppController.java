package com.wodejia.myapp.app;

import android.text.TextUtils;

import com.example.clarence.datastorelibrary.StoreFactory;
import com.example.clarence.datastorelibrary.StoreSharePreference;
import com.example.clarence.utillibrary.CommonUtils;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.manager.SharePreferenceManager;
import com.wodejia.myapp.server.ServerManager;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/10.
 */
public class AppController {
    @Inject
    public SharePreferenceManager sharePreferenceManager;
    @Inject
    public ServerManager serverManager;

    @Inject
    public AppController() {

    }

    /**
     * 检查账号
     *
     * @param account
     * @return
     */
    public boolean checkAccunt(String account) {
        return !TextUtils.isEmpty(account) && CommonUtils.isMobilePhone(account);
    }

    /**
     * 检查密码
     *
     * @param password
     * @return
     */
    public boolean checkPassword(String password) {
        return !TextUtils.isEmpty(password) && password.length() >= 6 && password.length() <= 12;
    }

    /**
     * 是否是管理员
     *
     * @param accountDO
     * @return
     */
    public boolean isManager(AccountDO accountDO) {
        if (accountDO != null && accountDO.getLevel() == PowerLevel.Manager.getLevel()) {
            return true;
        }
        return false;
    }
}
