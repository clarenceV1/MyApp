package com.wodejia.myapp.ui.contacts;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.contacts.ContactsLogisticsDO;

/**
 * 物流
 * Created by clarence on 16/8/30.
 */
public class ContactsLogisticsFragmentAdapter extends ContactsBaseFragmentAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_logistics_fragment_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        Holder holder = (Holder) viewHolder;
        final ContactsLogisticsDO logisticsRequetDO = getItem(position);
        holder.tvLogisticsName.setText(logisticsRequetDO.getLogisticsName());
        holder.tvPhone.setText("电话:" + logisticsRequetDO.getUserTelephone());
        holder.tvUserName.setText(logisticsRequetDO.getUserName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactsDetailActivity.enter(v.getContext(), logisticsRequetDO.getLogisticsId(), Constant.LOGISTICS_TYPE);
            }
        });
        Uri uri = Uri.parse(logisticsRequetDO.getLogisticsIcon());
        holder.ivLogisticsIcon.setImageURI(uri);
    }

    public ContactsLogisticsDO getItem(int position) {
        ContactsLogisticsDO logisticsRequetDO = (ContactsLogisticsDO) items.get(position);
        return logisticsRequetDO;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView tvLogisticsName, tvUserName, tvPhone;
        public SimpleDraweeView ivLogisticsIcon;

        public Holder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvLogisticsName = (TextView) itemView.findViewById(R.id.tvLogisticsName);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
            ivLogisticsIcon = (SimpleDraweeView) itemView.findViewById(R.id.ivLogisticsIcon);
        }
    }
}
