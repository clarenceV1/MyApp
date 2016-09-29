package com.wodejia.myapp.table;

/**
 * 用户基本信息表
 * Created by clarence on 16/8/31.
 */
public class UserInfoBaseDO {
    /**
     * 用户ID---表ID
     */
    private int userId;
    /**
     * 用户昵称
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
    /**
     * 等级
     * @return
     */
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
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

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }
}
