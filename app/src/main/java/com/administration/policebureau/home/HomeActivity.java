package com.administration.policebureau.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.administration.policebureau.BaseActivity;
import com.administration.policebureau.R;
import com.administration.policebureau.home.tab.HistoryCheckInFragment;
import com.administration.policebureau.home.tab.MessageFragment;
import com.administration.policebureau.home.tab.NewEnterFragment;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

/**
 * Created by omyrobin on 2018/1/31.
 */

public class HomeActivity extends BaseActivity {
    @BindView(R.id.fl_home_tab)
    FrameLayout fl_home_tab;
    @BindView(R.id.navigation_bottom)
    BottomNavigationView navigation_bottom;
    private Fragment[] fragments;
    private int currIndexTab;
    private int indexTab = -1;

    private static final int NEW_ENTER = 0;
    private static final int HISTORY_CHECKIN = 1;
    private static final int MESSAGE = 2;



    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_home;
    }

    @Override
    protected void initializeToolbar() {

    }

    @Override
    protected void initializeActivity() {
        initFragment();
        setListener();
    }

    private void initFragment(){
        NewEnterFragment newEnterFragment = new NewEnterFragment();
        HistoryCheckInFragment historyCheckInFragment = new HistoryCheckInFragment();
        MessageFragment messageFragment = new MessageFragment();

        fragments = new Fragment[] {newEnterFragment, historyCheckInFragment, messageFragment};

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_home_tab,fragments[currIndexTab]).show(fragments[currIndexTab]).commit();
    }

    private void addFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(!fragments[currIndexTab].isAdded()){
            transaction.add(R.id.fl_home_tab,fragments[currIndexTab]);
        }
        transaction.show(fragments[currIndexTab]).hide(fragments[indexTab]).commit();

    }

    private void setListener() {
        navigation_bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(indexTab != currIndexTab){
                    indexTab = currIndexTab;
                    switch (item.getItemId()){
                        case R.id.navigation_bottom_new:
                            currIndexTab = NEW_ENTER;
                            break;

                        case R.id.navigation_bottom_history:
                            currIndexTab = HISTORY_CHECKIN;
                            break;

                        default:
                            currIndexTab = MESSAGE;
                            break;
                    }
                    addFragment();
                }
                return true;
            }
        });
    }

//    @OnCheckedChanged({R.id.rb_tab_new, R.id.rb_tab_history,R.id.rb_tab_message})
//    public void onCheckedChanged(RadioButton radioButton, boolean isChecked){
//        if(isChecked){
//            indexTab = currIndexTab;
//            switch (radioButton.getId()){
//                case R.id.rb_tab_new:
//                    currIndexTab = NEW_ENTER;
//                    break;
//
//                case R.id.rb_tab_history:
//                    currIndexTab = HISTORY_CHECKIN;
//                    break;
//
//                default:
//                    currIndexTab = MESSAGE;
//                    break;
//            }
//            addFragment();
//        }
//    }
}
