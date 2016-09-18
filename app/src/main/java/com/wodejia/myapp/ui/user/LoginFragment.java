package com.wodejia.myapp.ui.user;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.controller.user.LoginController;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.data.WeatherInfoResponseDO;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

/**
 * Created by clarence on 16/9/9.
 */
public class LoginFragment extends AppFragment {

    @Inject
    LoginController controller;

    @BindView(R.id.etAccount)
    EditText etAccount;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

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
        return R.layout.login_fragment;
    }

    @Override
    protected void initView(View view) {

        initListener();
    }

    private void initListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comitLogin();
            }
        });
    }

    private void comitLogin() {
        String account = etAccount.getText().toString();
        if (!controller.checkAccunt(account)) {
            ToastUtils.showToast(getActivity(), R.string.phoneError);
        }
        String password = etPassword.getText().toString();
        if (!controller.checkPassword(password)) {
            ToastUtils.showToast(getActivity(), R.string.passwordError);
            return;
        }
        controller.loginComit(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(getContext(), R.string.loginFail);
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                ToastUtils.showToast(getContext(), R.string.loginSuccess);
                AccountDO accountDO = controller.getMockData();
                controller.saveAccount(accountDO);
                if (loginState != null) {
                    loginState.loginSuccess(accountDO);
                }
            }
        });
    }
}
