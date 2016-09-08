package com.wodejia.myapp.dagger.components;

import com.wodejia.myapp.MainActivity;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.contacts.ContactsLogisticsFragment;
import com.wodejia.myapp.contacts.ContactsOfficeFragment;
import com.wodejia.myapp.contacts.ContactsOwnerFragment;
import com.wodejia.myapp.contacts.ContactsMainFragment;
import com.wodejia.myapp.contacts.ContactsShopFragment;
import com.wodejia.myapp.contacts.ShopDetailFragment;
import com.wodejia.myapp.contacts.UserInfoActivity;
import com.wodejia.myapp.contacts.UserDetailFragment;
import com.wodejia.myapp.dagger.module.ActivityModule;

import dagger.Component;

@ScopeActivity
@Component(
        dependencies = {AppComponent.class},
        modules = {ActivityModule.class
        }
)
public interface ActivityComponent {

    void inject(AppActivity activity);

    void inject(MainActivity mainActivity);

    void inject(AppFragment appFragment);

    void inject(ContactsMainFragment contactsMainFragment);

    void inject(ContactsOwnerFragment ownerFragment);

    void inject(ContactsLogisticsFragment logisticsFragment);

    void inject(ContactsShopFragment shopFragment);

    void inject(ContactsOfficeFragment officeFragment);

    void inject(UserInfoActivity userInfoActivity);

    void inject(UserDetailFragment userInfoDetailFragment);

    void inject(ShopDetailFragment shopDetailFragment);

}
