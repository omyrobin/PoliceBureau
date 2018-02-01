package com.administration.policebureau.home.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.administration.policebureau.App;
import com.administration.policebureau.BaseFragment;
import com.administration.policebureau.R;
import com.administration.policebureau.api.GetService;
import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.MessageListEntity;
import com.administration.policebureau.http.ProgressSubscriber;
import com.administration.policebureau.http.RetrofitClient;
import com.administration.policebureau.http.RetrofitManager;

import butterknife.BindView;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by omyrobin on 2018/1/31.
 */

public class MessageFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.rv_message)
    RecyclerView rv_message;
    @BindView(R.id.swl_message)
    SwipeRefreshLayout swl_message;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected int getLayoutId(@Nullable Bundle savedInstanceState) {
        return R.layout.fragment_message;
    }

    @Override
    protected void initializeToolbar() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        tv_title.setText("留言");
    }

    @Override
    protected void initializeFragment() {
        initLayoutManager();
        initSwipeRefreshLayout();
    }

    private void initSwipeRefreshLayout(){
        swl_message.setColorSchemeResources(new int[]{R.color.colorPrimary, R.color.colorPrimary});
        swl_message.post(new Runnable() {
            @Override
            public void run() {
                swl_message.setRefreshing(true);
                requestData();
            }
        });
        swl_message.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData();
            }
        });
    }

    private void initLayoutManager(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_message.setLayoutManager(linearLayoutManager);
    }

    private void requestData(){
        GetService getService = RetrofitManager.getRetrofit().create(GetService.class);
        Observable<Response<BaseResponse<MessageListEntity>>> ob = getService.getMessage("Bearer "+ App.getInstance().getToken());
        RetrofitClient.client().request(ob, new ProgressSubscriber<MessageListEntity>(getActivity()) {
            @Override
            protected void onSuccess(MessageListEntity messageListEntity) {
                Log.i(TAG, "数据长度是：  " + messageListEntity.getData().size());
            }

            @Override
            protected void onFailure(String message) {
                Log.i(TAG, message);
            }
        });
    }


}
