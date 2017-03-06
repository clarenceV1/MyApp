package com.wodejia.myapp.server;

/**
 * Created by clarence on 16/10/11.
 */

public class CarServerDO {
    private int carId;
    /**
     * 车牌
     */
    private String numberPlates;
    private int userId;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(String numberPlates) {
        this.numberPlates = numberPlates;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
