package com.wodejia.myapp.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.app.Constant;

/**
 * Created by clarence on 16/8/31.
 */
public class UserInfoActivity extends AppActivity {

    int userId;

    public static void enter(Context context, int id) {
        Intent intent = new Intent();
        intent.setClass(context, UserInfoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constant.EXTRA_USERID, id);
        context.startActivity(intent);
    }

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
        getIntents(getIntent());
        addUserInfoFragment();
    }

    private void addUserInfoFragment() {
        UserDetailFragment userInfoDetailFragment = new UserDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_USERID, userId);
        userInfoDetailFragment.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.flUserFragment, userInfoDetailFragment);
        transaction.commit();
    }

    public void getIntents(Intent intent) {
        if (intent == null) {
                return;
        }
        if (intent.hasExtra(Constant.EXTRA_USERID)) {
            userId = intent.getIntExtra(Constant.EXTRA_USERID, 0);
        }
    }
}
