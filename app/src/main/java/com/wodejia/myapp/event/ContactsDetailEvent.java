package com.wodejia.myapp.event;

import com.wodejia.myapp.data.UserAnnexinfoDO;

/**
 * Created by clarence on 16/9/8.
 */
public class ContactsDetailEvent {
    UserAnnexinfoDO userinfoAnnexDO;
    private int userId;

    public ContactsDetailEvent(UserAnnexinfoDO userinfoAnnexDO) {
        this.userinfoAnnexDO = userinfoAnnexDO;
    }

    public ContactsDetailEvent(int userId) {
        this.userId = userId;
    }

    public UserAnnexinfoDO getUserinfoAnnexDO() {
        return userinfoAnnexDO;
    }

    public void setUserinfoAnnexDO(UserAnnexinfoDO userinfoAnnexDO) {
        this.userinfoAnnexDO = userinfoAnnexDO;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
