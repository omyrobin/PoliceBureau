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
    private Object next_page_url;
    private Object prev_page_url;
    private int from;
    private int to;
    private List<DataBean> data;

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

    public Object getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(Object next_page_url) {
        this.next_page_url = next_page_url;
    }

    public Object getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(Object prev_page_url) {
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * status : 未审核
         * user_id : 1
         * avatar : https://lorempixel.com/320/240/?41158
         * passport_image : https://lorempixel.com/320/240/?65014
         * country : G 格林纳达
         * credential_type : 公务护照
         * credential : 6614754711
         * credential_expired_date : 1972-04-27
         * firstname : 蒋钟
         * lastname : 白阳
         * chinese_name : 司霞
         * gender : 女
         * birthday : 2014-02-10
         * birthplace : 石家庄白云区
         * occupation : 重点投资人
         * working_organization : Ipsa in.
         * phone : 17744678601
         * emergency_contact : 简丹
         * emergency_phone : 13244648229
         * enter_image : https://lorempixel.com/320/240/?60661
         * visa_image : https://lorempixel.com/320/240/?26416
         * visa_type : 定居签证
         * visa_expired_date : 2012-03-30
         * entry_date : 2002-06-10
         * entry_port : A 安庆港
         * stay_reason : 就业
         * stay_expired_date : 1989-08-18
         * checkin_date : 1981-07-18
         * checkout_date : 1998-10-27
         * house_address : 杭州高港区
         * landlord_identity_image : https://lorempixel.com/320/240/?69958
         * house_contract_image : https://lorempixel.com/320/240/?17915,https://lorempixel.com/320/240/?96311
         * house_type :
         * landlord_country : F 法属圭亚那
         * landlord_identity : 4530175866
         * landlord_name : 车雪梅
         * landlord_gender : 男
         * landlord_phone : 13143814383
         * certificate_image :
         * leave_date : 0000-00-00
         * leave_reason :
         * destination :
         * reject_reason :
         * created_at : 2017-12-21
         * updated_at : 2017-12-21
         * reject_fields : null
         */

        private int id;
        private String status;
        private int user_id;
        private String avatar;
        private String passport_image;
        private String country;
        private String credential_type;
        private String credential;
        private String credential_expired_date;
        private String firstname;
        private String lastname;
        private String chinese_name;
        private String gender;
        private String birthday;
        private String birthplace;
        private String occupation;
        private String working_organization;
        private String phone;
        private String emergency_contact;
        private String emergency_phone;
        private String enter_image;
        private String visa_image;
        private String visa_type;
        private String visa_expired_date;
        private String entry_date;
        private String entry_port;
        private String stay_reason;
        private String stay_expired_date;
        private String checkin_date;
        private String checkout_date;
        private String house_address;
        private String landlord_identity_image;
        private String house_contract_image;
        private String house_type;
        private String landlord_country;
        private String landlord_identity;
        private String landlord_name;
        private String landlord_gender;
        private String landlord_phone;
        private String certificate_image;
        private String leave_date;
        private String leave_reason;
        private String destination;
        private String reject_reason;
        private String created_at;
        private String updated_at;
        private Object reject_fields;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getPassport_image() {
            return passport_image;
        }

        public void setPassport_image(String passport_image) {
            this.passport_image = passport_image;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCredential_type() {
            return credential_type;
        }

        public void setCredential_type(String credential_type) {
            this.credential_type = credential_type;
        }

        public String getCredential() {
            return credential;
        }

        public void setCredential(String credential) {
            this.credential = credential;
        }

        public String getCredential_expired_date() {
            return credential_expired_date;
        }

        public void setCredential_expired_date(String credential_expired_date) {
            this.credential_expired_date = credential_expired_date;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getChinese_name() {
            return chinese_name;
        }

        public void setChinese_name(String chinese_name) {
            this.chinese_name = chinese_name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getBirthplace() {
            return birthplace;
        }

        public void setBirthplace(String birthplace) {
            this.birthplace = birthplace;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getWorking_organization() {
            return working_organization;
        }

        public void setWorking_organization(String working_organization) {
            this.working_organization = working_organization;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmergency_contact() {
            return emergency_contact;
        }

        public void setEmergency_contact(String emergency_contact) {
            this.emergency_contact = emergency_contact;
        }

        public String getEmergency_phone() {
            return emergency_phone;
        }

        public void setEmergency_phone(String emergency_phone) {
            this.emergency_phone = emergency_phone;
        }

        public String getEnter_image() {
            return enter_image;
        }

        public void setEnter_image(String enter_image) {
            this.enter_image = enter_image;
        }

        public String getVisa_image() {
            return visa_image;
        }

        public void setVisa_image(String visa_image) {
            this.visa_image = visa_image;
        }

        public String getVisa_type() {
            return visa_type;
        }

        public void setVisa_type(String visa_type) {
            this.visa_type = visa_type;
        }

        public String getVisa_expired_date() {
            return visa_expired_date;
        }

        public void setVisa_expired_date(String visa_expired_date) {
            this.visa_expired_date = visa_expired_date;
        }

        public String getEntry_date() {
            return entry_date;
        }

        public void setEntry_date(String entry_date) {
            this.entry_date = entry_date;
        }

        public String getEntry_port() {
            return entry_port;
        }

        public void setEntry_port(String entry_port) {
            this.entry_port = entry_port;
        }

        public String getStay_reason() {
            return stay_reason;
        }

        public void setStay_reason(String stay_reason) {
            this.stay_reason = stay_reason;
        }

        public String getStay_expired_date() {
            return stay_expired_date;
        }

        public void setStay_expired_date(String stay_expired_date) {
            this.stay_expired_date = stay_expired_date;
        }

        public String getCheckin_date() {
            return checkin_date;
        }

        public void setCheckin_date(String checkin_date) {
            this.checkin_date = checkin_date;
        }

        public String getCheckout_date() {
            return checkout_date;
        }

        public void setCheckout_date(String checkout_date) {
            this.checkout_date = checkout_date;
        }

        public String getHouse_address() {
            return house_address;
        }

        public void setHouse_address(String house_address) {
            this.house_address = house_address;
        }

        public String getLandlord_identity_image() {
            return landlord_identity_image;
        }

        public void setLandlord_identity_image(String landlord_identity_image) {
            this.landlord_identity_image = landlord_identity_image;
        }

        public String getHouse_contract_image() {
            return house_contract_image;
        }

        public void setHouse_contract_image(String house_contract_image) {
            this.house_contract_image = house_contract_image;
        }

        public String getHouse_type() {
            return house_type;
        }

        public void setHouse_type(String house_type) {
            this.house_type = house_type;
        }

        public String getLandlord_country() {
            return landlord_country;
        }

        public void setLandlord_country(String landlord_country) {
            this.landlord_country = landlord_country;
        }

        public String getLandlord_identity() {
            return landlord_identity;
        }

        public void setLandlord_identity(String landlord_identity) {
            this.landlord_identity = landlord_identity;
        }

        public String getLandlord_name() {
            return landlord_name;
        }

        public void setLandlord_name(String landlord_name) {
            this.landlord_name = landlord_name;
        }

        public String getLandlord_gender() {
            return landlord_gender;
        }

        public void setLandlord_gender(String landlord_gender) {
            this.landlord_gender = landlord_gender;
        }

        public String getLandlord_phone() {
            return landlord_phone;
        }

        public void setLandlord_phone(String landlord_phone) {
            this.landlord_phone = landlord_phone;
        }

        public String getCertificate_image() {
            return certificate_image;
        }

        public void setCertificate_image(String certificate_image) {
            this.certificate_image = certificate_image;
        }

        public String getLeave_date() {
            return leave_date;
        }

        public void setLeave_date(String leave_date) {
            this.leave_date = leave_date;
        }

        public String getLeave_reason() {
            return leave_reason;
        }

        public void setLeave_reason(String leave_reason) {
            this.leave_reason = leave_reason;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getReject_reason() {
            return reject_reason;
        }

        public void setReject_reason(String reject_reason) {
            this.reject_reason = reject_reason;
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

        public Object getReject_fields() {
            return reject_fields;
        }

        public void setReject_fields(Object reject_fields) {
            this.reject_fields = reject_fields;
        }
    }
}
