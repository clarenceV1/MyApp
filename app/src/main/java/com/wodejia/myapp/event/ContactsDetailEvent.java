package com.wodejia.myapp.event;

import com.wodejia.myapp.table.UserinfoAnnexDO;

/**
 * Created by clarence on 16/9/8.
 */
public class ContactsDetailEvent {
    UserinfoAnnexDO userinfoAnnexDO;
    private int userId;

    public ContactsDetailEvent(UserinfoAnnexDO userinfoAnnexDO) {
        this.userinfoAnnexDO = userinfoAnnexDO;
    }

    public ContactsDetailEvent(int userId) {
        this.userId = userId;
    }

    public UserinfoAnnexDO getUserinfoAnnexDO() {
        return userinfoAnnexDO;
    }

    public void setUserinfoAnnexDO(UserinfoAnnexDO userinfoAnnexDO) {
        this.userinfoAnnexDO = userinfoAnnexDO;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
