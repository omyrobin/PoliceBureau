package com.administration.policebureau.home.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.administration.policebureau.BaseFragment;
import com.administration.policebureau.R;

import butterknife.BindView;

/**
 * Created by omyrobin on 2018/1/31.
 */

public class HistoryCheckInFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.rv_historycheckin)
    RecyclerView rv_historycheckin;

    @Override
    protected int getLayoutId(@Nullable Bundle savedInstanceState) {
        return R.layout.fragment_historycheckin;
    }

    @Override
    protected void initializeToolbar() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        tv_title.setText("历史入境登记查询");
    }

    @Override
    protected void initializeFragment() {

    }
}
