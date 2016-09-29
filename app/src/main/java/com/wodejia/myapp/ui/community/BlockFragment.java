package com.wodejia.myapp.ui.community;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.controller.community.BlockController;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.data.community.BlockRequestDO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/9.
 */
public class BlockFragment extends AppFragment {

    @Inject
    BlockController controller;

    @BindView(R.id.listView)
    ListView listView;

    List<BlockRequestDO> blockDOList = new ArrayList<>();
    BlockAdapter blockAdapter;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.block_fragment;
    }

    @Override
    protected void initView(View view) {
        blockAdapter = new BlockAdapter(getContext(), blockDOList);
        listView.setAdapter(blockAdapter);
        initListener();
        load();
    }

    private void initListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra(TipsActivity.EXTRA_BLOCK_ID, blockDOList.get(position).getBlockId());
                navigator.navigateTo(getContext(), TipsActivity.class, intent);
            }
        });
    }

    private void load() {
        controller.requestBlockList(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), "获取板块列表失败");
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                blockDOList.addAll(controller.getMockData());
                blockAdapter.notifyDataSetChanged();
            }
        });
    }
}
