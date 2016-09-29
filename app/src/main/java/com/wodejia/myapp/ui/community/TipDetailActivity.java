package com.wodejia.myapp.ui.community;

import android.content.Intent;
import android.os.Bundle;

import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.data.community.TipsRequestDO;

import butterknife.ButterKnife;

/**
 * Created by clarence on 16/9/29.
 */

public class TipDetailActivity extends AppActivity {

    public static final String EXTRA_TIP_ID = "TipId";
    Long tipId;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips_detial);
        getIntents(getIntent());
        titleBarCommon.setCustomTitleBar(-1);
        ButterKnife.bind(this);
        initView();
        load();
    }

    public void getIntents(Intent intent) {
        if (intent.hasExtra(EXTRA_TIP_ID)) {
            tipId = (Long) intent.getSerializableExtra(EXTRA_TIP_ID);
        }
    }

    private void initView() {

    }

    private void load() {
        if (tipId != null) {

        }
    }

}
