package com.wodejia.myapp.ui.user;

import com.wodejia.myapp.data.AccountDO;

/**
 * Created by clarence on 16/9/9.
 */
public interface LoginState {
    public void goLogin();

    public void goRegister();

    public void loginSuccess(AccountDO accountDO);

}
