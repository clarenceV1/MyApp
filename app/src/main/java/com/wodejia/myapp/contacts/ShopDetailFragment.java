package com.wodejia.myapp.contacts;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.app.Constant;
import com.wodejia.myapp.controller.ShopDetailController;
import com.wodejia.myapp.data.ShopDetailRequestDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.event.ContactsDetailEvent;

import javax.inject.Inject;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/8.
 */
public class ShopDetailFragment extends AppFragment {

    @BindView(R.id.tvShopName)
    TextView tvShopName;
    @BindView(R.id.tvShopAddress)
    TextView tvShopAddress;
    @BindView(R.id.sdShopIcon)
    SimpleDraweeView sdShopIcon;

    @Inject
    ShopDetailController controller;

    int shopId;
    ShopDetailRequestDO shopDetailRequestDO;
    boolean sendRelative;

    /**
     * 获取商店fragment
     * @param shopId
     * @return
     */
    public static Fragment getShopFragment(int shopId, boolean sendRelative){
        ShopDetailFragment shopDetailFragment = new ShopDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_ID, shopId);
        bundle.putBoolean(Constant.EXTRA_SEND_RELATIVE, sendRelative);
        shopDetailFragment.setArguments(bundle);
        return shopDetailFragment;
    }

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
        getIntents(getArguments());
        load();
    }

    public void getIntents(Bundle bundle) {
        shopId = bundle.getInt(Constant.EXTRA_ID, 0);
    }

    private void load() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "userInfo is error");
                shopDetailRequestDO = controller.getMockData(shopId);
                initView();
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                shopDetailRequestDO = controller.getMockData(shopId);
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
