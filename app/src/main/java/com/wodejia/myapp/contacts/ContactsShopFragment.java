package com.wodejia.myapp.contacts;

import android.text.TextUtils;

import com.example.clarence.utillibrary.PinyinUtils;
import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.controller.ContactsShopFragmentController;
import com.wodejia.myapp.data.ShopRequetDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * 店铺
 */
public class ContactsShopFragment extends ContactsBaseFragment {
    @Inject
    ContactsShopFragmentController controller;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    public ContactsBaseFragmentAdapter getAdapter() {
        return new ContactsShopFragmentAdapter();
    }

    @Override
    public void loadData() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "ContactsShopFragment is error");
            }

            @Override
            public void onNext(WeatherInfoResponseDO getIpInfoResponse) {
                loginData(controller.getMockData(contactsRequestDO));
            }
        });
    }

    public void loginData(List<ShopRequetDO> request) {
        if (request == null) {
            return;
        }
        for (ShopRequetDO shopRequetDO : request) {
            if (!TextUtils.isEmpty(shopRequetDO.getShopName())) {
                String letter = PinyinUtils.getCharacterSimple(shopRequetDO.getShopName().charAt(0));
                if (letter == null) {
                    shopRequetDO.setFirstLetter("#");
                } else {
                    shopRequetDO.setFirstLetter(letter);
                }
            }
        }
        freshView(request);
    }
}
