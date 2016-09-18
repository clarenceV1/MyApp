package com.wodejia.myapp.ui.qiniu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.clarence.utillibrary.ToastUtils;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.utils.AsyncRun;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by clarence on 16/9/18.
 */
public class ImageUploadActivity extends AppActivity {
    private static final int REQUEST_CODE = 8090;

    @BindView(R.id.uploadProgressBar)
    ProgressBar uploadProgressBar;
    @BindView(R.id.uploadStatusLayout)
    LinearLayout uploadStatusLayout;
    @BindView(R.id.uploadSpeedTextView)
    TextView uploadSpeedTextView;
    @BindView(R.id.uploadFileLengthTextView)
    TextView uploadFileLengthTextView;
    @BindView(R.id.uploadPercentageTextView)
    TextView uploadPercentageTextView;
    @BindView(R.id.uploadLogTextView)
    TextView uploadLogTextView;

    private String uploadFilePath;
    private UploadManager uploadManager;
    private long uploadLastTimePoint;
    private long uploadLastOffset;
    private long uploadFileLength;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_upload);
        ButterKnife.bind(this);
        initView();
        load();
    }

    private void load() {

    }

    private void initView() {
        uploadProgressBar.setMax(100);
        uploadStatusLayout.setVisibility(View.INVISIBLE);
    }

    public void selectUploadFile(View view) {
        Intent target = FileUtils.createGetContentIntent();
        Intent intent = Intent.createChooser(target,
                "选择文件");
        try {
            this.startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException ex) {
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE:
                // If the file selection was successful
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        // Get the URI of the selected file
                        final Uri uri = data.getData();
                        try {
                            // Get the file path from the URI
                            final String path = FileUtils.getPath(this, uri);
                            this.uploadFilePath = path;
                            this.clearLog();
                            this.writeLog("选择文件:" + path);
                        } catch (Exception e) {
                            ToastUtils.showToast(this, "选择上传文件失败!");
                        }
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void uploadFile(View view) {
        if (this.uploadFilePath == null) {
            return;
        }
        //从业务服务器获取上传凭证
        new Thread(new Runnable() {
            @Override
            public void run() {
                final OkHttpClient httpClient = new OkHttpClient();
                Request req = new Request.Builder().url(QiniuLabConfig.makeUrl(
                        QiniuLabConfig.REMOTE_SERVICE_SERVER,
                        QiniuLabConfig.SIMPLE_UPLOAD_WITHOUT_KEY_PATH)).method("GET", null).build();
                Response resp = null;
                try {
                    resp = httpClient.newCall(req).execute();
                    JSONObject jsonObject = new JSONObject(resp.body().string());
                    String uploadToken = jsonObject.getString("uptoken");
                    writeLog("申请凭证:" + uploadToken);
                    upload(uploadToken);
                } catch (IOException e) {
                    AsyncRun.run(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtils.showToast(ImageUploadActivity.this,"申请上传凭证失败!");
                        }
                    });
                    writeLog("申请上传凭证失败!" + resp.toString());
                } catch (JSONException e) {
                    writeLog("申请上传凭证失败!");
                    writeLog("StatusCode:" + resp.code());
                    if (resp != null) {
                        writeLog("Response:" + resp.toString());
                    }
                    writeLog("Exception:" + e.getMessage());
                } finally {
                    if (resp != null) {
                        try {
                            resp.body().close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }
    private void upload(String uploadToken) {
        if (this.uploadManager == null) {
            this.uploadManager = new UploadManager();
        }
        File uploadFile = new File(this.uploadFilePath);
        UploadOptions uploadOptions = new UploadOptions(null, null, false,
                new UpProgressHandler() {
                    @Override
                    public void progress(String key, double percent) {
                        updateStatus(percent);
                    }
                }, null);
        final long startTime = System.currentTimeMillis();
        final long fileLength = uploadFile.length();
        this.uploadFileLength = fileLength;
        this.uploadLastTimePoint = startTime;
        this.uploadLastOffset = 0;

        AsyncRun.run(new Runnable() {
            @Override
            public void run() {
                // prepare status
                uploadPercentageTextView.setText("0 %");
                uploadSpeedTextView.setText("0 KB/s");
                uploadFileLengthTextView.setText(Tools.formatSize(fileLength));
                uploadStatusLayout.setVisibility(LinearLayout.VISIBLE);
            }
        });

        writeLog( "上传文件...");

        //因为是无key上传，所以key参数指定为null
        this.uploadManager.put(uploadFile, null, uploadToken,
                new UpCompletionHandler() {
                    @Override
                    public void complete(String key, ResponseInfo respInfo,
                                         JSONObject jsonData) {
                        AsyncRun.run(new Runnable() {
                            @Override
                            public void run() {
                                // reset status
                              //  uploadStatusLayout.setVisibility(LinearLayout.INVISIBLE);
                                uploadProgressBar.setProgress(0);
                            }
                        });

                        long lastMillis = System.currentTimeMillis()
                                - startTime;
                        if (respInfo.isOK()) {
                            try {
                                String fileKey = jsonData.getString("key");
                                String fileHash = jsonData.getString("hash");
                                writeLog("File Size: "
                                        + Tools.formatSize(uploadFileLength));
                                writeLog("File Key: " + fileKey);
                                writeLog("File Hash: " + fileHash);
                                writeLog("Last Time: "
                                        + Tools.formatMilliSeconds(lastMillis));
                                writeLog("Average Speed: "
                                        + Tools.formatSpeed(fileLength,
                                        lastMillis));
                                writeLog("X-Reqid: " + respInfo.reqId);
                                writeLog("X-Via: " + respInfo.xvia);
                                writeLog("--------------------------------");
                            } catch (JSONException e) {
                                AsyncRun.run(new Runnable() {
                                    @Override
                                    public void run() {
                                        ToastUtils.showToast(ImageUploadActivity.this, "上传回复解析错误!");
                                    }
                                });

                                writeLog("上传回复解析错误!");
                                if (jsonData != null) {
                                    writeLog(jsonData.toString());
                                }
                                writeLog("--------------------------------");
                            }
                        } else {
                            AsyncRun.run(new Runnable() {
                                @Override
                                public void run() {
                                    ToastUtils.showToast(ImageUploadActivity.this, "上传回复解析错误!");
                                }
                            });

                            writeLog(respInfo.toString());
                            if (jsonData != null) {
                                writeLog(jsonData.toString());
                            }
                            writeLog("--------------------------------");
                        }
                    }

                }, uploadOptions);
    }

    private void clearLog() {
        this.uploadLogTextView.setText("");
    }

    private void updateStatus(final double percentage) {
        long now = System.currentTimeMillis();
        long deltaTime = now - uploadLastTimePoint;
        long currentOffset = (long) (percentage * uploadFileLength);
        long deltaSize = currentOffset - uploadLastOffset;
        if (deltaTime <= 100) {
            return;
        }

        final String speed = Tools.formatSpeed(deltaSize, deltaTime);
        // update
        uploadLastTimePoint = now;
        uploadLastOffset = currentOffset;

        AsyncRun.run(new Runnable() {
            @Override
            public void run() {
                int progress = (int) (percentage * 100);
                uploadProgressBar.setProgress(progress);
                uploadPercentageTextView.setText(progress + " %");
                uploadSpeedTextView.setText(speed);
            }
        });
    }

    private void writeLog(final String msg) {
        AsyncRun.run(new Runnable() {
            @Override
            public void run() {
                uploadLogTextView.append(msg);
                uploadLogTextView.append("\r\n");
            }
        });
    }
}
