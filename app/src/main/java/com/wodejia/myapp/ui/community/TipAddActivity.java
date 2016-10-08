package com.wodejia.myapp.ui.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.controller.community.TipsAddController;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.data.community.TipsAddRequestDO;
import com.wodejia.myapp.ui.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by clarence on 16/10/8.
 */

public class TipAddActivity extends AppActivity {
    public static final String EXTRA_BLOCK_ID = "BlockId";

    @Inject
    TipsAddController controller;
    @BindView(R.id.edTitle)
    EditText edTitle;
    @BindView(R.id.edContent)
    EditText edContent;
    @BindView(R.id.btnComit)
    Button btnComit;

    int blockId;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_add);
        getIntents(getIntent());
        ButterKnife.bind(this);
        initView();
    }

    public void getIntents(Intent intent) {
        if (intent.hasExtra(EXTRA_BLOCK_ID)) {
            blockId = intent.getIntExtra(EXTRA_BLOCK_ID, 0);
        }
    }

    private void initView() {
        btnComit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commit();
            }
        });
    }

    private void commit() {
        String tipTitle = edTitle.getText().toString();
        if (!controller.checkTipTitle(tipTitle)) {
            ToastUtils.showToast(this, R.string.tip_add_title_error);
            return;
        }
        String tipContent = edContent.getText().toString();
        if (!controller.checkTipContent(tipContent)) {
            ToastUtils.showToast(this, R.string.tip_add_content_error);
            return;
        }

        final TipsAddRequestDO tipsAddRequestDO = new TipsAddRequestDO();
        tipsAddRequestDO.setBlockId(blockId);
        tipsAddRequestDO.setTipTitle(tipTitle);
        tipsAddRequestDO.setTipContent(tipContent);
        tipsAddRequestDO.setProducterId(MainActivity.accountDO.getUserId().intValue());
        controller.commitTip(tipsAddRequestDO,new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(TipAddActivity.this, "发表帖子失败");
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                ToastUtils.showToast(TipAddActivity.this, "发表帖子成功");
                controller.saveMockData(tipsAddRequestDO);
            }
        });
    }
}

