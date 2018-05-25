package com.administration.policebureau.home.tab.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.administration.policebureau.BaseActivity;
import com.administration.policebureau.R;
import com.administration.policebureau.adapter.MessageAdapter;
import com.administration.policebureau.api.PutService;
import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.MessageListEntity;
import com.administration.policebureau.http.ProgressSubscriber;
import com.administration.policebureau.http.RetrofitClient;
import com.administration.policebureau.http.RetrofitManager;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

/**
 * Created by omyrobin on 2017/4/21.
 */

public class MessageBoardActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView titleTv;
    @BindView(R.id.toolbar_action)
    TextView actionTv;
    @BindView(R.id.send_message_et)
    EditText sendMessageEt;
    private int id;

    public static void newInstance(Context context, int id){
        Intent intent = new Intent(context, MessageBoardActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_send_message;
    }

    @Override
    protected void getExtra() {
        id = getIntent().getIntExtra("id", 0);
    }

    @Override
    protected void initializeToolbar() {
        titleTv.setText(R.string.reply);
        actionTv.setText(R.string.send);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void initializeActivity() {

    }

    @OnClick(R.id.toolbar_action)
    public void actionTo(){
        senMessage();
    }


    public void senMessage() {
        PutService putService = RetrofitManager.getRetrofit().create(PutService.class);
        String content = sendMessageEt.getText().toString();
        Observable<BaseResponse<MessageListEntity>> observable = putService.reply(id, content, 1);
        RetrofitClient.client().request(observable, new ProgressSubscriber<MessageListEntity>(this) {
            @Override
            protected void onSuccess(MessageListEntity messageListEntity) {
                finish();
            }

            @Override
            protected void onFailure(String message) {

            }
        });
    }
}
