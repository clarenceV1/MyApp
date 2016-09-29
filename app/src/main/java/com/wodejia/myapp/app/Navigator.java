
package com.wodejia.myapp.app;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

/**
 * Class used to navigate through the application.
 */
public class Navigator {

    @Inject
    public Navigator() {

    }

    /**
     * 页面跳转，解耦
     *
     * @param intent
     */
    public void navigateTo(Context context, Class<?> clazz, Intent intent) {
        try {
            if (clazz != null && intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(context, clazz);
                context.startActivity(intent);
            } else {
                new Throwable("clazz is null or intent is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void navigateTo(Context context, Class<?> clazz) {
        Intent intent = new Intent();
        navigateTo(context, clazz, intent);
    }
}
