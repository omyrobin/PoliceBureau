package com.administration.policebureau.bean;

import java.util.List;

/**
 * Created by omyrobin on 2018/2/1.
 */

public class MessageListEntity {

    /**
     * total : 10
     * per_page : 10
     * current_page : 1
     * last_page : 1
     * next_page_url : null
     * prev_page_url : null
     * from : 1
     * to : 10
     * data : [{"id":1,"user_id":8,"content":"Officiis.","status":0,"reply":"","created_at":"2017-12-21 13:41:17","updated_at":"2017-12-21 13:41:17"},{"id":2,"user_id":8,"content":"Rerum.","status":0,"reply":"","created_at":"2017-12-21 13:41:17","updated_at":"2017-12-21 13:41:17"}]
     */

    private int total;
    private int per_page;
    private int current_page;
    private int last_page;
    private String next_page_url;
    private String prev_page_url;
    private int from;
    private int to;
    private List<MessageInfoEntity> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(String prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public List<MessageInfoEntity> getData() {
        return data;
    }

    public void setData(List<MessageInfoEntity> data) {
        this.data = data;
    }
}
