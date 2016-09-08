package com.wodejia.myapp.event;

import com.wodejia.myapp.table.UserinfoAnnexDO;

/**
 * Created by clarence on 16/9/8.
 */
public class UserEvent {
    UserinfoAnnexDO userinfoAnnexDO;

    public UserEvent(UserinfoAnnexDO userinfoAnnexDO) {
        this.userinfoAnnexDO = userinfoAnnexDO;
    }

    public UserinfoAnnexDO getUserinfoAnnexDO() {
        return userinfoAnnexDO;
    }

    public void setUserinfoAnnexDO(UserinfoAnnexDO userinfoAnnexDO) {
        this.userinfoAnnexDO = userinfoAnnexDO;
    }
}
