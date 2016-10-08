package com.wodejia.myapp.data.contacts;

import com.wodejia.myapp.data.UserBaseInfoDO;
import com.wodejia.myapp.data.UserAnnexinfoDO;

/**
 * Created by clarence on 16/9/2.
 */
public class OwnerDetailDO {
    UserBaseInfoDO userInfoBaseDO;
    UserAnnexinfoDO userinfoAnnexDO;

    public UserBaseInfoDO getUserInfoBaseDO() {
        return userInfoBaseDO;
    }

    public void setUserInfoBaseDO(UserBaseInfoDO userInfoBaseDO) {
        this.userInfoBaseDO = userInfoBaseDO;
    }

    public UserAnnexinfoDO getUserinfoAnnexDO() {
        return userinfoAnnexDO;
    }

    public void setUserinfoAnnexDO(UserAnnexinfoDO userinfoAnnexDO) {
        this.userinfoAnnexDO = userinfoAnnexDO;
    }
}
