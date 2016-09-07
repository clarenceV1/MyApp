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
import com.wodejia.myapp.data.OfficeRequetDO;

/**
 * 办事处
 * Created by clarence on 16/8/30.
 */
public class ContactsOfficeFragmentAdapter extends ContactsBaseFragmentAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_office_fragment_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        Holder holder = (Holder) viewHolder;
        final OfficeRequetDO officeRequetDO = getItem(position);
        holder.tvOfficeName.setText(officeRequetDO.getOfficeName());
        holder.tvOfficePhone.setText("电话:" + officeRequetDO.getUserTelephone());
        holder.tvOfficeAddress.setText(officeRequetDO.getOfficeAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(v.getContext(), "还没弄");
            }
        });
        Uri uri = Uri.parse(officeRequetDO.getOfficeIcon());
        holder.ivOfficeIcon.setImageURI(uri);
    }

    public OfficeRequetDO getItem(int position) {
        OfficeRequetDO officeRequetDO = (OfficeRequetDO) items.get(position);
        return officeRequetDO;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView tvOfficeName, tvOfficePhone, tvOfficeAddress;
        public SimpleDraweeView ivOfficeIcon;
        public Holder(View itemView) {
            super(itemView);
            tvOfficeName = (TextView) itemView.findViewById(R.id.tvOfficeName);
            tvOfficePhone = (TextView) itemView.findViewById(R.id.tvOfficePhone);
            tvOfficeAddress = (TextView) itemView.findViewById(R.id.tvOfficeAddress);
            ivOfficeIcon = (SimpleDraweeView) itemView.findViewById(R.id.ivOfficeIcon);
        }
    }
}
