package com.wodejia.myapp.ui.manager;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.controller.manager.ManagerMainController;
import com.wodejia.myapp.data.manager.FunctionDO;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by clarence on 16/9/19.
 */
public class ManagerMainFragment extends AppFragment {

    @Inject
    ManagerMainController controller;

    @BindView(R.id.gridView)
    GridView gridView;

    ManagerMainAdapter adapter;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.manager_main_fragment;
    }

    @Override
    protected void initView(View view) {
        //todo 添加对话框验证管理密码
        adapter = new ManagerMainAdapter(getContext(), controller.getFunctions());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JumpeTo(adapter.getItem(position));
            }
        });
    }

    private void JumpeTo(FunctionDO item) {
        switch (item.getId()) {
            case 1:
                Intent intent = new Intent(getActivity(), ManagerAddBlockActivity.class);
                startActivity(intent);
        }
    }
}
