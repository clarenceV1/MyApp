package com.wodejia.myapp.data.contacts;

/**
 * Created by clarence on 16/9/9.
 */
public class OfficeDetailDO {
    /**
     * 办事处ID
     */
    private int officeId;
    /**
     * 负责人ID
     */
    private int userId;
    /**
     * 名称
     */
    private String officeName;
    /**
     * 店铺图片
     */
    private String officeIcon;
    /**
     * 地址
     */
    private String officeAddress;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeIcon() {
        return officeIcon;
    }

    public void setOfficeIcon(String officeIcon) {
        this.officeIcon = officeIcon;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }
}
