package com.wodejia.myapp.data;

/**
 * 物流信息
 * Created by clarence on 16/9/2.
 */
public class LogisticsRequetDO extends ContactsBaseDO {
    /**
     * 物流id
     */
    private int logisticsId;
    /**
     * 物流图片
     */
    private String logisticsIcon;
    /**
     * 物流名称
     */
    private String logisticsName;
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

    public int getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(int logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
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

    public String getLogisticsIcon() {
        return logisticsIcon;
    }

    public void setLogisticsIcon(String logisticsIcon) {
        this.logisticsIcon = logisticsIcon;
    }
}
