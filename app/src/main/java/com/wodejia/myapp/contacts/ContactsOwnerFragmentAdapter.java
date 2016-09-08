package com.wodejia.myapp.contacts;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.data.ContactsOwnerRequestDO;

/**
 * 业主
 * Created by clarence on 16/8/30.
 */
public class ContactsOwnerFragmentAdapter extends ContactsBaseFragmentAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_owner_fragment_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        Holder holder = (Holder) viewHolder;
        final ContactsOwnerRequestDO userInfoDO = getItem(position);
        holder.tvName.setText(userInfoDO.getUserName());
        holder.tvPhone.setText("电话:" + userInfoDO.getUserTelephone());
        holder.tvHouseNum.setText("房号：" + userInfoDO.getHouseFloor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfoActivity.enter(v.getContext(), userInfoDO.getUserId());
            }
        });

        Uri uri = Uri.parse(userInfoDO.getUserIcon());
        holder.ivUserIcon.setImageURI(uri);
    }

    public ContactsOwnerRequestDO getItem(int position) {
        ContactsOwnerRequestDO userInfoRequetDO = (ContactsOwnerRequestDO) items.get(position);
        return userInfoRequetDO;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView tvName, tvHouseNum, tvPhone;
        public SimpleDraweeView ivUserIcon;

        public Holder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
            tvHouseNum = (TextView) itemView.findViewById(R.id.tvHouseNum);
            ivUserIcon = (SimpleDraweeView) itemView.findViewById(R.id.ivUserIcon);
        }
    }
}
