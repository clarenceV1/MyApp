package com.wodejia.myapp.manager.manager;

import com.wodejia.myapp.app.AppManager;
import com.wodejia.myapp.data.community.BlockDO;
import com.wodejia.myapp.data.community.BlockDODao;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/19.
 */
public class BlockDOManager extends AppManager {
    BlockDODao blockDODao;

    @Inject
    public BlockDOManager() {
        blockDODao = mDaoSession.getBlockDODao();
    }

    public void insert(BlockDO blockDO) {
        blockDODao.insert(blockDO);
    }

    public List<BlockDO> getBlockList() {
        List<BlockDO> blockList = blockDODao.queryBuilder().build().list();
        return blockList;
    }
}
