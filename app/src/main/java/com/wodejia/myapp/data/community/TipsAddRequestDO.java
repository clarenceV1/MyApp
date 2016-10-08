package com.wodejia.myapp.data.community;

/**
 * Created by clarence on 16/9/29.
 */
public class TipsAddRequestDO {
    /**
     * 板块ID
     */
    private int blockId;
    /**
     * 贴子标题
     */
    private String tipTitle;
    /**
     * 帖子内容
     */
    private String tipContent;
    /**
     * 发帖者ID
     */
    private int producterId;

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
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

    public int getProducterId() {
        return producterId;
    }

    public void setProducterId(int producterId) {
        this.producterId = producterId;
    }
}
