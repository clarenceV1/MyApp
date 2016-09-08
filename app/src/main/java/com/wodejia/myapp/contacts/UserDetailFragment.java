package com.wodejia.myapp.contacts;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.controller.UserDetailController;
import com.wodejia.myapp.data.UserInfoDetailRequestDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.event.ContactsDetailEvent;
import com.wodejia.myapp.table.UserInfoBaseDO;

import javax.inject.Inject;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/8.
 */
public class UserDetailFragment extends ContactsDetailBaseFragment {

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvTelephone)
    TextView tvTelephone;
    @BindView(R.id.sdUserHeadIcon)
    SimpleDraweeView sdUserHeadIcon;

    @Inject
    UserDetailController controller;

    UserInfoDetailRequestDO userInfoDO;

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
        super.initView(view);
        load();
    }

    private void load() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "userInfo is error");
                userInfoDO = controller.getMockData(id, sendRelative);
                if (sendRelative && userInfoDO.getUserinfoAnnexDO() != null) {
                    EventBus.getDefault().post(new ContactsDetailEvent(userInfoDO.getUserinfoAnnexDO()));
                }
                initView();
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                userInfoDO = controller.getMockData(id, sendRelative);
                if (sendRelative && userInfoDO.getUserinfoAnnexDO() != null) {
                    EventBus.getDefault().post(new ContactsDetailEvent(userInfoDO.getUserinfoAnnexDO()));
                }
                initView();
            }
        });
    }

    private void initView() {
        if (userInfoDO != null && userInfoDO.getUserInfoBaseDO() != null) {
            UserInfoBaseDO baseDO = userInfoDO.getUserInfoBaseDO();
            tvName.setText(baseDO.getUserName());
            tvTelephone.setText("tel:" + baseDO.getUserTelephone());
            Uri uri = Uri.parse(baseDO.getUserIcon());
            sdUserHeadIcon.setImageURI(uri);
        }
    }
}
