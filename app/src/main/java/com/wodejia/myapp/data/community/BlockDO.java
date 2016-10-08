package com.wodejia.myapp.data.community;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by clarence on 16/9/21.
 */
@Entity
public class BlockDO {
    /**
     * 板块ID
     */
    @Id(autoincrement = true)
    private Long blockId;
    /**
     * 板块标题
     */
    private String blockTitle;
    /**
     * 板块副标题
     */
    private String blockSubtitle;
    /**
     * 板块图标
     */
    private String blockIcon;
    /**
     * 板块管理员
     */
    private long managerId;
    /**
     * 板块管理员名称
     */
    private String managerName;

    @Generated(hash = 1363076618)
    public BlockDO(Long blockId, String blockTitle, String blockSubtitle,
            String blockIcon, long managerId, String managerName) {
        this.blockId = blockId;
        this.blockTitle = blockTitle;
        this.blockSubtitle = blockSubtitle;
        this.blockIcon = blockIcon;
        this.managerId = managerId;
        this.managerName = managerName;
    }

    @Generated(hash = 1061151745)
    public BlockDO() {
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlockTitle() {
        return blockTitle;
    }

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle;
    }

    public String getBlockSubtitle() {
        return blockSubtitle;
    }

    public void setBlockSubtitle(String blockSubtitle) {
        this.blockSubtitle = blockSubtitle;
    }

    public String getBlockIcon() {
        return blockIcon;
    }

    public void setBlockIcon(String blockIcon) {
        this.blockIcon = blockIcon;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
