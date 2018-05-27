package com.administration.policebureau.download;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import com.administration.policebureau.api.GetService;
import com.administration.policebureau.http.RetrofitManager;
import com.administration.policebureau.util.FileUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by wubo on 2018/5/8.
 */

public class DownService extends Service {

    private static String URL = "http://119.29.159.231:8080/api/so";

    @Override
    public void onCreate() {
        super.onCreate();
        loadSo(getABI(), getPrivateSoFile());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void downLoadSo(@NonNull String url, String abi, final File file){
        GetService getService =  RetrofitManager.getRetrofit().create(GetService.class);
        getService.downloadFile(url, abi)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .map(new Function<ResponseBody, InputStream>() {
                    @Override
                    public InputStream apply(ResponseBody responseBody) throws Exception {
                        return responseBody.byteStream();
                    }

                })
                .observeOn(Schedulers.computation())
                .doOnNext(new Consumer<InputStream>() {
                    @Override
                    public void accept(InputStream inputStream) throws Exception {

                    }

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InputStream>() {

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InputStream inputStream) {
                        try {
                            FileUtil.write(inputStream, file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        copyAndload();
                    }
                });
    }

    /**
     * 获取当前手机CPU ABI
     */
    private String getABI(){
        String name;
        if (Build.VERSION.SDK_INT >= 21) {
            String[] abis = Build.SUPPORTED_ABIS;
            name = abis[0];
        } else {
            name = Build.CPU_ABI ;
        }
        return name;
    }

    /**
     *  获取/mnt/sdcard/packgername/MAP.so
     */
    private File getSdCardSoFile(){
        File file = new File(FileUtil.getCacheFile() + File.separator+"MAP.so");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 获取data/data/packgername/app_libs/MAP.so
     * @return
     */
    private File getPrivateSoFile(){
        File dir = getDir("libs", Activity.MODE_PRIVATE);
        File privateSoFile = new File(dir.getAbsolutePath() + File.separator + "MAP.so");
        if(!privateSoFile.exists()){
            try {
                privateSoFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return privateSoFile;
    }

    /**
     * 根据文件长度判断so文件的加载方式
     * @param abi
     * @param privateFile
     */
    private void loadSo(String abi, File privateFile){
        if(privateFile.length()==0){
            downLoadSo(URL, abi, getSdCardSoFile());
        }else{
            System.load(getPrivateSoFile().getAbsolutePath());
            DownService.this.stopSelf();
        }
    }

    /**
     * copy下载的so文件到data/data/packgername/app_libs目录中
     */
    private void copyAndload(){
        if (FileUtil.copyLibraryFile(DownService.this, getSdCardSoFile(), getPrivateSoFile())){
            System.load(getPrivateSoFile().getAbsolutePath());
        }
        DownService.this.stopSelf();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
