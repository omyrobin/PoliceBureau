package com.administration.policebureau.home.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.administration.policebureau.BaseFragment;
import com.administration.policebureau.R;
import com.administration.policebureau.api.GetService;
import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.CheckInEntity;
import com.administration.policebureau.http.ProgressSubscriber;
import com.administration.policebureau.http.RetrofitClient;
import com.administration.policebureau.http.RetrofitManager;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnEditorAction;
import io.reactivex.Observable;

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
    @BindView(R.id.et_history_search)
    EditText searchEt;
    private final String TAG = getClass().getSimpleName();

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

    @OnEditorAction(R.id.et_history_search)
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
        if( actionId == EditorInfo.IME_ACTION_SEARCH){
            String value = v.getText().toString();
            HashMap<String,String> map = new HashMap<>();
            if(isMobile(value)){
                map.put("phone", value);
            }else {
                map.put("credential", value);
            }
            initData(map);
            closeKeyboard();
        }
        return false;
    }

    private void closeKeyboard(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        //如果开启
        if (imm.isActive()) {
            //关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void initData( HashMap<String,String> map){
        GetService getService = RetrofitManager.getRetrofit().create(GetService.class);
        Observable<BaseResponse<CheckInEntity>> ob = getService.getCheckInById(map);
        RetrofitClient.client().request(ob, new ProgressSubscriber<CheckInEntity>(getActivity()) {
            @Override
            protected void onSuccess(CheckInEntity checkInEntity) {
                Log.i(TAG, "数据长度是：  " + checkInEntity.getData().size());
            }

            @Override
            protected void onFailure(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static boolean isMobile(final String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}
