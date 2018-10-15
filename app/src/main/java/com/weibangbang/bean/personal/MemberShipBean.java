package com.weibangbang.bean.personal;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/15 0015
 * 联系方式：32457127@qq.com
 */
public class MemberShipBean {

    /**
     * code : 1
     * msg :
     * data : [{"user_id":2,"user_sex":2,"user_phone":"15999999998","user_password":"96e79218965eb72c92a549dd5a330112","user_name":"明溪","user_city":"城市","user_downtown":"区域","user_site":"道路","user_balance":"562.00","vip_id":2,"user_invitation":"aasdasd","user_inviter":1,"user_inviter_2":0,"user_history_brokerage":"999.00","user_history_withdraw":"0.00","user_token":"952d832806c7eec60b00e5c8de3925f2","user_portrait":""}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 2
         * user_sex : 2
         * user_phone : 15999999998
         * user_password : 96e79218965eb72c92a549dd5a330112
         * user_name : 明溪
         * user_city : 城市
         * user_downtown : 区域
         * user_site : 道路
         * user_balance : 562.00
         * vip_id : 2
         * user_invitation : aasdasd
         * user_inviter : 1
         * user_inviter_2 : 0
         * user_history_brokerage : 999.00
         * user_history_withdraw : 0.00
         * user_token : 952d832806c7eec60b00e5c8de3925f2
         * user_portrait :
         */

        private int user_id;
        private int user_sex;
        private String user_phone;
        private String user_password;
        private String user_name;
        private String user_city;
        private String user_downtown;
        private String user_site;
        private String user_balance;
        private int vip_id;
        private String user_invitation;
        private int user_inviter;
        private int user_inviter_2;
        private String user_history_brokerage;
        private String user_history_withdraw;
        private String user_token;
        private String user_portrait;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getUser_sex() {
            return user_sex;
        }

        public void setUser_sex(int user_sex) {
            this.user_sex = user_sex;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_city() {
            return user_city;
        }

        public void setUser_city(String user_city) {
            this.user_city = user_city;
        }

        public String getUser_downtown() {
            return user_downtown;
        }

        public void setUser_downtown(String user_downtown) {
            this.user_downtown = user_downtown;
        }

        public String getUser_site() {
            return user_site;
        }

        public void setUser_site(String user_site) {
            this.user_site = user_site;
        }

        public String getUser_balance() {
            return user_balance;
        }

        public void setUser_balance(String user_balance) {
            this.user_balance = user_balance;
        }

        public int getVip_id() {
            return vip_id;
        }

        public void setVip_id(int vip_id) {
            this.vip_id = vip_id;
        }

        public String getUser_invitation() {
            return user_invitation;
        }

        public void setUser_invitation(String user_invitation) {
            this.user_invitation = user_invitation;
        }

        public int getUser_inviter() {
            return user_inviter;
        }

        public void setUser_inviter(int user_inviter) {
            this.user_inviter = user_inviter;
        }

        public int getUser_inviter_2() {
            return user_inviter_2;
        }

        public void setUser_inviter_2(int user_inviter_2) {
            this.user_inviter_2 = user_inviter_2;
        }

        public String getUser_history_brokerage() {
            return user_history_brokerage;
        }

        public void setUser_history_brokerage(String user_history_brokerage) {
            this.user_history_brokerage = user_history_brokerage;
        }

        public String getUser_history_withdraw() {
            return user_history_withdraw;
        }

        public void setUser_history_withdraw(String user_history_withdraw) {
            this.user_history_withdraw = user_history_withdraw;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }

        public String getUser_portrait() {
            return user_portrait;
        }

        public void setUser_portrait(String user_portrait) {
            this.user_portrait = user_portrait;
        }
    }
}
