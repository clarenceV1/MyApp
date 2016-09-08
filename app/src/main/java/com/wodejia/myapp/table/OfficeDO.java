package com.wodejia.myapp.table;

/**
 * 办事处
 * Created by clarence on 16/9/2.
 */
public class OfficeDO{
    private int officeId;
    /**
     *名称
     */
    private String officeName;
    /**
     * 店铺图片
     */
    private String officeIcon;
    /**
     * 电话
     */
    private String officePhone;
    /**
     * 地址
     */
    private String officeAddress;

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeIcon() {
        return officeIcon;
    }

    public void setOfficeIcon(String officeIcon) {
        this.officeIcon = officeIcon;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }
}
