package com.administration.policebureau;

import android.app.Application;

import com.administration.policebureau.bean.NewEntryEntity;
import com.administration.policebureau.bean.UserEntity;
import com.administration.policebureau.util.FileUtil;

/**
 * Created by omyrobin on 2018/1/14.
 */

public class App extends Application {

    //用来判断是否被强杀的状态标识
    public static int mAppStatus = -1;
    private static App mApp;
    private UserEntity userEntity;
    private NewEntryEntity infoEntity;
    private String token;
    private boolean have;

    public static App getInstance(){
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        FileUtil.instance(this);
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        setToken(userEntity.getToken());
    }

    public NewEntryEntity getInfoEntity() {
        return infoEntity;
    }

    public void setInfoEntity(NewEntryEntity infoEntity) {
        this.infoEntity = infoEntity;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setHave(boolean have) {
        this.have = have;
    }

    public boolean isHave() {
        return have;
    }
}
