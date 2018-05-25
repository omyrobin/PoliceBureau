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
import com.administration.policebureau.adapter.NewEnterAdapter;
import com.administration.policebureau.api.GetService;
import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.CheckInEntity;
import com.administration.policebureau.bean.NewEntryEntity;
import com.administration.policebureau.http.ProgressSubscriber;
import com.administration.policebureau.http.RetrofitClient;
import com.administration.policebureau.http.RetrofitManager;

import butterknife.BindView;
import io.reactivex.Observable;

/**
 * Created by omyrobin on 2018/1/31.
 */

public class NewEnterFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.rv_newenter)
    RecyclerView rv_newenter;
    @BindView(R.id.swl_newenter)
    SwipeRefreshLayout swl_newenter;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected int getLayoutId(@Nullable Bundle savedInstanceState) {
        return R.layout.fragment_newenter;
    }

    @Override
    protected void initializeToolbar() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        tv_title.setText("新入境登记查询");
    }

    @Override
    protected void initializeFragment() {
        initLayoutManager();
        initSwipeRefreshLayout();
    }

    private void initSwipeRefreshLayout(){
        swl_newenter.setColorSchemeResources(new int[]{R.color.colorPrimary, R.color.colorPrimary});
        swl_newenter.post(new Runnable() {
            @Override
            public void run() {
                swl_newenter.setRefreshing(true);
                initData();
            }
        });
        swl_newenter.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });
    }

    private void initLayoutManager(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv_newenter.setLayoutManager(layoutManager);
    }

    private void initData(){
        GetService getService = RetrofitManager.getRetrofit().create(GetService.class);
        Observable<BaseResponse<CheckInEntity>> ob = getService.getCheckInList();
        RetrofitClient.client().request(ob, new ProgressSubscriber<CheckInEntity>(getActivity()) {
            @Override
            protected void onSuccess(CheckInEntity checkInEntity) {
                Log.i(TAG, "数据长度是：  " + checkInEntity.getData().size());
                initAdapter(checkInEntity);
                swl_newenter.setRefreshing(false);
            }

            @Override
            protected void onFailure(String message) {
                Log.i(TAG, message);
                swl_newenter.setRefreshing(false);
            }
        });
    }

    private void initAdapter(CheckInEntity checkInEntity){
        NewEnterAdapter adapter = new NewEnterAdapter(getActivity(),checkInEntity);
        rv_newenter.setAdapter(adapter);
    }
}
