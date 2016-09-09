package com.wodejia.myapp.ui.contacts;

import android.text.TextUtils;

import com.example.clarence.utillibrary.PinyinUtils;
import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.controller.contacts.ContactsLogisticsController;
import com.wodejia.myapp.data.ContactsLogisticsRequestDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * 物流
 */
public class ContactsLogisticsFragment extends ContactsBaseFragment {
    @Inject
    ContactsLogisticsController controller;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    public ContactsBaseFragmentAdapter getAdapter() {
        return new ContactsLogisticsFragmentAdapter();
    }

    @Override
    public void loadData() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "ContactsLogisticsFragment is error");
            }

            @Override
            public void onNext(WeatherInfoResponseDO getIpInfoResponse) {
                loginData(controller.getMockData(contactsRequestDO));
            }
        });
    }

    public void loginData(List<ContactsLogisticsRequestDO> request) {
        if (request == null) {
            return;
        }
        for (ContactsLogisticsRequestDO logisticsRequetDO : request) {
            if (!TextUtils.isEmpty(logisticsRequetDO.getLogisticsName())) {
                String letter = PinyinUtils.getCharacterSimple(logisticsRequetDO.getLogisticsName().charAt(0));
                if (letter == null) {
                    logisticsRequetDO.setFirstLetter("#");
                } else {
                    logisticsRequetDO.setFirstLetter(letter);
                }
            }
        }
        freshView(request);
    }
}
