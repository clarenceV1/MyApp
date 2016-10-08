package com.wodejia.myapp.ui.contacts;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.data.contacts.ContactsMenuDO;

import java.util.List;

/**
 * Created by clarence on 16/7/14.
 */
public class ContactsMainAdapter extends FragmentStatePagerAdapter {
    List<ContactsMenuDO> contactsRequestDOList;
    Context context;

    public ContactsMainAdapter(FragmentManager fm, Context context, List<ContactsMenuDO> contactsRequestDOList) {
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

    public String getFragmentName(int type) {
        String title = "出错了";
        switch (type) {
            case Constant.AREAS_TYPE:
                title = ContactsOwnerFragment.class.getName(); //业主
                break;
            case Constant.LOGISTICS_TYPE:
                title = ContactsLogisticsFragment.class.getName();
                break;
            case Constant.SHOP_TYPE:
                title = ContactsShopFragment.class.getName();
                break;
            case Constant.OFFICE_TYPE:
                title = ContactsOfficeFragment.class.getName();
                break;
        }
        return title;
    }
}
