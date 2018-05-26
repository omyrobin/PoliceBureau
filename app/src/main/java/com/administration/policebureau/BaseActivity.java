package com.administration.policebureau;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;

import com.administration.policebureau.api.PutService;
import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.NewEntryEntity;
import com.administration.policebureau.http.ProgressSubscriber;
import com.administration.policebureau.http.RetrofitClient;
import com.administration.policebureau.http.RetrofitManager;
import com.administration.policebureau.login.LoginActivity;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by omyrobin on 2017/4/5.
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected NewEntryEntity infoEntity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        if(App.mAppStatus == -1){
//            protectApp();
//        }
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
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

    protected HashMap<String,Object> getRequestParams() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("avatar", infoEntity.getAvatar());
        params.put("passport_image", infoEntity.getPassport_image());
        params.put("country", infoEntity.getCountry());
        params.put("credential", infoEntity.getCredential());
        params.put("credential_type", infoEntity.getCredential_type());
//        params.put("credential_expired_date",infoEntity.getCredential_expired_date());
//        params.put("person_type",infoEntity.getPerson_type());
//        params.put("person_area_type",infoEntity.getPerson_area_type());
        params.put("firstname", infoEntity.getFirstname());
        params.put("lastname", infoEntity.getLastname());
//        params.put("chinese_name",infoEntity.getChinese_name());
        params.put("gender", infoEntity.getGender());
//        params.put("birthday",infoEntity.getBirthday());
        params.put("birthplace", infoEntity.getBirthplace());
        if (!TextUtils.isEmpty(infoEntity.getOccupation()))
            params.put("occupation", infoEntity.getOccupation());
        if (!TextUtils.isEmpty(infoEntity.getWorking_organization()))
            params.put("working_organization", infoEntity.getWorking_organization());
//        params.put("phone",infoEntity.getPhone());
        params.put("emergency_contact", infoEntity.getEmergency_contact());
        params.put("emergency_phone", infoEntity.getEmergency_phone());

        if (!"1".equals(infoEntity.getCredential_type()) && !"7".equals(infoEntity.getCredential_type()) && !"11".equals(infoEntity.getCredential_type())) {
            params.put("enter_image", infoEntity.getEnter_image());
            params.put("visa_image", infoEntity.getVisa_image());
//            params.put("visa_type",infoEntity.getVisa_type());
//            params.put("visa_expired_date",infoEntity.getVisa_expired_date());
        }
//        params.put("entry_date",infoEntity.getEntry_date());
//        params.put("entry_port",infoEntity.getEntry_port());
//        params.put("stay_reason",infoEntity.getStay_reason());
//        params.put("stay_expired_date",infoEntity.getStay_expired_date());
//        params.put("checkout_date",infoEntity.getCheckout_date());
        params.put("house_address", infoEntity.getHouse_address());
//        params.put("house_type",infoEntity.getHouse_type());
        if (App.getInstance().isHave()) {
            Gson gson = new Gson();
            params.put("landlord_identity_image",infoEntity.getLandlord_identity_image());
            Log.i("TAG", gson.toJson(infoEntity.getHouse_contract_image()).toString());
            String [] strs = infoEntity.getHouse_contract_image().split(",");
            for(int i=0; i<strs.length; i++){
                params.put("house_contract_image"+"["+i+"]",strs[i]);
            }
        } else {
//            params.put("checkin_date",infoEntity.getCheckin_date());
//            params.put("police_station",infoEntity.getPolice_station());
//            params.put("community",infoEntity.getCommunity());
            params.put("landlord_country", infoEntity.getLandlord_country());
            params.put("landlord_identity", infoEntity.getLandlord_identity());
            params.put("landlord_name", infoEntity.getLandlord_name());
            params.put("landlord_gender", infoEntity.getLandlord_gender());
            params.put("landlord_phone", infoEntity.getLandlord_phone());
        }
        //提交坐标
        params.put("location",infoEntity.getLocation());
        params.put("location_address",infoEntity.getLocation_address());
        return params;
    }

    protected void registrationInfoAgain(int id){
        PutService putService = RetrofitManager.getRetrofit().create(PutService.class);
        Observable<BaseResponse<NewEntryEntity>> observable =  putService.registerInfo(id, 2);
        RetrofitClient.client().request(observable, new ProgressSubscriber<NewEntryEntity>(this) {
            @Override
            protected void onSuccess(NewEntryEntity data) {
//                ToastUtil.showShort(getString(R.string.info_succeed));
                finish();
            }

            @Override
            protected void onFailure(String message) {
//                ToastUtil.showShort(getString(R.string.info_falid));
            }
        });
    }


}
