package com.wodejia.myapp.ui.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.controller.community.TipsController;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.data.community.BlockRequestDO;
import com.wodejia.myapp.data.community.TipsRequestDO;

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
    List<TipsRequestDO> tipsRequestDOList = new ArrayList<>();
    TipsAdapter adapter;
    Long blockId;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips);
        getIntents(getIntent());
        titleBarCommon.setCustomTitleBar(-1);
        ButterKnife.bind(this);
        initView();
        load();
    }

    public void getIntents(Intent intent) {
        if (intent.hasExtra(EXTRA_BLOCK_ID)) {
            blockId = (Long) intent.getSerializableExtra(EXTRA_BLOCK_ID);
        }
    }

    private void initView() {
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
        if (blockId != null) {
            controller.requestTipsList(blockId, new Subscriber<WeatherInfoResponseDO>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    ToastUtils.showToast(TipsActivity.this, "获取贴士列表失败");
                }

                @Override
                public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                    tipsRequestDOList.addAll(controller.getMockData());
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }
}
