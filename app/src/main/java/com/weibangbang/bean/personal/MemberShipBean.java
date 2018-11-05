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
     * data : [{"user_id":2,"user_sex":1,"user_age":5,"user_phone":"15999999998","user_password":"96e79218965eb72c92a549dd5a330112","user_name":"明溪","user_city":"城市","user_downtown":"区域","user_site":"道路","user_balance":"646.00","vip_id":2,"user_invitation":"456","user_invitation_qrcode":"","user_inviter":1,"user_inviter_2":0,"user_history_brokerage":"1023.00","user_history_withdraw":"0.00","user_token":"72da541df3705bc636777e8de8f1c731","user_portrait":"20181103/f8c4636b2d30e4e9843195f9aff0e0d0.png","vip_name":"高级会员","vip_price":999,"vip_describe":""}]
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
         * user_sex : 1
         * user_age : 5
         * user_phone : 15999999998
         * user_password : 96e79218965eb72c92a549dd5a330112
         * user_name : 明溪
         * user_city : 城市
         * user_downtown : 区域
         * user_site : 道路
         * user_balance : 646.00
         * vip_id : 2
         * user_invitation : 456
         * user_invitation_qrcode :
         * user_inviter : 1
         * user_inviter_2 : 0
         * user_history_brokerage : 1023.00
         * user_history_withdraw : 0.00
         * user_token : 72da541df3705bc636777e8de8f1c731
         * user_portrait : 20181103/f8c4636b2d30e4e9843195f9aff0e0d0.png
         * vip_name : 高级会员
         * vip_price : 999
         * vip_describe :
         */

        private int user_id;
        private int user_sex;
        private int user_age;
        private String user_phone;
        private String user_password;
        private String user_name;
        private String user_city;
        private String user_downtown;
        private String user_site;
        private String user_balance;
        private int vip_id;
        private String user_invitation;
        private String user_invitation_qrcode;
        private int user_inviter;
        private int user_inviter_2;
        private String user_history_brokerage;
        private String user_history_withdraw;
        private String user_token;
        private String user_portrait;
        private String vip_name;
        private int vip_price;
        private String vip_describe;

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

        public int getUser_age() {
            return user_age;
        }

        public void setUser_age(int user_age) {
            this.user_age = user_age;
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

        public String getUser_invitation_qrcode() {
            return user_invitation_qrcode;
        }

        public void setUser_invitation_qrcode(String user_invitation_qrcode) {
            this.user_invitation_qrcode = user_invitation_qrcode;
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

        public String getVip_name() {
            return vip_name;
        }

        public void setVip_name(String vip_name) {
            this.vip_name = vip_name;
        }

        public int getVip_price() {
            return vip_price;
        }

        public void setVip_price(int vip_price) {
            this.vip_price = vip_price;
        }

        public String getVip_describe() {
            return vip_describe;
        }

        public void setVip_describe(String vip_describe) {
            this.vip_describe = vip_describe;
        }
    }
}
