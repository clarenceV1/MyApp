package com.wodejia.myapp.ui.contacts;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.controller.contacts.ShopDetailController;
import com.wodejia.myapp.data.contacts.ShopDetailRequestDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.event.ContactsDetailEvent;

import javax.inject.Inject;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/8.
 */
public class ShopDetailFragment extends ContactsDetailBaseFragment {

    @BindView(R.id.tvShopName)
    TextView tvShopName;
    @BindView(R.id.tvShopAddress)
    TextView tvShopAddress;
    @BindView(R.id.sdShopIcon)
    SimpleDraweeView sdShopIcon;

    @Inject
    ShopDetailController controller;

    ShopDetailRequestDO shopDetailRequestDO;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.shop_detail_fragment;
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
                shopDetailRequestDO = controller.getMockData(id);
                initView();
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                shopDetailRequestDO = controller.getMockData(id);
                if (sendRelative && shopDetailRequestDO.getUserId() != 0) {
                    EventBus.getDefault().post(new ContactsDetailEvent(shopDetailRequestDO.getUserId()));
                }
                initView();
            }
        });
    }

    private void initView() {
        if (shopDetailRequestDO != null) {
            tvShopName.setText(shopDetailRequestDO.getShopName());
            tvShopAddress.setText("地址：" + shopDetailRequestDO.getShopAddress());
            Uri uri = Uri.parse(shopDetailRequestDO.getShopIcon());
            sdShopIcon.setImageURI(uri);
        }
    }
}
