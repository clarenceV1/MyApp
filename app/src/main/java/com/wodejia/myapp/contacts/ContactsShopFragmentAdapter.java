package com.wodejia.myapp.contacts;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.data.ShopRequetDO;

/**
 * 店铺
 * Created by clarence on 16/8/30.
 */
public class ContactsShopFragmentAdapter extends ContactsBaseFragmentAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_shop_fragment_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        Holder holder = (Holder) viewHolder;
        final ShopRequetDO shopRequetDO = getItem(position);
        holder.tvShopName.setText(shopRequetDO.getShopName());
        holder.tvUserName.setText(shopRequetDO.getUserName());
        holder.tvPhone.setText("电话:" + shopRequetDO.getUserTelephone());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(v.getContext(), "还没弄");
            }
        });
        Uri uri = Uri.parse(shopRequetDO.getShopIcon());
        holder.ivShopIcon.setImageURI(uri);
    }

    public ShopRequetDO getItem(int position) {
        ShopRequetDO shopRequetDO = (ShopRequetDO) items.get(position);
        return shopRequetDO;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView tvShopName, tvUserName, tvPhone;
        public SimpleDraweeView ivShopIcon;

        public Holder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvShopName = (TextView) itemView.findViewById(R.id.tvShopName);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
            ivShopIcon = (SimpleDraweeView) itemView.findViewById(R.id.ivShopIcon);
        }
    }
}
