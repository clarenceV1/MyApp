package com.wodejia.myapp.server;

/**
 * 房屋
 * Created by clarence on 16/9/2.
 */
public class HouseServerDO {
    /**
     * 房屋编号
     */
    private int houseId;
    /**
     * 业主iD
     */
    private int userId;
    /**
     * 房屋图片
     */
    private String houseIcon;
    /**
     * 哪栋
     */
    private String houseNum;
    /**
     * 房号
     */
    private String houseFloor;
    /**
     * 户型
     */
    private String houseType;
    /**
     * 面积
     */
    private String houseArea;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHouseIcon() {
        return houseIcon;
    }

    public void setHouseIcon(String houseIcon) {
        this.houseIcon = houseIcon;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(String houseFloor) {
        this.houseFloor = houseFloor;
    }
}
