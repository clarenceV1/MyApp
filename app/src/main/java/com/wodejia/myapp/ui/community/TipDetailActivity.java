package com.wodejia.myapp.ui.community;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.controller.community.TipsDetailController;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.data.community.TipsReplyRequestDO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/29.
 */

public class TipDetailActivity extends AppActivity {

    public static final String EXTRA_TIP_ID = "TipId";
    int tipId;
    List<TipsReplyRequestDO> tipsReplyList = new ArrayList<>();
    TipsDetailAdapter adapter;

    @Inject
    TipsDetailController controller;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.tvTipTitle)
    TextView tvTipTitle;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips_detial);
        getIntents(getIntent());
        ButterKnife.bind(this);
        initView();
        load();
    }

    public void getIntents(Intent intent) {
        if (intent.hasExtra(EXTRA_TIP_ID)) {
            tipId = intent.getIntExtra(EXTRA_TIP_ID,0);
        }
    }

    private void initView() {
        titleBarCommon.setTitle(R.string.tip_detial_title);
        adapter = new TipsDetailAdapter(this, tipsReplyList);
        listView.setAdapter(adapter);
    }

    private void load() {
        if (tipId != 0) {
            controller.requestTipsDetail(tipId,new Subscriber<WeatherInfoResponseDO>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    ToastUtils.showToast(TipDetailActivity.this, "获取帖子详情失败");
                }

                @Override
                public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                   // tipsReplyList.addAll(controller.getMockData(tipId));
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }

}
