package com.wodejia.myapp.ui.contacts;

import android.text.TextUtils;

import com.example.clarence.utillibrary.PinyinUtils;
import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.controller.contacts.ContactsShopController;
import com.wodejia.myapp.data.contacts.ContactsShopDO;
import com.wodejia.myapp.data.WeatherInfoDO;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * 店铺
 */
public class ContactsShopFragment extends ContactsBaseFragment {
    @Inject
    ContactsShopController controller;

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
        controller.request(new Subscriber<WeatherInfoDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "ContactsShopFragment is error");
            }

            @Override
            public void onNext(WeatherInfoDO getIpInfoResponse) {
                loginData(controller.getMockData(contactsRequestDO));
            }
        });
    }

    public void loginData(List<ContactsShopDO> request) {
        if (request == null) {
            return;
        }
        for (ContactsShopDO shopRequetDO : request) {
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
