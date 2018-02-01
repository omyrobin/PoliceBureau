package com.administration.policebureau.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administration.policebureau.R;
import com.administration.policebureau.bean.CheckInEntity;
import com.administration.policebureau.bean.NewEntryEntity;

import java.util.List;

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

                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

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
}
