package com.administration.policebureau;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;

import com.administration.policebureau.login.LoginActivity;

import butterknife.ButterKnife;

/**
 * Created by omyrobin on 2017/4/5.
 */

public abstract class BaseActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        if(App.mAppStatus == -1){
//            protectApp();
//        }
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId(savedInstanceState));
        ButterKnife.bind(this);
        getExtra();
        initializeToolbar();
        initializeActivity();
    }

    protected abstract int getLayoutId(Bundle savedInstanceState);

    protected abstract void initializeToolbar();

    protected abstract void initializeActivity();

    protected void getExtra(){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void protectApp() {
        Intent intent = new Intent(this,LoginActivity.class);
        intent.putExtra("action", "force_kill");
        startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(defInAnim(), R.anim.slide_no_anim);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(defInAnim(), R.anim.slide_no_anim);
    }

    @Override
    public void finish() {
        super.finish();
        if(defOutAnim() == -1)
            return;
        overridePendingTransition(R.anim.slide_no_anim, defOutAnim());
    }

    protected int defInAnim() {
        return R.anim.slide_right_in;
    }

    protected int defOutAnim() {
        return R.anim.slide_right_out;
    }


}
