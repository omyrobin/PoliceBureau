package com.administration.policebureau.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.administration.policebureau.R;
import com.administration.policebureau.bean.MessageInfoEntity;
import com.administration.policebureau.bean.MessageListEntity;
import com.administration.policebureau.home.tab.message.MessageBoardActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wubo on 2018/5/18.
 */

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int MESSAGE_ITEM = 0;
    private static final int EMPTY_ITEM = 1;
    private static final int FOOTER_ITEM = 1;

    private List<MessageInfoEntity> list;
    private Context context;

    public MessageAdapter(List<MessageInfoEntity> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View itemView;
        switch (viewType){
            case MESSAGE_ITEM:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
                return new MessageViewHolder(itemView);

            case EMPTY_ITEM:
                itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newenter_empty, parent ,false);
                return new EnterAdapter.EmptyViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type == MESSAGE_ITEM){
            final MessageInfoEntity entity = list.get(position);
            ((MessageViewHolder)holder).tv_message_username.setText(entity.getUser_id() + "");
            ((MessageViewHolder)holder).tv_message_content.setText(entity.getContent());
            if(entity.getStatus() == 0){
                ((MessageViewHolder)holder).tv_message_state.setText("未回复");
                ((MessageViewHolder)holder).tv_message_state.setTextColor(ContextCompat.getColor(context, R.color.colorText));
                ((MessageViewHolder)holder).tv_message_reply.setVisibility(View.GONE);
                ((MessageViewHolder)holder).iv_message_icon.setVisibility(View.VISIBLE);
                ((MessageViewHolder)holder).rl_message_reply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MessageBoardActivity.newInstance(context, entity.getId());
                    }
                });
            }else{
                ((MessageViewHolder)holder).tv_message_state.setText("已回复");
                ((MessageViewHolder)holder).tv_message_state.setTextColor(ContextCompat.getColor(context, R.color.reply));
                ((MessageViewHolder)holder).tv_message_reply.setVisibility(View.VISIBLE);
                ((MessageViewHolder)holder).tv_message_reply.setText(entity.getReply());
                ((MessageViewHolder)holder).iv_message_icon.setVisibility(View.INVISIBLE);
            }
        }else if(type == EMPTY_ITEM){
            ((EmptyViewHolder)holder).tv_empty_message.setText("当前没有任何留言");
        }
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 1 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.isEmpty() ? EMPTY_ITEM : MESSAGE_ITEM;
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_message_username)
        TextView tv_message_username;
        @BindView(R.id.tv_message_content)
        TextView tv_message_content;
        @BindView(R.id.tv_message_reply)
        TextView tv_message_reply;
        @BindView(R.id.rl_message_reply)
        RelativeLayout rl_message_reply;
        @BindView(R.id.tv_message_state)
        TextView tv_message_state;
        @BindView(R.id.iv_message_icon)
        ImageButton iv_message_icon;

        public MessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_empty_message)
        TextView tv_empty_message;
        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    static class FooterViewHolder extends  RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
