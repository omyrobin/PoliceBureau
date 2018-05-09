package com.administration.policebureau.information;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.administration.policebureau.BaseActivity;
import com.administration.policebureau.R;
import com.administration.policebureau.bean.NewEntryEntity;
import com.administration.policebureau.bigimg.BigImgActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wubo on 2018/5/8.
 */

public class InfomationActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView tv_title;
    //审核状态
    @BindView(R.id.tv_check_state)
    TextView checkStateTv;
    //提交审核时间
    @BindView(R.id.tv_submit_time)
    TextView submitTimeTv;
    //最后活动地点
    @BindView(R.id.tv_last_move)
    TextView lastMoveTv;
    //手机号码
    @BindView(R.id.tv_phone_number)
    TextView phoneNumberTv;
    //本人照片
    @BindView(R.id.img_avata)
    ImageView avataImg;
    //护照信息页照片
    @BindView(R.id.img_passport_info)
    ImageView passportInfoImgs;
    //国家/地区
    @BindView(R.id.tv_country)
    TextView countryTv;
    //证件类型
    @BindView(R.id.tv_credential_type)
    TextView credentialTypeTv;
    //证件号码
    @BindView(R.id.tv_credential)
    TextView credentialTv;
    //英文姓
    @BindView(R.id.tv_lastname)
    TextView lastnameTv;
    //英文名
    @BindView(R.id.tv_firstname)
    TextView firstnameTv;
    //性别
    @BindView(R.id.tv_gender)
    TextView genderTv;
    //出生地
    @BindView(R.id.tv_birthplace)
    TextView birthplaceTv;
    //职业
    @BindView(R.id.tv_occupation)
    TextView occupationTv;
    //工作机构
    @BindView(R.id.tv_working_organization)
    TextView workingOrganizationTv;
    //紧急联系人姓名
    @BindView(R.id.tv_emergency_contact)
    TextView emergencyContactTv;
    //紧急联系人电话
    @BindView(R.id.tv_emergency_phone)
    TextView emergencyPhoneTv;
    //入境页照片
    @BindView(R.id.img_entry_page)
    ImageView entryPageImg;
    //签证页照片
    @BindView(R.id.img_visa_page)
    ImageView visaPageImg;

    //有租赁合同的Layout
    @BindView(R.id.ll_house_have)
    View houseHaveLayout;
    //房主身份证照片
    @BindView(R.id.img_landlord_identity)
    ImageView landlordIdentityImg;
    //展示合同
    @BindView(R.id.rv_contract_of_tenancy)
    RecyclerView contractOfTenancyRv;

    @BindView(R.id.ll_house_nothave)
    View houseNotHaveLayout;
    //详细地址
    @BindView(R.id.tv_house_address)
    TextView houseAddressTv;
    //房主国家
    @BindView(R.id.tv_landlord_country)
    TextView landlordCountryTv;
    //房主身份证号
    @BindView(R.id.tv_landlord_identity)
    TextView landlordIdentityTv;
    //房主中文姓名
    @BindView(R.id.tv_landlord_name)
    TextView landlordNameTv;
    //房主性别
    @BindView(R.id.tv_landlord_gender)
    TextView landlordGenderTv;
    //房主联系电话
    @BindView(R.id.tv_landlord_phone)
    TextView landlordPhoneTv;

    private NewEntryEntity entity;

    public static void newInstance(Context context, NewEntryEntity entity){
        Intent intent = new Intent(context, InfomationActivity.class);
        intent.putExtra("entity", entity);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_infomation;
    }

    @Override
    protected void getExtra() {
        Intent intent = getIntent();
        entity = intent!=null ? (NewEntryEntity) intent.getSerializableExtra("entity") : null;
    }

    @Override
    protected void initializeToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        tv_title.setText("登记资料查询");
    }

    @Override
    protected void initializeActivity() {
        if(entity != null){
            //审核状态
            checkStateTv.setText(entity.getStatus());
            //基本信息
            Glide.with(this).load(entity.getAvatar()).into(avataImg);
            Glide.with(this).load(entity.getPassport_image()).into(passportInfoImgs);
            countryTv.setText(entity.getCountry());
            credentialTypeTv.setText(entity.getCredential_type());
            credentialTv.setText(entity.getCredential());
            firstnameTv.setText(entity.getFirstname());
            lastnameTv.setText(entity.getLastname());
            genderTv.setText(entity.getGender());
            birthplaceTv.setText(entity.getBirthplace());
            occupationTv.setText(entity.getOccupation());
            workingOrganizationTv.setText(entity.getWorking_organization());
            emergencyContactTv.setText(entity.getEmergency_contact());
            emergencyPhoneTv.setText(entity.getEmergency_phone());
            //入境及签证(注)信息
            Glide.with(this).load(entity.getEnter_image()).into(entryPageImg);
            Glide.with(this).load(entity.getVisa_image()).into(visaPageImg);
            //住宿信息
            landlordCountryTv.setText(entity.getLandlord_country());
            landlordIdentityTv.setText(entity.getLandlord_identity());
            landlordNameTv.setText(entity.getLandlord_name());
            landlordGenderTv.setText(entity.getLandlord_gender());
            landlordPhoneTv.setText(entity.getEmergency_phone());
        }

    }

    @OnClick({R.id.img_avata, R.id.img_passport_info, R.id.img_entry_page, R.id.img_visa_page,R.id.img_landlord_identity})
    public void onClick(View v){
        String url;
        switch (v.getId()){
            case R.id.img_avata:
                url = entity.getAvatar();
                break;

            case R.id.img_passport_info:
                url = entity.getPassport_image();
                break;

            case R.id.img_entry_page:
                url = entity.getEnter_image();
                break;

            case R.id.img_visa_page:
                url = entity.getVisa_image();
                break;

            default:
                url = entity.getLandlord_identity_image();
                break;
        }
        BigImgActivity.newInstance(this, url);
    }
}
