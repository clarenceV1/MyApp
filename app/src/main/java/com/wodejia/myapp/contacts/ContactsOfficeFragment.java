package com.wodejia.myapp.contacts;

import android.text.TextUtils;

import com.example.clarence.utillibrary.PinyinUtils;
import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.controller.ContactsOfficeFragmentController;
import com.wodejia.myapp.data.OfficeRequetDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * 店铺
 */
public class ContactsOfficeFragment extends ContactsBaseFragment {
    @Inject
    ContactsOfficeFragmentController controller;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    public ContactsBaseFragmentAdapter getAdapter() {
        return new ContactsOfficeFragmentAdapter();
    }

    @Override
    public void loadData() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "ContactsOfficeFragment is error");
            }

            @Override
            public void onNext(WeatherInfoResponseDO getIpInfoResponse) {
                loginData(controller.getMockData(contactsRequestDO));
            }
        });
    }

    public void loginData(List<OfficeRequetDO> request) {
        if (request == null) {
            return;
        }
        for (OfficeRequetDO officeRequetDO : request) {
            if (!TextUtils.isEmpty(officeRequetDO.getOfficeName())) {
                String letter = PinyinUtils.getCharacterSimple(officeRequetDO.getOfficeName().charAt(0));
                if (letter == null) {
                    officeRequetDO.setFirstLetter("#");
                } else {
                    officeRequetDO.setFirstLetter(letter);
                }
            }
        }
        freshView(request);
    }
}
