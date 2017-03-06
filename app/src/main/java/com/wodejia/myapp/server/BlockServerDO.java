package com.wodejia.myapp.server;

/**
 * 板块
 * Created by clarence on 16/9/19.
 */
public class BlockServerDO {
    /**
     * 板块ID
     */
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
}
