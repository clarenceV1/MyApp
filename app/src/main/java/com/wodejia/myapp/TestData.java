package com.wodejia.myapp;

import com.wodejia.myapp.table.AreasDO;
import com.wodejia.myapp.table.EstateDO;
import com.wodejia.myapp.table.HouseDO;

import java.util.ArrayList;
import java.util.List;

/**
 * 临时存放测试用的数据
 * Created by clarence on 16/9/2.
 */
public class TestData {

    public static EstateDO getProperty(int id) {
        List<EstateDO> estateDOList = getPropertyList();
        for (EstateDO estateDO : estateDOList) {
            if (estateDO.getEstateId() == id) {
                return estateDO;
            }
        }
        return null;
    }

    public static List<EstateDO> getPropertyList() {
        List<EstateDO> estateDOList = new ArrayList<>();
        //房地产
        EstateDO wuyuehua = new EstateDO();
        wuyuehua.setEstateId(1);
        wuyuehua.setEstateName("五月花");
        estateDOList.add(wuyuehua);

        EstateDO haide = new EstateDO();
        haide.setEstateId(1);
        haide.setEstateName("海德");
        estateDOList.add(haide);
        return estateDOList;
    }

    public static AreasDO getAreasDO(int id) {
        List<AreasDO> areasDOList = getAreasDOList();
        for (AreasDO areasDO : areasDOList) {
            if (areasDO.getAreasId() == id) {
                return areasDO;
            }
        }
        return null;
    }

    public static List<AreasDO> getAreasDOList() {
        List<AreasDO> areasDOList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            AreasDO areado = new AreasDO();
            areado.setAreasId(new Long(i + 1));
            areado.setAreasName("五月花" + i + "期");
            areado.setAreasAddress("集美东垵北二里");
            areado.setEstateId(1);
            areasDOList.add(areado);
        }
        return areasDOList;
    }

    public static List<String> getName() {
        List<String> data = new ArrayList<>();
        data.add("广州");
        data.add("北京");
        data.add("河源");
        data.add("襄阳");
        data.add("上海");
        data.add("鞍山");
        data.add("安阳");
        data.add("黄冈");
        data.add("安顺");
        data.add("长治");
        data.add("克州");
        data.add("北海");
        data.add("下治");
        data.add("达州");
        data.add("丽水");
        data.add("湖州");
        data.add("湖里");
        data.add("思明");
        data.add("厦门");
        data.add("悲伤");
        data.add("被吓");
        return data;
    }


    public static HouseDO getHouseDO(int houseId) {
        HouseDO houseDO = new HouseDO();
        houseDO.setHouseId(1);
        houseDO.setHouseNum("1501");
        houseDO.setHouseArea("93平");
        houseDO.setHouseType("3房2厅2卫");
        return houseDO;
    }
}
