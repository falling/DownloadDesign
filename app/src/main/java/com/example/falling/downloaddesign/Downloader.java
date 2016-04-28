package com.example.falling.downloaddesign;

/**
 * Created by falling on 16/4/27.
 */
public class Downloader {

    String fileUrl;
    DownloadListener mDownloadListener = null;
    boolean isCancel = true;
    private static Downloader[] sDownloaders;
    private int code;
    private static int MaxDownloader = 3;
    private boolean isDownloaded = false;


    private Downloader() {
    }

    //返回空闲的下载对象。
    public static Downloader obtain() {
        if (sDownloaders.length < MaxDownloader) {
            sDownloaders = new Downloader[MaxDownloader];
            for (int i = 0; i < MaxDownloader; i++) {
                sDownloaders[i] = new Downloader();
            }
        }
        return canDownload();
    }

    private static Downloader canDownload() {
        // TODO: 16/4/28 查找是否存在可以下载的对象。如果存在返回它，不然返回null
        sDownloaders[0].isDownloaded = true;//设置标记，表示已经用于一个下载任务。不得重复使用。
        return null;
    }

    //设置监听器
    public void setDownloadListener(int code, DownloadListener downloadListener) {
        this.code = code;
        mDownloadListener = downloadListener;
    }

    //下载
    public void download(String fileUrl) {
        isCancel = false;
        while (!isCancel) {
            //下载过程;
            //mDownloadListener.showProgress(progress)  （需要判断是否为null)
        }

        //下载完成
        mDownloadListener.afterDownload(code);
        cancel();
    }

    //取消下载
    public void cancel() {
        isCancel = true;
    }
}
