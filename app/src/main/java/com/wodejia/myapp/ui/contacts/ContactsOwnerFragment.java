package com.wodejia.myapp.ui.contacts;

import android.text.TextUtils;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.controller.contacts.ContactsOwnerController;
import com.wodejia.myapp.data.contacts.ContactsOwnerDO;
import com.wodejia.myapp.data.WeatherInfoDO;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * 业主
 */
public class ContactsOwnerFragment extends ContactsBaseFragment {
    @Inject
    ContactsOwnerController controller;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    public ContactsBaseFragmentAdapter getAdapter() {
        return new ContactsOwnerFragmentAdapter();
    }

    @Override
    public void loadData() {
        controller.request(new Subscriber<WeatherInfoDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "ContactsOwnerFragment is error");
                loginData(controller.getMockData(contactsRequestDO));
            }

            @Override
            public void onNext(WeatherInfoDO getIpInfoResponse) {
                loginData(controller.getMockData(contactsRequestDO));
            }
        });
    }

    public void loginData(List<ContactsOwnerDO> request) {
        if (request == null) {
            return;
        }
        for (ContactsOwnerDO ownerRequetDO : request) {
            if (!TextUtils.isEmpty(ownerRequetDO.getUserName())) {
                String letter = null;
                try {
                    letter = ownerRequetDO.getHouseNum().substring(0, 3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (letter == null) {
                    ownerRequetDO.setFirstLetter("#");
                } else {
                    ownerRequetDO.setFirstLetter(letter);
                }
            }
        }
        freshView(request);
    }
}
