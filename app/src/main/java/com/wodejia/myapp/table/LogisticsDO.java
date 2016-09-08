package com.wodejia.myapp.table;

/**
 * 物流
 * Created by clarence on 16/9/2.
 */
public class LogisticsDO {
    private int logisticsId;
    /**
     * 物流名称
     */
    private String logisticsName;
    /**
     * 物流图片
     */
    private String logisticsIcon;

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
