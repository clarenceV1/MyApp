package com.wodejia.myapp.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.clarence.utillibrary.ToastUtils;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.data.AccountDO;
import com.wodejia.myapp.ui.community.BlockFragment;
import com.wodejia.myapp.ui.contacts.ContactsMainFragment;
import com.wodejia.myapp.controller.MainController;
import com.wodejia.myapp.data.WeatherInfoResponseDO;
import com.wodejia.myapp.ui.manager.ManagerMainFragment;
import com.wodejia.myapp.ui.user.LoginFragment;
import com.wodejia.myapp.ui.user.LoginState;
import com.wodejia.myapp.ui.user.RegisterFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

public class MainActivity extends AppActivity implements NavigationView.OnNavigationItemSelectedListener, LoginState {

    @Inject
    MainController controller;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    MainHeadManager mainHeadManager;

    public static AccountDO accountDO;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        initView();
        load();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mainHeadManager = new MainHeadManager(navigationView, this);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_camera:
                break;
            case R.id.nav_community:
                BlockFragment blockFragment = new BlockFragment();
                replaceFragment(R.id.mainframelayout, blockFragment);
                break;
            case R.id.nav_contacts:
                ContactsMainFragment contactsActivity = new ContactsMainFragment();
                replaceFragment(R.id.mainframelayout, contactsActivity);
                break;
            case R.id.nav_manage:
                ManagerMainFragment managerMainFragment = new ManagerMainFragment();
                replaceFragment(R.id.mainframelayout, managerMainFragment);
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void load() {
        controller.request(new Subscriber<WeatherInfoResponseDO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(MainActivity.this, "weather is error");
            }

            @Override
            public void onNext(WeatherInfoResponseDO weatherInfoResponseDO) {
                if (mainHeadManager != null) {
                    mainHeadManager.setWeather(controller.getWeather(weatherInfoResponseDO));
                }
            }
        });

        accountDO = controller.getAccount();
        loginSuccess(accountDO);
    }

    @Override
    public void loginSuccess(AccountDO accountDO) {
        this.accountDO = accountDO;
        mainHeadManager.login(accountDO);
    }

    @Override
    public void goLogin() {
        LoginFragment loginFragment = new LoginFragment();
        replaceFragment(R.id.mainframelayout, loginFragment);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void goRegister() {
        RegisterFragment registerFragment = new RegisterFragment();
        replaceFragment(R.id.mainframelayout, registerFragment);
        drawer.closeDrawer(GravityCompat.START);
    }

}
