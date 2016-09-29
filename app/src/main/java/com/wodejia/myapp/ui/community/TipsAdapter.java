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
import com.wodejia.myapp.data.community.BlockRequestDO;
import com.wodejia.myapp.data.community.TipsRequestDO;

import java.util.List;

/**
 * Created by clarence on 16/9/29.
 */

public class TipsAdapter extends BaseAdapter {
    List<TipsRequestDO> tipsRequestDOList;
    Context context;
    LayoutInflater layoutInflater;

    public TipsAdapter(Context context, List<TipsRequestDO> tipsRequestDOList) {
        this.context = context;
        this.tipsRequestDOList = tipsRequestDOList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tipsRequestDOList == null ? 0 : tipsRequestDOList.size();
    }

    @Override
    public TipsRequestDO getItem(int position) {
        return tipsRequestDOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hodler hodler = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.tips_item, null);
            hodler = new Hodler(convertView);
            convertView.setTag(hodler);
        } else {
            hodler = (Hodler) convertView.getTag();
        }
        TipsRequestDO tipsRequestDO = getItem(position);
        if (tipsRequestDO != null) {
            hodler.tvTipsTitle.setText(tipsRequestDO.getTipTitle());
            hodler.tvProducterName.setText(tipsRequestDO.getProducterName());
            hodler.tvUpdateTime.setText(tipsRequestDO.getUpdateTime() + "");
            hodler.tvReplyNum.setText(tipsRequestDO.getReplyNum() + "");
        }
        return convertView;
    }

    public class Hodler {
        View view;
        TextView tvTipsTitle, tvProducterName, tvUpdateTime, tvReplyNum;

        public Hodler(View view) {
            this.view = view;
            this.tvTipsTitle = (TextView) view.findViewById(R.id.tvTipsTitle);
            this.tvProducterName = (TextView) view.findViewById(R.id.tvProducterName);
            this.tvUpdateTime = (TextView) view.findViewById(R.id.tvUpdateTime);
            this.tvReplyNum = (TextView) view.findViewById(R.id.tvReplyNum);
        }
    }
}
