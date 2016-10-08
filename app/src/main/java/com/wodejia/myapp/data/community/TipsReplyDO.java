package com.wodejia.myapp.data.community;

/**
 * Created by clarence on 16/10/8.
 */

public class TipsReplyDO {
    /**
     * 数据库ID
     */
    private Long replyId;

    /**
     * 回复内容
     */
    private String replyContent;
    /**
     * 回复时间
     */
    private long replyTime;
    /**
     * 帖子ID
     */
    private long tipId;
    /**
     * 回复者ID
     */
    private long replyerId;
    /**
     * 发帖者昵称
     */
    private String replyerNickname;
    /**
     * 发帖者头像
     */
    private String replyerIcon;
    /**
     * 楼层 楼主==0层
     */
    private int floor = -1;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public long getTipId() {
        return tipId;
    }

    public void setTipId(long tipId) {
        this.tipId = tipId;
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

    public long getReplyerId() {
        return replyerId;
    }

    public void setReplyerId(long replyerId) {
        this.replyerId = replyerId;
    }

    public String getReplyerNickname() {
        return replyerNickname;
    }

    public void setReplyerNickname(String replyerNickname) {
        this.replyerNickname = replyerNickname;
    }

    public String getReplyerIcon() {
        return replyerIcon;
    }

    public void setReplyerIcon(String replyerIcon) {
        this.replyerIcon = replyerIcon;
    }
}
