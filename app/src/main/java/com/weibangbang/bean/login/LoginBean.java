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
     * data : {"user_phone":"15999999999","user_name":"凡尘","vip_id":1,"user_inviter":2,"user_inviter_qrcode":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539797825628&di=612b4a2dac446ec469e38b2471e94f99&imgtype=0&src=http://img.xiazaizhijia.com/uploads/allimg/131101/36-131101115410148.jpg","user_token":"51ae54d13a9641bc5c1a9995bc0fa7b9"}
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
         * user_phone : 15999999999
         * user_name : 凡尘
         * vip_id : 1
         * user_inviter : 2
         * user_inviter_qrcode : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539797825628&di=612b4a2dac446ec469e38b2471e94f99&imgtype=0&src=http://img.xiazaizhijia.com/uploads/allimg/131101/36-131101115410148.jpg
         * user_token : 51ae54d13a9641bc5c1a9995bc0fa7b9
         */

        private String user_phone;
        private String user_name;
        private int vip_id;
        private int user_inviter;
        private String user_inviter_qrcode;
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

        public int getUser_inviter() {
            return user_inviter;
        }

        public void setUser_inviter(int user_inviter) {
            this.user_inviter = user_inviter;
        }

        public String getUser_inviter_qrcode() {
            return user_inviter_qrcode;
        }

        public void setUser_inviter_qrcode(String user_inviter_qrcode) {
            this.user_inviter_qrcode = user_inviter_qrcode;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }
    }
}
