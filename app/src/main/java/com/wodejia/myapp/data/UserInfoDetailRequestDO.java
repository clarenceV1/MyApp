package com.wodejia.myapp.data;

/**
 * Created by clarence on 16/9/2.
 */
public class UserInfoDetailRequestDO {
    /**
     *用户id
     */
    private int userId;
    /**
     *用户昵称
     */
    private String userNickname;
    /**
     *  用户头像
     */
    private String userIcon;
    /**
     * 用户名
     */
    private String userName;
    /**
     * userQq
     */
    private String userQq;
    /**
     * 微信
     */
    private String userWechat;
    /**
     * 手机号
     */
    private String userTelephone;

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
