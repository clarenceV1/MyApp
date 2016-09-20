package com.wodejia.myapp.app;

import android.text.TextUtils;

import com.example.clarence.utillibrary.CommonUtils;
import com.wodejia.myapp.table.BlockDO;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/10.
 */
public class AppController {

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
}
