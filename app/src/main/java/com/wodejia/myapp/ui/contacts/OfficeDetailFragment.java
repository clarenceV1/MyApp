package com.wodejia.myapp.ui.contacts;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.controller.contacts.OfficeDetailController;
import com.wodejia.myapp.data.contacts.OfficeDetailDO;
import com.wodejia.myapp.data.WeatherInfoDO;
import com.wodejia.myapp.event.ContactsDetailEvent;

import javax.inject.Inject;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/8.
 */
public class OfficeDetailFragment extends ContactsDetailBaseFragment {

    @BindView(R.id.tvOfficeName)
    TextView tvOfficeName;
    @BindView(R.id.tvOfficePhone)
    TextView tvOfficePhone;
    @BindView(R.id.tvOfficeAddress)
    TextView tvOfficeAddress;
    @BindView(R.id.sdOfficeIcon)
    SimpleDraweeView sdOfficeIcon;

    @Inject
    OfficeDetailController controller;

    OfficeDetailDO officeDetailRequestDO;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.office_detail_fragment;
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
                ToastUtils.showToast(getContext(), "officeInfo is error");
            }

            @Override
            public void onNext(WeatherInfoDO weatherInfoResponseDO) {
                officeDetailRequestDO = controller.getMockData(id);
                if (sendRelative && officeDetailRequestDO.getUserId() != 0 ) {
                    EventBus.getDefault().post(new ContactsDetailEvent(officeDetailRequestDO.getUserId()));
                }
                initView();
            }
        });
    }

    private void initView() {
        if (officeDetailRequestDO != null) {
            tvOfficeName.setText(officeDetailRequestDO.getOfficeName());
            tvOfficeAddress.setText("addr: " + officeDetailRequestDO.getOfficeAddress());
            Uri uri = Uri.parse(officeDetailRequestDO.getOfficeIcon());
            sdOfficeIcon.setImageURI(uri);
        }
    }
}
