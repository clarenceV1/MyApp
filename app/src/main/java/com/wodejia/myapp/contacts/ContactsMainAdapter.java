package com.wodejia.myapp.contacts;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;

import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.ContactsMenuRequestDO;

import java.util.List;

/**
 * Created by clarence on 16/7/14.
 */
public class ContactsMainAdapter extends FragmentStatePagerAdapter {
    List<ContactsMenuRequestDO> contactsRequestDOList;
    Context context;

    public ContactsMainAdapter(FragmentManager fm, Context context, List<ContactsMenuRequestDO> contactsRequestDOList) {
        super(fm);
        this.context = context;
        this.contactsRequestDOList = contactsRequestDOList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return contactsRequestDOList.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ContactsRequestDO", contactsRequestDOList.get(position));
        return Fragment.instantiate(context, getFragmentName(contactsRequestDOList.get(position).getKey()), bundle);
    }

    @Override
    public int getCount() {
        return contactsRequestDOList == null ? 0 : contactsRequestDOList.size();
    }

    public String getFragmentName(String key) {
        if (!TextUtils.isEmpty(key)) {
            if (key.equals(Constant.LOGISTICS_TYPE)) { //物流
                return ContactsLogisticsFragment.class.getName();
            } else if (key.equals(Constant.OFFICE_TYPE)) { //办事处
                return ContactsOfficeFragment.class.getName();
            } else if (key.equals(Constant.SHOP_TYPE)) { //店铺
                return ContactsShopFragment.class.getName();
            }
        }
        return ContactsOwnerFragment.class.getName(); //业主
    }
}
