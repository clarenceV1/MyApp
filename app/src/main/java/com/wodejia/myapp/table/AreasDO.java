package com.wodejia.myapp.table;

/**
 * 小区
 * Created by clarence on 16/9/2.
 */
public class AreasDO extends BaseDO {
    /**
     * 房地产编号
     */
    private int estateId;
    /**
     * 小区名称
     */
    private String areasName;
    /**
     * 小区地址
     */
    private String areasAddress;

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }

    public String getAreasName() {
        return areasName;
    }

    public void setAreasName(String areasName) {
        this.areasName = areasName;
    }

    public String getAreasAddress() {
        return areasAddress;
    }

    public void setAreasAddress(String areasAddress) {
        this.areasAddress = areasAddress;
    }
}
