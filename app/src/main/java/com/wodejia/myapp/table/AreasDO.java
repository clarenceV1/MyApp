package com.wodejia.myapp.table;

/**
 * 小区
 * Created by clarence on 16/9/2.
 */
public class AreasDO {
    /**
     * 小区编号
     */
    private Long areasId;
    /**
     * 房地产编号
     */
    private int estateId;
    /**
     * 小区图片
     */
    private String areasIcon;
    /**
     * 小区名称
     */
    private String areasName;
    /**
     * 小区地址
     */
    private String areasAddress;

    public String getAreasIcon() {
        return areasIcon;
    }

    public void setAreasIcon(String areasIcon) {
        this.areasIcon = areasIcon;
    }

    public Long getAreasId() {
        return areasId;
    }

    public void setAreasId(Long areasId) {
        this.areasId = areasId;
    }

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
