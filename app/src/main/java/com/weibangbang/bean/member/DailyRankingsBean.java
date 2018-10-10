package com.weibangbang.bean.member;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/10 17:04
 * 功能描述：
 */
public class DailyRankingsBean {

    /**
     * code : 1
     * msg :
     * data : [{"user_id":13,"user_name":"肖毅","money":"45643.00"}]
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
         * user_id : 13
         * user_name : 肖毅
         * money : 45643.00
         */

        private int user_id;
        private String user_name;
        private String money;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }
}
