package com.wodejia.myapp.ui.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.controller.community.TipsController;
import com.wodejia.myapp.data.WeatherInfoDO;
import com.wodejia.myapp.data.community.TipsDO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;


/**
 * Created by clarence on 16/9/29.
 */

public class TipsActivity extends AppActivity {
    @Inject
    TipsController controller;

    @BindView(R.id.listView)
    ListView listView;

    public static final String EXTRA_BLOCK_ID = "BlockId";
    List<TipsDO> tipsRequestDOList = new ArrayList<>();
    TipsAdapter adapter;
    int blockId;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips);
        getIntents(getIntent());
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }

    public void getIntents(Intent intent) {
        if (intent.hasExtra(EXTRA_BLOCK_ID)) {
            blockId = intent.getIntExtra(EXTRA_BLOCK_ID,0);
        }
    }

    private void initView() {
        TextView titleBarRight = titleBarCommon.getRightTextView();
        titleBarRight.setVisibility(View.VISIBLE);
        titleBarRight.setText(R.string.tip_public);
        titleBarRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(TipAddActivity.EXTRA_BLOCK_ID, blockId);
                navigator.navigateTo(TipsActivity.this, TipAddActivity.class, intent);
            }
        });

        adapter = new TipsAdapter(this, tipsRequestDOList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra(TipDetailActivity.EXTRA_TIP_ID, tipsRequestDOList.get(position).getTipId());
                navigator.navigateTo(TipsActivity.this, TipDetailActivity.class, intent);
            }
        });
    }

    private void load() {
        if (blockId != 0) {
            controller.requestTipsList(blockId, new Subscriber<WeatherInfoDO>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    ToastUtils.showToast(TipsActivity.this, "获取贴士列表失败");
                }

                @Override
                public void onNext(WeatherInfoDO weatherInfoResponseDO) {
                    tipsRequestDOList.clear();
                    tipsRequestDOList.addAll(controller.getMockData(blockId));
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }
}
