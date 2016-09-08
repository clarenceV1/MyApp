package com.wodejia.myapp.contacts;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.clarence.libwidget.SlidingTabLayout;
import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.controller.ContactsMainController;
import com.wodejia.myapp.data.ContactsMenuRequestDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

/**
 * Created by clarence on 16/8/30.
 */
public class ContactsMainFragment extends AppFragment {
    @Inject
    ContactsMainController controller;

    @BindView(R.id.tabs)
    SlidingTabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;

    ContactsMainAdapter adapter;

    List<ContactsMenuRequestDO> contactsRequestDOList = new ArrayList<>();

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.contacts_main_fragment;
    }

    @Override
    protected void initView(View view) {
        load();
    }

    private void initView() {
        adapter = new ContactsMainAdapter(getActivity().getSupportFragmentManager(), getActivity(), contactsRequestDOList);
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }

    private void load() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "ContactsMainFragment is error");
                if (controller.mockData() != null) {
                    contactsRequestDOList.clear();
                    contactsRequestDOList.addAll(controller.mockData());
                    initView();
                }
            }

            @Override
            public void onNext(WeatherInfoResponseDO getIpInfoResponse) {
                if (controller.mockData() != null) {
                    contactsRequestDOList.clear();
                    contactsRequestDOList.addAll(controller.mockData());
                    initView();
                }
            }
        });
    }
}
