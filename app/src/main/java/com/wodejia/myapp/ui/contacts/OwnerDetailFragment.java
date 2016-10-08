package com.wodejia.myapp.ui.contacts;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.controller.contacts.UserDetailController;
import com.wodejia.myapp.data.contacts.OwnerDetailDO;
import com.wodejia.myapp.data.WeatherInfoDO;
import com.wodejia.myapp.event.ContactsDetailEvent;
import com.wodejia.myapp.data.UserBaseInfoDO;

import javax.inject.Inject;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/8.
 */
public class OwnerDetailFragment extends ContactsDetailBaseFragment {

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvTelephone)
    TextView tvTelephone;
    @BindView(R.id.sdUserHeadIcon)
    SimpleDraweeView sdUserHeadIcon;

    @Inject
    UserDetailController controller;

    OwnerDetailDO userInfoDO;

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
        controller.request(new Subscriber<WeatherInfoDO>() {
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
            public void onNext(WeatherInfoDO weatherInfoResponseDO) {
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
            UserBaseInfoDO baseDO = userInfoDO.getUserInfoBaseDO();
            tvName.setText(baseDO.getUserName());
            tvTelephone.setText("tel:" + baseDO.getUserTelephone());
            Uri uri = Uri.parse(baseDO.getUserIcon());
            sdUserHeadIcon.setImageURI(uri);
        }
    }
}
