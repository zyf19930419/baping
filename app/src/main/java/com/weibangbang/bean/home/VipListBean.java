package com.weibangbang.bean.home;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/16 17:56
 * 功能描述：
 */
public class VipListBean {

    /**
     * code : 1
     * msg :
     * data : [{"vip_id":1,"vip_name":"普通vip","vip_price":"99.00","vip_describe":""}]
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
         * vip_id : 1
         * vip_name : 普通vip
         * vip_price : 99.00
         * vip_describe :
         */

        private int vip_id;
        private String vip_name;
        private String vip_price;
        private String vip_describe;

        public int getVip_id() {
            return vip_id;
        }

        public void setVip_id(int vip_id) {
            this.vip_id = vip_id;
        }

        public String getVip_name() {
            return vip_name;
        }

        public void setVip_name(String vip_name) {
            this.vip_name = vip_name;
        }

        public String getVip_price() {
            return vip_price;
        }

        public void setVip_price(String vip_price) {
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
