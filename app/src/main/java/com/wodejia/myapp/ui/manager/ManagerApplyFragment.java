package com.wodejia.myapp.ui.manager;

import android.view.View;

import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;

/**
 * 管理员申请
 * Created by clarence on 16/9/29.
 */
public class ManagerApplyFragment extends AppFragment {
    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.manager_apply;
    }

    @Override
    protected void initView(View view) {

    }
}
