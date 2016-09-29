package com.wodejia.myapp.manager.manager;

import com.wodejia.myapp.app.AppManager;
import com.wodejia.myapp.data.community.TipsRequestDO;
import com.wodejia.myapp.data.community.TipsRequestDODao;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/19.
 */
public class TipsDOManager extends AppManager {
    TipsRequestDODao tipsDao;

    @Inject
    public TipsDOManager() {
        tipsDao = mDaoSession.getTipsRequestDODao();
    }

    public void insert(TipsRequestDO tipsRequestDO) {
        tipsDao.insert(tipsRequestDO);
    }

    public List<TipsRequestDO> getTipsList() {
        List<TipsRequestDO> blockList = tipsDao.queryBuilder().build().list();
        return blockList;
    }
}
