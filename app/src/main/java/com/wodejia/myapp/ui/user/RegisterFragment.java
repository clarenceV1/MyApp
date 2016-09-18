package com.wodejia.myapp.ui.user;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.controller.user.RegisterController;
import com.wodejia.myapp.data.WeatherInfoResponseDO;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/9.
 */
public class RegisterFragment extends AppFragment {

    @Inject
    RegisterController controller;

    @BindView(R.id.etAccount)
    EditText etAccount;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnRegist)
    Button btnRegist;
    @BindView(R.id.btnPhoneComit)
    Button btnPhoneComit;
    @BindView(R.id.etVerifyCode)
    EditText etVerifyCode;

    LoginState loginState;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            loginState = (LoginState) getActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.register_fragment;
    }

    @Override
    protected void initView(View view) {
        initListener();
    }

    private void initListener() {
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registComit();
            }
        });

        btnPhoneComit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestVerifyCode();
            }
        });
    }

    /**
     * 提交注册
     */
    private void registComit() {
        String account = etAccount.getText().toString();
        if (!controller.checkAccunt(account)) {
            ToastUtils.showToast(getActivity(), R.string.phoneError);
            return;
        }

        String verifyCode = etVerifyCode.getText().toString();
        if (controller.checkVerifyCode(verifyCode)) {
            ToastUtils.showToast(getActivity(), R.string.verifyCodeError);
            return;
        }

        String password = etPassword.getText().toString();
        if (!controller.checkPassword(password)) {
            ToastUtils.showToast(getActivity(), R.string.passwordError);
            return;
        }

        controller.registComit(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), R.string.registFail);
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                ToastUtils.showToast(getContext(), R.string.registSuccess);
                if (loginState != null) {
                    loginState.goLogin();
                }
            }
        });
    }

    /**
     * 获取验证码
     */
    private void requestVerifyCode() {
        String account = etAccount.getText().toString();
        if (!controller.checkAccunt(account)) {
            ToastUtils.showToast(getActivity(), R.string.phoneError);
            return;
        }

        controller.requestVerifyCode(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), R.string.verifyCodeComitError);
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {

            }
        });
    }
}
