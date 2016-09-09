package com.wodejia.myapp.ui.contacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.app.Constant;

/**
 * Created by clarence on 16/9/8.
 */
public abstract class ContactsDetailBaseFragment extends AppFragment {

    public int id;
    public boolean sendRelative;

    public static Fragment getFragment(int type, int id, boolean sendRelative) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_ID, id);
        bundle.putBoolean(Constant.EXTRA_SEND_RELATIVE, sendRelative);

        Fragment fragment = null;
        switch (type) {
            case Constant.AREAS_TYPE:
                fragment = new OwnerDetailFragment();
                break;
            case Constant.LOGISTICS_TYPE:
                fragment = new LogisticsDetailFragment();
                break;
            case Constant.SHOP_TYPE:
                fragment = new ShopDetailFragment();
                break;
            case Constant.OFFICE_TYPE:
                fragment = new OfficeDetailFragment();
                break;
        }
        if (fragment != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    protected void initView(View view) {
        getIntents(getArguments());
    }

    public void getIntents(Bundle bundle) {
        id = bundle.getInt(Constant.EXTRA_ID, 0);
        sendRelative = bundle.getBoolean(Constant.EXTRA_SEND_RELATIVE, false);
    }
}
