package com.wodejia.myapp.contacts;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.controller.UserDetailController;
import com.wodejia.myapp.data.UserInfoDetailRequestDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/8.
 */
public class UserDetailFragment extends AppFragment {

    UserInfoDetailRequestDO userInfoDO;

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvTelephone)
    TextView tvTelephone;
    @BindView(R.id.sdUserHeadIcon)
    SimpleDraweeView sdUserHeadIcon;

    @Inject
    UserDetailController controller;

    int userId;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.userinfo_detail_fragment;
    }

    @Override
    protected void initView(View view) {
        getIntents(getArguments());
        load();
    }

    public void getIntents(Bundle bundle) {
        userId = bundle.getInt(Constant.EXTRA_USERID, 0);
    }

    private void load() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "userInfo is error");
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
