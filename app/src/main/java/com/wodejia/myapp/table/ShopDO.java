package com.wodejia.myapp.table;

/**
 * 店铺
 * Created by clarence on 16/9/2.
 */
public class ShopDO extends BaseDO {
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
