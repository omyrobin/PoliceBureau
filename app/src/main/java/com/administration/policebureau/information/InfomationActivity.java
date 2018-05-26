package com.administration.policebureau.information;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.administration.policebureau.App;
import com.administration.policebureau.BaseActivity;
import com.administration.policebureau.R;
import com.administration.policebureau.adapter.PhotosAdapter;
import com.administration.policebureau.bean.NewEntryEntity;
import com.administration.policebureau.bigimg.BigImgActivity;
import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wubo on 2018/5/8.
 */

public class InfomationActivity extends BaseActivity implements PhotosAdapter.OnRvItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.toolbar_action)
    TextView tv_action;
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
    TextView landlordIdinfoEntityTv;
    //房主中文姓名
    @BindView(R.id.tv_landlord_name)
    TextView landlordNameTv;
    //房主性别
    @BindView(R.id.tv_landlord_gender)
    TextView landlordGenderTv;
    //房主联系电话
    @BindView(R.id.tv_landlord_phone)
    TextView landlordPhoneTv;

    private List<String> photos;

    public static void newInstance(Context context, NewEntryEntity infoEntity){
        Intent intent = new Intent(context, InfomationActivity.class);
        intent.putExtra("infoEntity", infoEntity);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_infomation;
    }

    @Override
    protected void getExtra() {
        Intent intent = getIntent();
        infoEntity = intent!=null ? (NewEntryEntity) intent.getSerializableExtra("infoEntity") : null;
    }

    @Override
    protected void initializeToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        tv_title.setText("登记资料查询");
        tv_action.setText("审核");
    }

    @Override
    protected void initializeActivity() {
        initInfo();
    }

    private void initInfo(){
        if(infoEntity != null){
            //审核状态
            checkStateTv.setText(infoEntity.getStatus());
            submitTimeTv.setText(infoEntity.getCreated_at());
            lastMoveTv.setText(infoEntity.getLocation_address());
            //基本信息
            Glide.with(this).load(infoEntity.getAvatar()).into(avataImg);
            Glide.with(this).load(infoEntity.getPassport_image()).into(passportInfoImgs);
            phoneNumberTv.setText(infoEntity.getPhone());
            countryTv.setText(infoEntity.getCountry());
            credentialTypeTv.setText(infoEntity.getCredential_type());
            credentialTv.setText(infoEntity.getCredential());
            firstnameTv.setText(infoEntity.getFirstname());
            lastnameTv.setText(infoEntity.getLastname());
            genderTv.setText(infoEntity.getGender());
            birthplaceTv.setText(infoEntity.getBirthplace());
            occupationTv.setText(infoEntity.getOccupation());
            workingOrganizationTv.setText(infoEntity.getWorking_organization());
            emergencyContactTv.setText(infoEntity.getEmergency_contact());
            emergencyPhoneTv.setText(infoEntity.getEmergency_phone());
            //入境及签证(注)信息
            Glide.with(this).load(infoEntity.getEnter_image()).into(entryPageImg);
            Glide.with(this).load(infoEntity.getVisa_image()).into(visaPageImg);
            //住宿信息
            houseAddressTv.setText(infoEntity.getHouse_address());
            if(!TextUtils.isEmpty(infoEntity.getLandlord_identity_image())){
                App.getInstance().setHave(true);
                houseHaveLayout.setVisibility(View.VISIBLE);
                houseNotHaveLayout.setVisibility(View.GONE);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
                contractOfTenancyRv.setLayoutManager(linearLayoutManager);
                Glide.with(this).load(infoEntity.getLandlord_identity_image()).into(landlordIdentityImg);
                String [] strings =  infoEntity.getHouse_contract_image().split(",");
                if(strings != null && strings.length>0){
                    photos = Arrays.asList(strings);
                    PhotosAdapter adapter = new PhotosAdapter(this,photos,this);
                    contractOfTenancyRv.setAdapter(adapter);
                }
            }else{
                App.getInstance().setHave(false);
                houseHaveLayout.setVisibility(View.GONE);
                houseNotHaveLayout.setVisibility(View.VISIBLE);
                landlordCountryTv.setText(infoEntity.getLandlord_country());
                landlordIdinfoEntityTv.setText(infoEntity.getLandlord_identity_image());
                landlordNameTv.setText(infoEntity.getLandlord_name());
                landlordGenderTv.setText(infoEntity.getLandlord_gender());
                landlordPhoneTv.setText(infoEntity.getEmergency_phone());
            }
        }
    }

    @OnClick(R.id.toolbar_action)
    public void onAction(){
        checkState();
    }

    @OnClick({R.id.img_avata, R.id.img_passport_info, R.id.img_entry_page, R.id.img_visa_page,R.id.img_landlord_identity})
    public void onClick(View v){
        String url;
        switch (v.getId()){
            case R.id.img_avata:
                url = infoEntity.getAvatar();
                break;

            case R.id.img_passport_info:
                url = infoEntity.getPassport_image();
                break;

            case R.id.img_entry_page:
                url = infoEntity.getEnter_image();
                break;

            case R.id.img_visa_page:
                url = infoEntity.getVisa_image();
                break;

            default:
                url = infoEntity.getLandlord_identity_image();
                break;
        }
        if(!TextUtils.isEmpty(url)){
            BigImgActivity.newInstance(this, url);
        }
    }

    @Override
    public void onClick(int position) {
        BigImgActivity.newInstance(this, photos.get(position));
    }

    private void checkState(){
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("是否审核通过当前用户资料")
                .setPositiveButton("通过", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        registrationInfoAgain(infoEntity.getId());
                    }
                })
                .setNegativeButton("取消", null)
                .create();

        dialog.show();
    }
}
