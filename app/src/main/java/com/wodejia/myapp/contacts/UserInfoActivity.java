package com.wodejia.myapp.contacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.controller.UserInfoController;
import com.wodejia.myapp.data.UserInfoDetailRequestDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by clarence on 16/8/31.
 */
public class UserInfoActivity extends AppActivity {

    public static final String EXTRA_USERID = "userId";

    int userId;
    UserInfoDetailRequestDO userInfoDO;

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvTelephone)
    TextView tvTelephone;
    @BindView(R.id.sdUserHeadIcon)
    SimpleDraweeView sdUserHeadIcon;

    @Inject
    UserInfoController controller;

    public static void enter(Context context, int id) {
        Intent intent = new Intent();
        intent.setClass(context, UserInfoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_USERID, id);
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
        ButterKnife.bind(this);
        getIntents(getIntent());
        load();
    }

    public void getIntents(Intent intent) {
        if (intent == null) {
            return;
        }
        if (intent.hasExtra(EXTRA_USERID)) {
            userId = intent.getIntExtra(EXTRA_USERID, 0);
        }
    }

    private void load() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(UserInfoActivity.this, "userInfo is error");
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                userInfoDO = controller.getMockData(userId);
                initView();
            }
        });
    }

    private void initView() {
        if (userInfoDO != null) {
            tvName.setText(userInfoDO.getUserName());
            tvTelephone.setText("tel:" + userInfoDO.getUserTelephone());
            Uri uri = Uri.parse(userInfoDO.getUserIcon());
            sdUserHeadIcon.setImageURI(uri);
        }
    }
}
