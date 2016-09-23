package com.wodejia.myapp.manager.manager;

import com.wodejia.myapp.app.AppManager;
import com.wodejia.myapp.data.community.BlockRequestDO;
import com.wodejia.myapp.data.community.BlockRequestDODao;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/19.
 */
public class BlockDOManager extends AppManager {
    BlockRequestDODao blockDODao;

    @Inject
    public BlockDOManager() {
        blockDODao = mDaoSession.getBlockRequestDODao();
    }

    public void insert(BlockRequestDO blockDO) {
        blockDODao.insert(blockDO);
    }

    public List<BlockRequestDO> getBlockList() {
        List<BlockRequestDO> blockList = blockDODao.queryBuilder().build().list();
        return blockList;
    }
}
