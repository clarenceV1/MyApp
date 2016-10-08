package com.wodejia.myapp.server;

/**
 * 帖子model
 * Created by clarence on 16/9/23.
 */

public class TipServerDO {
    /**
     * 帖子编号
     */
    private Long tipsId;
    /**
     * 板块编号
     */
    private long blockId;
    /**
     *  发布者编号
     */
    private long publishId;
    /**
     * 贴士标题
     */
    private String tipTitle;
    /**
     * 贴士内容
     */
    private String tipContent;
    /**
     * 发布时间
     */
    private long publishTime;

    public Long getTipsId() {
        return tipsId;
    }

    public void setTipsId(Long tipsId) {
        this.tipsId = tipsId;
    }

    public long getBlockId() {
        return blockId;
    }

    public void setBlockId(long blockId) {
        this.blockId = blockId;
    }

    public long getPublishId() {
        return publishId;
    }

    public void setPublishId(long publishId) {
        this.publishId = publishId;
    }

    public String getTipTitle() {
        return tipTitle;
    }

    public void setTipTitle(String tipTitle) {
        this.tipTitle = tipTitle;
    }

    public String getTipContent() {
        return tipContent;
    }

    public void setTipContent(String tipContent) {
        this.tipContent = tipContent;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }
}
