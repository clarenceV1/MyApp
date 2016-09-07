package com.wodejia.myapp.data;

/**
 * 业主信息
 * Created by clarence on 16/9/2.
 */
public class OwnerRequetDO extends ContactsBaseDO {
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 用户头像
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
     * 哪栋
     */
    private String houseNum;
    /**
     * 房号
     */
    private String houseFloor;

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
