package com.wodejia.myapp.server;

/**
 * 级别
 * Created by clarence on 16/9/19.
 */
public class PowerServerDO {

    private int powerId;
    /**
     * 级别
     */
    private int powerLevel;
    /**
     * 级别名称
     */
    private String powerName;

    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
}
