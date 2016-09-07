package com.wodejia.myapp.dagger.components;

import com.wodejia.myapp.app.AppAplication;
import com.wodejia.myapp.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by clarence on 16/4/4.
 */
@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    void inject(AppAplication app);
}
