package com.administration.policebureau.bean;

/**
 * Created by omyrobin on 2018/2/1.
 */

public class UserEntity {
    /**
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjUxLCJpc3MiOiJodHRwOlwvXC93d3cubXlmYW5nc2hhbi5jb21cL2FwaVwvbG9naW4iLCJpYXQiOjE0OTE0NzQzNzksImV4cCI6MTQ5MjA3OTE3OSwibmJmIjoxNDkxNDc0Mzc5LCJqdGkiOiIwYjFjYjVlNjBkMjRiZTBhOWE2MTNhZmM2ZDQ3MzlmZSJ9.QgSUUAENgMcvds-hPZ2poEsbmcil2tJ3iUBzl8rl7XQ
     * user : {"id":51,"passport":"AVDS12345","phone":"13657578907","created_at":"2017-04-06 18:16:12","updated_at":"2017-04-06 18:22:12"}
     */

    private String token;
    private UserBean user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : 51
         * passport : AVDS12345
         * phone : 13657578907
         * created_at : 2017-04-06 18:16:12
         * updated_at : 2017-04-06 18:22:12
         */

        private int id;
        private String passport;
        private String phone;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPassport() {
            return passport;
        }

        public void setPassport(String passport) {
            this.passport = passport;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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
}
