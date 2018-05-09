package com.administration.policebureau.bigimg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.administration.policebureau.BaseActivity;
import com.administration.policebureau.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;

/**
 * Created by wubo on 2018/5/9.
 */

public class BigImgActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.img_big_pic)
    ImageView bigPicImg;
    private String url;

    public static void newInstance(Context contxt, String url){
        Intent intent = new Intent(contxt, BigImgActivity.class);
        intent.putExtra("url", url);
        contxt.startActivity(intent);
    }

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_bigimg;
    }

    @Override
    protected void getExtra() {
        Intent intent = getIntent();
        url = intent!=null ? intent.getStringExtra("url") : "";
    }

    @Override
    protected void initializeToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        tv_title.setText("图片详情");
    }

    @Override
    protected void initializeActivity() {
        Glide.with(this).load(url).into(bigPicImg);
    }
}
