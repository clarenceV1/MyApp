package com.wodejia.myapp.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 板块
 * Created by clarence on 16/9/19.
 */
@Entity
public class BlockDO {
    @Id(autoincrement = true)
    private long blockId;
    private String blockName;
    private String blockIcon;

    @Generated(hash = 588163810)
    public BlockDO(long blockId, String blockName, String blockIcon) {
        this.blockId = blockId;
        this.blockName = blockName;
        this.blockIcon = blockIcon;
    }

    @Generated(hash = 1061151745)
    public BlockDO() {
    }

    public long getBlockId() {
        return blockId;
    }

    public void setBlockId(long blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockIcon() {
        return blockIcon;
    }

    public void setBlockIcon(String blockIcon) {
        this.blockIcon = blockIcon;
    }
}
