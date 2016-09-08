package com.wodejia.myapp.app;

/**
 * Created by clarence on 16/9/5.
 */
public class Constant {
    /**
     * 小区
     */
    public static final int AREAS_TYPE = 1;
    /**
     * 物流
     */
    public static final int LOGISTICS_TYPE = AREAS_TYPE + 1;
    /**
     * 店铺
     */
    public static final int SHOP_TYPE = LOGISTICS_TYPE + 1;
    /**
     * 办事处
     */
    public static final int OFFICE_TYPE = SHOP_TYPE + 1;


    public static final String EXTRA_TYPE = "type";
    public static final String EXTRA_ID = "id";
    public static final String EXTRA_SEND_RELATIVE = "sendRelative";
}
