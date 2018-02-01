package com.administration.policebureau.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.administration.policebureau.App;
import com.administration.policebureau.BaseActivity;
import com.administration.policebureau.R;
import com.administration.policebureau.api.PostService;
import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.UserEntity;
import com.administration.policebureau.home.HomeActivity;
import com.administration.policebureau.http.ProgressSubscriber;
import com.administration.policebureau.http.RetrofitClient;
import com.administration.policebureau.http.RetrofitManager;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;
import rx.Observable;

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
    private final String TAG = getClass().getSimpleName();

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
        HashMap<String,String> map = new HashMap<>();
        map.put("phone", "18665858059");
        map.put("passport", "111111");
        map.put("verify_code","123123");
        login(map);
    }

    private void login(HashMap<String,String> map){

        PostService postService = RetrofitManager.getRetrofit().create(PostService.class);
        Observable<Response<BaseResponse<UserEntity>>> ob = postService.registerUser(map);
        RetrofitClient.client().request(ob, new ProgressSubscriber<UserEntity>(this) {
            @Override
            protected void onSuccess(UserEntity userEntity) {
                Log.i(TAG,userEntity.getToken());
                App.getInstance().setUserEntity(userEntity);
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }

            @Override
            protected void onFailure(String message) {

            }
        });
    }

}
