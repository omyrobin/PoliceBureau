package com.administration.policebureau.bean;

import java.util.List;

/**
 * Created by omyrobin on 2018/1/31.
 */

public class CheckInEntity {

    /**
     * total : 10
     * per_page : 10
     * current_page : 1
     * last_page : 1
     * next_page_url : null
     * prev_page_url : null
     * from : 1
     * to : 10
     * data : [{"id":1,"status":"未审核","user_id":1,"avatar":"https://lorempixel.com/320/240/?41158","passport_image":"https://lorempixel.com/320/240/?65014","country":"G 格林纳达","credential_type":"公务护照","credential":"6614754711","credential_expired_date":"1972-04-27","firstname":"蒋钟","lastname":"白阳","chinese_name":"司霞","gender":"女","birthday":"2014-02-10","birthplace":"石家庄白云区","occupation":"重点投资人","working_organization":"Ipsa in.","phone":"17744678601","emergency_contact":"简丹","emergency_phone":"13244648229","enter_image":"https://lorempixel.com/320/240/?60661","visa_image":"https://lorempixel.com/320/240/?26416","visa_type":"定居签证","visa_expired_date":"2012-03-30","entry_date":"2002-06-10","entry_port":"A 安庆港","stay_reason":"就业","stay_expired_date":"1989-08-18","checkin_date":"1981-07-18","checkout_date":"1998-10-27","house_address":"杭州高港区","landlord_identity_image":"https://lorempixel.com/320/240/?69958","house_contract_image":"https://lorempixel.com/320/240/?17915,https://lorempixel.com/320/240/?96311","house_type":"","landlord_country":"F 法属圭亚那","landlord_identity":"4530175866","landlord_name":"车雪梅","landlord_gender":"男","landlord_phone":"13143814383","certificate_image":"","leave_date":"0000-00-00","leave_reason":"","destination":"","reject_reason":"","created_at":"2017-12-21","updated_at":"2017-12-21","reject_fields":null},{"id":2,"status":"未审核","user_id":5,"avatar":"https://lorempixel.com/320/240/?12448","passport_image":"https://lorempixel.com/320/240/?93456","country":"A 阿尔巴尼亚","credential_type":"台湾居民来往大陆通行证（一次有效）","credential":"3343972571","credential_expired_date":"2003-05-24","firstname":"连毅","lastname":"祝宇","chinese_name":"卞畅","gender":"女","birthday":"2015-01-03","birthplace":"广州沈北新区","occupation":"普通投资人","working_organization":"Quidem.","phone":"17073223206","emergency_contact":"曹莉","emergency_phone":"17088764855","enter_image":"https://lorempixel.com/320/240/?20106","visa_image":"https://lorempixel.com/320/240/?86704","visa_type":"外交签证","visa_expired_date":"1981-03-28","entry_date":"2001-02-09","entry_port":"A 安庆港","stay_reason":"商务","stay_expired_date":"1994-11-07","checkin_date":"2002-03-09","checkout_date":"2006-06-03","house_address":"银川萧山区","landlord_identity_image":"https://lorempixel.com/320/240/?15717","house_contract_image":"https://lorempixel.com/320/240/?28597,https://lorempixel.com/320/240/?12773","house_type":"","landlord_country":"A 阿鲁巴","landlord_identity":"3018150716","landlord_name":"韦嘉俊","landlord_gender":"女","landlord_phone":"17089175392","certificate_image":"","leave_date":"0000-00-00","leave_reason":"","destination":"","reject_reason":"","created_at":"2017-12-21","updated_at":"2017-12-21","reject_fields":null}]
     */

    private int total;
    private int per_page;
    private int current_page;
    private int last_page;
    private String next_page_url;
    private String prev_page_url;
    private int from;
    private int to;
    private List<NewEntryEntity> data;

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

    public List<NewEntryEntity> getData() {
        return data;
    }

    public void setData(List<NewEntryEntity> data) {
        this.data = data;
    }

}
