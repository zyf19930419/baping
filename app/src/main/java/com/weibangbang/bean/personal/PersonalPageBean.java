package com.weibangbang.bean.personal;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/15 11:37
 * 功能描述：
 */
public class PersonalPageBean {

    /**
     * code : 1
     * msg :
     * data : {"sum_extract":"0.00","sum_brokerage":"999.00","today_brokerage":"0.00"}
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
         * sum_extract : 0.00
         * sum_brokerage : 999.00
         * today_brokerage : 0.00
         */

        private String sum_extract;
        private String sum_brokerage;
        private String today_brokerage;

        public String getSum_extract() {
            return sum_extract;
        }

        public void setSum_extract(String sum_extract) {
            this.sum_extract = sum_extract;
        }

        public String getSum_brokerage() {
            return sum_brokerage;
        }

        public void setSum_brokerage(String sum_brokerage) {
            this.sum_brokerage = sum_brokerage;
        }

        public String getToday_brokerage() {
            return today_brokerage;
        }

        public void setToday_brokerage(String today_brokerage) {
            this.today_brokerage = today_brokerage;
        }
    }
}
