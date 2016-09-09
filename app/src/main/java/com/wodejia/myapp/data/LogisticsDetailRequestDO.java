package com.wodejia.myapp.data;

/**
 * Created by clarence on 16/9/9.
 */
public class LogisticsDetailRequestDO {
    /**
     * 物流ID
     */
    private int logisticsId;
    /**
     * 负责人ID
     */
    private int userId;
    /**
     * 物流名称
     */
    private String logisticsName;
    /**
     * 物流图片
     */
    private String logisticsIcon;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public String getLogisticsIcon() {
        return logisticsIcon;
    }

    public void setLogisticsIcon(String logisticsIcon) {
        this.logisticsIcon = logisticsIcon;
    }
}
