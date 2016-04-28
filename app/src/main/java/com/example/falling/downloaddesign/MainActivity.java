package com.example.falling.downloaddesign;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements DownloadListener {

    EditText textFileUrl;
    ProgressBar progressBar;
    Downloader mDownloader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int code = 0;//区分多个监听器的code
        mDownloader.setDownloadListener(code, this);
    }

    public void onClick() {
        mDownloader.download(textFileUrl.getText().toString());
    }




    @Override
    public void showProgress(int code, int progress) {
        //显示下载进度信息
        if (code == 0) {
            progressBar.setProgress(progress);
        }
    }

    @Override
    public void afterDownload(int code) {
        //处理下载完成后的事情。
    }
}
