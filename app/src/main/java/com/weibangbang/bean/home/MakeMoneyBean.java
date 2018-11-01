package com.weibangbang.bean.home;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/17 8:49
 * 功能描述：
 */
public class MakeMoneyBean {


    /**
     * code : 1
     * msg :
     * data : [{"commission_id":1,"commission_content":"第一步骤"},{"commission_id":2,"commission_content":"第二步骤"},{"commission_id":3,"commission_content":"第三步骤"},{"commission_id":4,"commission_content":"第四步骤"},{"commission_id":5,"commission_content":"第五步骤"}]
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
         * commission_id : 1
         * commission_content : 第一步骤
         */

        private int commission_id;
        private String commission_content;

        public int getCommission_id() {
            return commission_id;
        }

        public void setCommission_id(int commission_id) {
            this.commission_id = commission_id;
        }

        public String getCommission_content() {
            return commission_content;
        }

        public void setCommission_content(String commission_content) {
            this.commission_content = commission_content;
        }
    }
}
