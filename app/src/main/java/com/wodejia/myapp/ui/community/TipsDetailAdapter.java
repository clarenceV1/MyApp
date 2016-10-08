package com.wodejia.myapp.ui.community;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.data.community.TipsReplyDO;

import java.util.List;

/**
 * Created by clarence on 16/9/29.
 */

public class TipsDetailAdapter extends BaseAdapter {
    List<TipsReplyDO> tipsReplyList;
    Context context;
    LayoutInflater layoutInflater;

    public TipsDetailAdapter(Context context, List<TipsReplyDO> tipsReplyList) {
        this.context = context;
        this.tipsReplyList = tipsReplyList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tipsReplyList == null ? 0 : tipsReplyList.size();
    }

    @Override
    public TipsReplyDO getItem(int position) {
        return tipsReplyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hodler hodler = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.tips_detail_item, null);
            hodler = new Hodler(convertView);
            convertView.setTag(hodler);
        } else {
            hodler = (Hodler) convertView.getTag();
        }
        TipsReplyDO tipsRequestDO = getItem(position);
        if (tipsRequestDO != null) {
            hodler.tvReplyerContent.setText(tipsRequestDO.getReplyContent());
            hodler.tvReplyerNickName.setText(tipsRequestDO.getReplyerNickname());
            hodler.tvReplyerTime.setText(tipsRequestDO.getReplyTime() + "");
            Uri uri = Uri.parse(tipsRequestDO.getReplyerIcon());
            hodler.ivReplyerIcon.setImageURI(uri);
        }
        return convertView;
    }

    public class Hodler {
        View view;
        TextView tvReplyerContent, tvReplyerNickName, tvReplyerTime;
        SimpleDraweeView ivReplyerIcon;

        public Hodler(View view) {
            this.view = view;
            this.tvReplyerContent = (TextView) view.findViewById(R.id.tvReplyerContent);
            this.tvReplyerNickName = (TextView) view.findViewById(R.id.tvReplyerNickName);
            this.tvReplyerTime = (TextView) view.findViewById(R.id.tvReplyerTime);
            this.ivReplyerIcon = (SimpleDraweeView) view.findViewById(R.id.ivReplyerIcon);
        }
    }
}
