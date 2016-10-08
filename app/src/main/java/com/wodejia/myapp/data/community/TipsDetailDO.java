package com.wodejia.myapp.data.community;

import java.util.List;

/**
 * Created by clarence on 16/10/8.
 */

public class TipsDetailDO {
    /**
     * 贴士标题
     */
    private String tipTitle;
    /**
     * 回复信息
     */
    private List<TipsReplyDO> tipsReplyList;

    public String getTipTitle() {
        return tipTitle;
    }

    public void setTipTitle(String tipTitle) {
        this.tipTitle = tipTitle;
    }

    public List<TipsReplyDO> getTipsReplyList() {
        return tipsReplyList;
    }

    public void setTipsReplyList(List<TipsReplyDO> tipsReplyList) {
        this.tipsReplyList = tipsReplyList;
    }
}
