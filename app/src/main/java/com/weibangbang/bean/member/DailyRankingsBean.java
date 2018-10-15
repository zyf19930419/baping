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
     * data : [{"user_name":"明溪","user_portrait":"","user_history_brokerage":"999.00"},{"user_name":"尘","user_portrait":"","user_history_brokerage":"100.00"},{"user_name":"","user_portrait":"","user_history_brokerage":"0.00"}]
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
         * user_name : 明溪
         * user_portrait :
         * user_history_brokerage : 999.00
         */

        private String user_name;
        private String user_portrait;
        private String user_history_brokerage;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_portrait() {
            return user_portrait;
        }

        public void setUser_portrait(String user_portrait) {
            this.user_portrait = user_portrait;
        }

        public String getUser_history_brokerage() {
            return user_history_brokerage;
        }

        public void setUser_history_brokerage(String user_history_brokerage) {
            this.user_history_brokerage = user_history_brokerage;
        }
    }
}
