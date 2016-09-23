package com.wodejia.myapp.data.contacts;

/**
 * 店铺信息
 * Created by clarence on 16/9/2.
 */
public class ContactsShopRequestDO extends ContactsBaseRequestDO {
    /**
     * 店铺id
     */
    private int shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺图片
     */
    private String shopIcon;
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

    public String getShopIcon() {
        return shopIcon;
    }

    public void setShopIcon(String shopIcon) {
        this.shopIcon = shopIcon;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }
}
