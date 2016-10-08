package com.wodejia.myapp.data.community;

import java.util.List;

/**
 * Created by clarence on 16/10/8.
 */

public class TipsDetailRequestDO {
    /**
     * 贴士标题
     */
    private String tipTitle;
    /**
     * 回复信息
     */
    private List<TipsReplyRequestDO> tipsReplyList;

    public String getTipTitle() {
        return tipTitle;
    }

    public void setTipTitle(String tipTitle) {
        this.tipTitle = tipTitle;
    }

    public List<TipsReplyRequestDO> getTipsReplyList() {
        return tipsReplyList;
    }

    public void setTipsReplyList(List<TipsReplyRequestDO> tipsReplyList) {
        this.tipsReplyList = tipsReplyList;
    }
}
