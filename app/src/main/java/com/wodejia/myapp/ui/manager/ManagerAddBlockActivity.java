package com.wodejia.myapp.ui.manager;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.clarence.utillibrary.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.controller.manager.ManagerAddBlockController;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.table.BlockDO;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/19.
 */
public class ManagerAddBlockActivity extends AppActivity {

    @Inject
    ManagerAddBlockController controller;

    @BindView(R.id.etBockName)
    EditText etBockName;
    @BindView(R.id.simpleDraweeView)
    SimpleDraweeView simpleDraweeView;

    String blockIcon;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_add_block);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //todo 临时用户固定图片地址，后面换自己上传图片
        blockIcon = "http://7pn64c.com1.z0.glb.clouddn.com/qiniu_cloud_storage_1474256178?imageView2/0/w/1080/format/jpg";
        Uri uri = Uri.parse(blockIcon);
        simpleDraweeView.setImageURI(uri);
    }

    public void commit(View view) {
        final BlockDO blockDO = new BlockDO();
        blockDO.setBlockId(2);
        blockDO.setBlockIcon(blockIcon);
        String blockName = etBockName.getText().toString();
        if (!TextUtils.isEmpty(blockName)) {
            blockDO.setBlockName(blockName);
            controller.addBlock(blockDO,new Subscriber<WeatherInfoResponseDO>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    ToastUtils.showToast(ManagerAddBlockActivity.this, "添加板块失败");
                }

                @Override
                public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                    ToastUtils.showToast(ManagerAddBlockActivity.this, "添加板块成功");
                    controller.saveMockData(blockDO);//TODO 临时保存数据来
                }
            });
        }
    }
}
