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

import java.util.List;

/**
 * Created by clarence on 16/9/19.
 */
public class BlockAdapter extends BaseAdapter {
    List<BlockRequestDO> blockDOList;
    Context context;
    LayoutInflater layoutInflater;

    public BlockAdapter(Context context, List<BlockRequestDO> blockDOList) {
        this.context = context;
        this.blockDOList = blockDOList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return blockDOList == null ? 0 : blockDOList.size();
    }

    @Override
    public BlockRequestDO getItem(int position) {
        return blockDOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hodler hodler = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.block_fragment_item, null);
            hodler = new Hodler(convertView);
            convertView.setTag(hodler);
        } else {
            hodler = (Hodler) convertView.getTag();
        }
        BlockRequestDO blockDO = getItem(position);
        if (blockDO != null) {
            hodler.tvBlockTitle.setText(blockDO.getBlockTitle());
            hodler.tvBlockSubtitle.setText(blockDO.getBlockSubtitle());
            hodler.tvBlockManager.setText(blockDO.getManagerName());
        }
        Uri uri = Uri.parse(blockDO.getBlockIcon());
        hodler.ivBlockIcon.setImageURI(uri);
        return convertView;
    }

    public class Hodler {
        View view;
        SimpleDraweeView ivBlockIcon;
        TextView tvBlockTitle,tvBlockSubtitle,tvBlockManager;

        public Hodler(View view) {
            this.view = view;
            this.ivBlockIcon = (SimpleDraweeView) view.findViewById(R.id.ivBlockIcon);
            this.tvBlockManager = (TextView) view.findViewById(R.id.tvBlockManager);
            this.tvBlockSubtitle = (TextView) view.findViewById(R.id.tvBlockSubtitle);
            this.tvBlockTitle = (TextView) view.findViewById(R.id.tvBlockTitle);
        }
    }
}
