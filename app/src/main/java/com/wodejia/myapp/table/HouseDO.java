package com.wodejia.myapp.table;

/**
 * 房屋
 * Created by clarence on 16/9/2.
 */
public class HouseDO extends BaseDO {
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
