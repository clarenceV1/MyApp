package com.wodejia.myapp;

import com.wodejia.myapp.table.UserInfoBaseDO;
import com.wodejia.myapp.table.UserinfoAnnexDO;

/**
 * 用户表
 * Created by clarence on 16/9/2.
 */
public class UserInfoDO {
    private UserInfoBaseDO userInfoBaseDO;
    private UserinfoAnnexDO userinfoAnnexDO;

    public UserInfoBaseDO getUserInfoBaseDO() {
        return userInfoBaseDO;
    }

    public void setUserInfoBaseDO(UserInfoBaseDO userInfoBaseDO) {
        this.userInfoBaseDO = userInfoBaseDO;
    }

    public UserinfoAnnexDO getUserinfoAnnexDO() {
        return userinfoAnnexDO;
    }

    public void setUserinfoAnnexDO(UserinfoAnnexDO userinfoAnnexDO) {
        this.userinfoAnnexDO = userinfoAnnexDO;
    }
}
