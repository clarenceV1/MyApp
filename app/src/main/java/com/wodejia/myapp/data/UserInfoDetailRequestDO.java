package com.wodejia.myapp.data;

/**
 * Created by clarence on 16/9/2.
 */
public class UserInfoDetailRequestDO {
    /**
     * 用户ID
     */
    private int userID;
    /**
     *  用户头像
     */
    private String userIcon;
    /**
     * 用户昵称
     */
    private String userNickname;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号
     */
    private String userTelephone;
    /**
     * 小区名称
     */
    private String areasName;
    /**
     * 户型
     */
    private String houseType;
    /**
     * 面积
     */
    private String houseArea;
    /**
     * 房号
     */
    private String houseNum;
    /**
     * 店铺名
     */
    private String shopName;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
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

    public String getAreasName() {
        return areasName;
    }

    public void setAreasName(String areasName) {
        this.areasName = areasName;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }
}
