package com.wodejia.myapp.ui.contacts;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.controller.contacts.LogisticsDetailController;
import com.wodejia.myapp.data.contacts.LogisticsDetailDO;
import com.wodejia.myapp.data.WeatherInfoDO;
import com.wodejia.myapp.event.ContactsDetailEvent;

import javax.inject.Inject;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/8.
 */
public class LogisticsDetailFragment extends ContactsDetailBaseFragment {

    @BindView(R.id.tvLogisticsName)
    TextView tvLogisticsName;
    @BindView(R.id.sdLogisticsIcon)
    SimpleDraweeView sdLogisticsIcon;

    @Inject
    LogisticsDetailController controller;

    LogisticsDetailDO logisticsDetailRequestDO;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.logistics_detail_fragment;
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
                logisticsDetailRequestDO = controller.getMockData(id);
                if (sendRelative && logisticsDetailRequestDO.getUserId() != 0 ) {
                    EventBus.getDefault().post(new ContactsDetailEvent(logisticsDetailRequestDO.getUserId()));
                }
                initView();
            }
        });
    }

    private void initView() {
        if (logisticsDetailRequestDO != null) {
            tvLogisticsName.setText(logisticsDetailRequestDO.getLogisticsName());
            Uri uri = Uri.parse(logisticsDetailRequestDO.getLogisticsIcon());
            sdLogisticsIcon.setImageURI(uri);
        }
    }
}
