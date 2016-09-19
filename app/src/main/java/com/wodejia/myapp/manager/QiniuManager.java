package com.wodejia.myapp.manager;

import com.qiniu.android.storage.UploadManager;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/19.
 */
public class QiniuManager {

    @Inject
    public QiniuManager() {
    }

    public static final class LazyHolder {
        public static UploadManager uploadManager = new UploadManager();
    }

    public static final UploadManager getUploadManager() {
        return LazyHolder.uploadManager;
    }
}
