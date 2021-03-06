package com.wodejia.myapp.data;

/**
 * 用户信息附属表
 * Created by clarence on 16/9/2.
 */
public class UserAnnexinfoDO {
    /**
     * 表ID
     */
    private int userAnnexId;
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 小区ID
     */
    private int areasId;
    /**
     * 房屋id
     */
    private int houseId;
    /**
     * 物流id
     */
    private int logisticsId;

    /**
     * 店铺ID
     */
    private int shopId;
    /**
     * 物业ID
     */
    private int propertyId;
    /**
     * 办事处ID
     */
    private int officeId;
    /**
     * 汽车信息
     */
    private int carId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAreasId() {
        return areasId;
    }

    public void setAreasId(int areasId) {
        this.areasId = areasId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(int logisticsId) {
        this.logisticsId = logisticsId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getUserAnnexId() {
        return userAnnexId;
    }

    public void setUserAnnexId(int userAnnexId) {
        this.userAnnexId = userAnnexId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}
