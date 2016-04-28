package com.example.falling.downloaddesign;

/**
 * Created by falling on 16/4/28.
 */
public interface DownloadListener {

    //通知可以下载

    //显示下载进度
    void showProgress(int code,int progress);

    //下载完成后的操作
    void afterDownload(int code);
}
