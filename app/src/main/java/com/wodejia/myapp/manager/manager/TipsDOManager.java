package com.wodejia.myapp.manager.manager;

import com.wodejia.myapp.app.AppManager;
import com.wodejia.myapp.data.community.TipsDO;
import com.wodejia.myapp.data.community.TipsDODao;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/19.
 */
public class TipsDOManager extends AppManager {
    TipsDODao tipsDao;

    @Inject
    public TipsDOManager() {
        tipsDao = mDaoSession.getTipsDODao();
    }

    public void insert(TipsDO tipsRequestDO) {
        tipsDao.insert(tipsRequestDO);
    }

    public List<TipsDO> getTipsList(int blockId) {
        List<TipsDO> blockList = tipsDao.queryBuilder()
                .where(TipsDODao.Properties.BlockId.eq(blockId)).build().list();
        return blockList;
    }
}
