package com.wodejia.myapp.dagger.components;

import com.wodejia.myapp.ui.RichEditorFragment;
import com.wodejia.myapp.ui.community.BlockFragment;
import com.wodejia.myapp.ui.manager.ManagerAddBlockActivity;
import com.wodejia.myapp.ui.manager.ManagerMainFragment;
import com.wodejia.myapp.ui.qiniu.ImageUploadActivity;
import com.wodejia.myapp.ui.MainActivity;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.ui.contacts.ContactsLogisticsFragment;
import com.wodejia.myapp.ui.contacts.ContactsOfficeFragment;
import com.wodejia.myapp.ui.contacts.ContactsOwnerFragment;
import com.wodejia.myapp.ui.contacts.ContactsMainFragment;
import com.wodejia.myapp.ui.contacts.ContactsShopFragment;
import com.wodejia.myapp.ui.contacts.LogisticsDetailFragment;
import com.wodejia.myapp.ui.contacts.OfficeDetailFragment;
import com.wodejia.myapp.ui.contacts.OwnerDetailFragment;
import com.wodejia.myapp.ui.contacts.ShopDetailFragment;
import com.wodejia.myapp.ui.contacts.ContactsDetailActivity;
import com.wodejia.myapp.dagger.module.ActivityModule;
import com.wodejia.myapp.ui.user.LoginFragment;
import com.wodejia.myapp.ui.user.RegisterFragment;

import dagger.Component;

@ScopeActivity
@Component(
        dependencies = {
                AppComponent.class
        },
        modules = {
                ActivityModule.class,
        }
)
public interface ActivityComponent {

    void inject(AppActivity activity);

    void inject(LoginFragment loginFragment);

    void inject(RegisterFragment registerFragment);

    void inject(MainActivity mainActivity);

    void inject(AppFragment appFragment);

    void inject(ContactsMainFragment contactsMainFragment);

    void inject(ContactsOwnerFragment ownerFragment);

    void inject(ContactsLogisticsFragment logisticsFragment);

    void inject(ContactsShopFragment shopFragment);

    void inject(ContactsOfficeFragment officeFragment);

    void inject(ContactsDetailActivity userInfoActivity);

    void inject(OwnerDetailFragment userInfoDetailFragment);

    void inject(ShopDetailFragment shopDetailFragment);

    void inject(OfficeDetailFragment officeDetailFragment);

    void inject(LogisticsDetailFragment logisticsDetailFragment);

    void inject(ImageUploadActivity imageUploadActivity);

    void inject(RichEditorFragment richEditorFragment);

    void inject(ManagerMainFragment managerMainFragment);

    void inject(ManagerAddBlockActivity managerAddBlockActivity);

    void inject(BlockFragment blockFragment);
}
