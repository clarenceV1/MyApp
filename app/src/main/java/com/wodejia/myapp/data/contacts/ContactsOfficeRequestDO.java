package com.wodejia.myapp.data.contacts;

/**
 * 办事处信息
 * Created by clarence on 16/9/2.
 */
public class ContactsOfficeRequestDO extends ContactsBaseRequestDO {
    /**
     * 店铺id
     */
    private int officeId;
    /**
     * 店铺名称
     */
    private String officeName;
    /**
     * 店铺图片
     */
    private String officeIcon;
    /**
     * 店铺地址
     */
    private String officeAddress;
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号
     */
    private String userTelephone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOfficeIcon() {
        return officeIcon;
    }

    public void setOfficeIcon(String officeIcon) {
        this.officeIcon = officeIcon;
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

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }
}
