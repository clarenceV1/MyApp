package com.wodejia.myapp.data.contacts;

import com.wodejia.myapp.table.UserInfoBaseDO;
import com.wodejia.myapp.table.UserinfoAnnexDO;

/**
 * Created by clarence on 16/9/2.
 */
public class OwnerDetailRequestDO {
    UserInfoBaseDO userInfoBaseDO;
    UserinfoAnnexDO userinfoAnnexDO;

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
