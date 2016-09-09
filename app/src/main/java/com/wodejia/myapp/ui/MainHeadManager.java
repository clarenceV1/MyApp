package com.wodejia.myapp.ui;

import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wodejia.myapp.R;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.ui.user.LoginState;

/**
 * Created by clarence on 16/9/9.
 */
public class MainHeadManager {
    /**
     * 主页面左测菜单
     */
    NavigationView navigationView;
    /**
     * 菜单头部
     */
    View menuHead;
    TextView tvWeather;
    SimpleDraweeView sdUserIcon;
    TextView tvUserAccount;
    TextView tvUserNickname;
    TextView tvRegister;
    TextView tvLogin;
    LinearLayout llLogin;
    LinearLayout llLogout;

    LoginState loginState;


    public MainHeadManager(NavigationView navigationView, LoginState loginState) {
        this.navigationView = navigationView;
        this.loginState = loginState;
        initView();
    }

    private void initView() {
        menuHead = navigationView.getHeaderView(0);
        tvWeather = (TextView) menuHead.findViewById(R.id.tvWeather);
        sdUserIcon = (SimpleDraweeView) menuHead.findViewById(R.id.sdUserIcon);
        tvUserAccount = (TextView) menuHead.findViewById(R.id.tvUserAccount);
        tvUserNickname = (TextView) menuHead.findViewById(R.id.tvUserNickname);
        tvRegister = (TextView) menuHead.findViewById(R.id.tvRegister);
        tvLogin = (TextView) menuHead.findViewById(R.id.tvLogin);
        llLogout = (LinearLayout) menuHead.findViewById(R.id.llLogout);
        initListener();
    }

    private void initListener() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginState != null) {
                    loginState.login();
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginState != null) {
                    loginState.logout();
                }
                logout();
            }
        });
    }

    public void setWeather(String weather) {
        if (TextUtils.isEmpty(weather)) {
            tvWeather.setVisibility(View.GONE);
            return;
        }
        tvWeather.setVisibility(View.VISIBLE);
        tvWeather.setText(weather);
    }

    /**
     * 登录
     *
     * @param account
     */
    public void login(AccountDO account) {
        if (account == null) {
            return;
        }
        llLogin.setVisibility(View.VISIBLE);
        llLogout.setVisibility(View.GONE);
        setUserNickname(account.getUserNickname());
        setUserAccount(account.getAccount());
        setUserIcon(account.getUserIcon());

    }

    /**
     * 注销
     */
    public void logout() {
        llLogin.setVisibility(View.GONE);
        llLogout.setVisibility(View.VISIBLE);
    }

    public void setUserAccount(String accountId) {
        if (TextUtils.isEmpty(accountId)) {
            return;
        }
        tvUserAccount.setText("账号：" + accountId);
    }

    public void setUserNickname(String nickname) {
        if (TextUtils.isEmpty(nickname)) {
            return;
        }
        tvUserNickname.setText("昵称：" + nickname);
    }

    public void setUserIcon(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Uri uri = Uri.parse(url);
        sdUserIcon.setImageURI(uri);
    }
}
