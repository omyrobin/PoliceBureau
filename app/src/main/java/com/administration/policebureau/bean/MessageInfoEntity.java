package com.administration.policebureau.bean;

/**
 * Created by omyrobin on 2018/2/1.
 */

public class MessageInfoEntity {
    /**
     * id : 1
     * user_id : 8
     * content : Officiis.
     * status : 0
     * reply :
     * created_at : 2017-12-21 13:41:17
     * updated_at : 2017-12-21 13:41:17
     */

    private int id;
    private int user_id;
    private String content;
    private int status;
    private String reply;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
