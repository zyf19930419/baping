package com.weibangbang.bean.login;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/14 0014
 * 联系方式：32457127@qq.com
 */
public class LoginBean {

    /**
     * code : 1
     * msg : 登录成功
     * data : {"user_phone":"15999999998","user_name":"明溪","vip_id":1,"user_token":"2a60dc46ad91fa6fd2c258fe4a6d3f0e"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_phone : 15999999998
         * user_name : 明溪
         * vip_id : 1
         * user_token : 2a60dc46ad91fa6fd2c258fe4a6d3f0e
         */

        private String user_phone;
        private String user_name;
        private int vip_id;
        private String user_token;

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getVip_id() {
            return vip_id;
        }

        public void setVip_id(int vip_id) {
            this.vip_id = vip_id;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }
    }
}
