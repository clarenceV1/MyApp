package com.wodejia.myapp.ui.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.event.ContactsDetailEvent;
import com.wodejia.myapp.table.UserinfoAnnexDO;

/**
 * Created by clarence on 16/8/31.
 */
public class ContactsDetailActivity extends AppActivity {

    int id, type;

    public static void enter(Context context, int id, int type) {
        Intent intent = new Intent();
        intent.setClass(context, ContactsDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constant.EXTRA_ID, id);
        intent.putExtra(Constant.EXTRA_TYPE, type);
        context.startActivity(intent);
    }

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
        configSwitch.evenBusSwitch(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
        getIntents(getIntent());

        Fragment fragment = ContactsDetailBaseFragment.getFragment(type, id, true);
        addFragment(fragment, R.id.flFragment1);
    }

    public void getIntents(Intent intent) {
        if (intent.hasExtra(Constant.EXTRA_ID)) {
            id = intent.getIntExtra(Constant.EXTRA_ID, 0);
        }
        if (intent.hasExtra(Constant.EXTRA_TYPE)) {
            type = intent.getIntExtra(Constant.EXTRA_TYPE, 0);
        }
    }

    public void onEventMainThread(ContactsDetailEvent event) {
        UserinfoAnnexDO annexDO = event.getUserinfoAnnexDO();
        Fragment fragment = null;
        int userId = event.getUserId();
        if (annexDO != null) {
            if (annexDO.getShopId() != 0) {
                fragment = ContactsDetailBaseFragment.getFragment(Constant.SHOP_TYPE, annexDO.getShopId(), false);
            }
            if (annexDO.getOfficeId() != 0) {
                fragment = ContactsDetailBaseFragment.getFragment(Constant.OFFICE_TYPE, annexDO.getOfficeId(), false);
            }
            if (annexDO.getLogisticsId() != 0) {
                fragment = ContactsDetailBaseFragment.getFragment(Constant.LOGISTICS_TYPE, annexDO.getLogisticsId(), false);
            }
        } else if (userId != 0) {
            fragment = ContactsDetailBaseFragment.getFragment(Constant.AREAS_TYPE, userId, false);
        }
        if (fragment != null) {
            addFragment(fragment, R.id.flFragment2);
        }
    }

    private void addFragment(Fragment fragment, int id) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }
}
