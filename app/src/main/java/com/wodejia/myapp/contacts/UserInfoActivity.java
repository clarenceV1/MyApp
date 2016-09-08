package com.wodejia.myapp.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.event.ShopEvent;
import com.wodejia.myapp.event.UserEvent;
import com.wodejia.myapp.table.UserinfoAnnexDO;

/**
 * Created by clarence on 16/8/31.
 */
public class UserInfoActivity extends AppActivity {

    int userId;

    public static void enter(Context context, int id) {
        Intent intent = new Intent();
        intent.setClass(context, UserInfoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constant.EXTRA_USER_ID, id);
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

        UserDetailFragment userInfoDetailFragment = new UserDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_USER_ID, userId);
        bundle.putBoolean(Constant.EXTRA_SEND_RELATIVE, true);
        userInfoDetailFragment.setArguments(bundle);
        addFragment(userInfoDetailFragment, R.id.flUserFragment);
    }

    private void addFragment(Fragment fragment, int id) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }

    public void getIntents(Intent intent) {
        if (intent == null) {
            return;
        }
        if (intent.hasExtra(Constant.EXTRA_USER_ID)) {
            userId = intent.getIntExtra(Constant.EXTRA_USER_ID, 0);
        }
    }

    public void onEventMainThread(UserEvent event) {
        UserinfoAnnexDO annexDO = event.getUserinfoAnnexDO();
        ShopDetailFragment userInfoDetailFragment = new ShopDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_SHOP_ID, annexDO.getShopId());
        bundle.putBoolean(Constant.EXTRA_SEND_RELATIVE, false);
        userInfoDetailFragment.setArguments(bundle);
        addFragment(userInfoDetailFragment, R.id.flShopFragment);
    }
}
