package com.administration.policebureau.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.administration.policebureau.BaseActivity;
import com.administration.policebureau.R;
import com.administration.policebureau.home.HomeActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.tv_register_user)
    TextView tv_register_user;
    @BindView(R.id.et_phone_number)
    EditText et_phone_number;
    @BindView(R.id.et_password)
    EditText et_password;

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    protected void initializeToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        tv_title.setText("登录");
    }

    @Override
    protected void initializeActivity() {

    }

    @OnClick(R.id.tv_register_user)
    public void onClick(View view){
        String phoneNumber = et_phone_number.getText().toString();
        String passWord = et_password.getText().toString();
        login();
    }

    private void login(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
