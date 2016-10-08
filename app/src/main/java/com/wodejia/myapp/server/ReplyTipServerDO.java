package com.wodejia.myapp.server;

/**
 * 回帖
 * Created by clarence on 16/9/23.
 */
public class ReplyTipServerDO {
    /**
     * 数据库ID
     */
    private Long replyTipId;
    /**
     * 帖子ID
     */
    private long tipId;
    /**
     * 回复者ID
     */
    private long replyerId;
    /**
     * 回复内容
     */
    private String replyContent;
    /**
     * 回复时间
     */
    private long replyTime;

    public Long getReplyTipId() {
        return replyTipId;
    }

    public void setReplyTipId(Long replyTipId) {
        this.replyTipId = replyTipId;
    }

    public long getTipId() {
        return tipId;
    }

    public void setTipId(long tipId) {
        this.tipId = tipId;
    }

    public long getReplyerId() {
        return replyerId;
    }

    public void setReplyerId(long replyerId) {
        this.replyerId = replyerId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public long getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(long replyTime) {
        this.replyTime = replyTime;
    }
}
