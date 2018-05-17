package com.administration.policebureau.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.administration.policebureau.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by omyrobin on 2017/5/11.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    private Context context;

    private List<String> photos;

    private OnRvItemClickListener listener;

    public PhotosAdapter(Context context, List<String> photos, OnRvItemClickListener listener) {
        this.context = context;
        this.photos = photos;
        this.listener = listener;
    }

    public void addPhotoPath(List<String> photos){
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(context).inflate(R .layout.item_photos,null);
        return new PhotosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotosViewHolder holder, final int position) {
        Glide.with(context).load(photos.get(position)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemCount();
    }

    private int itemCount(){
        return photos.size();
    }

    class PhotosViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.photos_item_img)
        ImageView imageView;

        public PhotosViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface OnRvItemClickListener{
        void onClick(int position);
    }
}
