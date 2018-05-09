package com.administration.policebureau.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administration.policebureau.R;
import com.administration.policebureau.bean.CheckInEntity;
import com.administration.policebureau.bean.NewEntryEntity;
import com.administration.policebureau.information.InfomationActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by omyrobin on 2018/2/1.
 */

public class NewEnterAdapter extends RecyclerView.Adapter{
    private static final int TYPE_EMPTY = 0;
    private static final int TYPE_ITEM = 1;
    private Context context;
    private CheckInEntity checkInEntity;
    private List<NewEntryEntity> list;
    private LayoutInflater inflater;

    public NewEnterAdapter(Context context, CheckInEntity checkInEntity) {
        this.context = context;
        this.checkInEntity = checkInEntity;
        list = checkInEntity.getData();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType){
            case TYPE_EMPTY:
                itemView = inflater.inflate(R.layout.item_newenter_empty, parent ,false);
                return new EmptyViewHolder(itemView);

            default:
                itemView = inflater.inflate(R.layout.item_newenter_data, parent ,false);
                final ItemViewHolder holder = new ItemViewHolder(itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewEntryEntity newEntryEntity = list.get(holder.getLayoutPosition());
                        InfomationActivity.newInstance(context, newEntryEntity);
                    }
                });
                return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type == TYPE_ITEM){
            NewEntryEntity entity = list.get(position);
            Glide.with(context).load(entity.getAvatar()).into(((ItemViewHolder)holder).iv_userpic);
            ((ItemViewHolder)holder).tv_userbase.setText(entity.getFirstname() + " "+ entity.getLastname() + " / " +entity.getGender() );
            ((ItemViewHolder)holder).tv_credential.setText(entity.getCredential_type() + " : "+ entity.getCredential());
            ((ItemViewHolder)holder).tv_birthday.setText(entity.getBirthday());
            ((ItemViewHolder)holder).tv_country.setText(entity.getCountry());
            ((ItemViewHolder)holder).tv_birthplace.setText(entity.getBirthplace());
            ((ItemViewHolder)holder).tv_phone.setText("手机号码 : " + entity.getPhone());
            ((ItemViewHolder)holder).tv_entry_date.setText("入境时间 ： "+ entity.getEntry_date());
            ((ItemViewHolder)holder).tv_status.setText(entity.getStatus());
        }
    }

    @Override
    public int getItemCount() {
        return !list.isEmpty() ? list.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        return !list.isEmpty() ? TYPE_ITEM :TYPE_EMPTY;
    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder{

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_newenter_userpic)
        ImageView iv_userpic;
        @BindView(R.id.tv_newenter_userbase)
        TextView tv_userbase;
        @BindView(R.id.tv_newenter_credential)
        TextView tv_credential;
        @BindView(R.id.tv_newenter_birthday)
        TextView tv_birthday;
        @BindView(R.id.tv_newenter_country)
        TextView tv_country;
        @BindView(R.id.tv_newenter_birthplace)
        TextView tv_birthplace;
        @BindView(R.id.tv_newenter_phone)
        TextView tv_phone;
        @BindView(R.id.tv_newenter_entry_date)
        TextView tv_entry_date;
        @BindView(R.id.tv_newenter_status)
        TextView tv_status;


        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
