package com.wodejia.myapp.data.community;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by clarence on 16/9/29.
 */
@Entity
public class TipsRequestDO{
    /**
     * 帖子ID
     */
    @Id(autoincrement = true)
    private Long  tipId;
    /**
     * 贴子标题
     */
    private String tipTitle;
    /**
     * 帖子最后更新时间
     */
    private String updateTime;
    /**
     * 帖子回复数
     */
    private int replyNum;
    /**
     * 发帖者ID
     */
    private int producterId;
    /**
     * 发帖者昵称
     */
    private String producterName;

    @Generated(hash = 1945969979)
    public TipsRequestDO(Long tipId, String tipTitle, String updateTime,
            int replyNum, int producterId, String producterName) {
        this.tipId = tipId;
        this.tipTitle = tipTitle;
        this.updateTime = updateTime;
        this.replyNum = replyNum;
        this.producterId = producterId;
        this.producterName = producterName;
    }

    @Generated(hash = 1693914609)
    public TipsRequestDO() {
    }

    public Long getTipId() {
        return tipId;
    }

    public void setTipId(Long tipId) {
        this.tipId = tipId;
    }

    public String getTipTitle() {
        return tipTitle;
    }

    public void setTipTitle(String tipTitle) {
        this.tipTitle = tipTitle;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public int getProducterId() {
        return producterId;
    }

    public void setProducterId(int producterId) {
        this.producterId = producterId;
    }

    public String getProducterName() {
        return producterName;
    }

    public void setProducterName(String producterName) {
        this.producterName = producterName;
    }
}
