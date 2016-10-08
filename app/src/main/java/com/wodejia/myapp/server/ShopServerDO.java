package com.wodejia.myapp.server;

/**
 * 店铺
 * Created by clarence on 16/9/2.
 */
public class ShopServerDO {
    /**
     * 店铺ID
     */
    private int shopId;
    /**
     * 老板ID
     */
    private int userId;
    /**
     * 店铺名
     */
    private String shopName;
    /**
     * 店铺图片
     */
    private String shopIcon;
    /**
     * 店铺地址
     */
    private String shopAddress;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopIcon() {
        return shopIcon;
    }

    public void setShopIcon(String shopIcon) {
        this.shopIcon = shopIcon;
    }
}
