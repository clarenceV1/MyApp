package com.wodejia.myapp.server;

/**
 * 房地产
 */
public class EstateServerDO {
    /**
     * 房地产编号
     */
    private int estateId;
    /**
     * 房地产图片
     */
    private String estateIcon;
    /**
     * 房地产名称
     */
    private String estateName;

    public String getEstateIcon() {
        return estateIcon;
    }

    public void setEstateIcon(String estateIcon) {
        this.estateIcon = estateIcon;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }
}
