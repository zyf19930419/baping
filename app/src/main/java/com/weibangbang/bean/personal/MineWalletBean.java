package com.weibangbang.bean.personal;

// FIXME generate failure  field _$Data112

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/16 15:05
 * 功能描述：
 */
public class MineWalletBean {


    /**
     * code : 1
     * msg :
     * data : {"balance_find":{"user_balance":"99.00"},"detail_day":[{"detail_id":1,"task_id":1,"user_id":1,"user_name":"涅凡尘","detail_type":1,"detail_explain":1,"money":"50.00","detail_creattime":3213213,"task_name":"任务001","task_creattime":1537769228,"task_level":1}]}
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
         * balance_find : {"user_balance":"99.00"}
         * detail_day : [{"detail_id":1,"task_id":1,"user_id":1,"user_name":"涅凡尘","detail_type":1,"detail_explain":1,"money":"50.00","detail_creattime":3213213,"task_name":"任务001","task_creattime":1537769228,"task_level":1}]
         */

        private BalanceFindBean balance_find;
        private List<DetailDayBean> detail_day;

        public BalanceFindBean getBalance_find() {
            return balance_find;
        }

        public void setBalance_find(BalanceFindBean balance_find) {
            this.balance_find = balance_find;
        }

        public List<DetailDayBean> getDetail_day() {
            return detail_day;
        }

        public void setDetail_day(List<DetailDayBean> detail_day) {
            this.detail_day = detail_day;
        }

        public static class BalanceFindBean {
            /**
             * user_balance : 99.00
             */

            private String user_balance;

            public String getUser_balance() {
                return user_balance;
            }

            public void setUser_balance(String user_balance) {
                this.user_balance = user_balance;
            }
        }

        public static class DetailDayBean {
            /**
             * detail_id : 1
             * task_id : 1
             * user_id : 1
             * user_name : 涅凡尘
             * detail_type : 1
             * detail_explain : 1
             * money : 50.00
             * detail_creattime : 3213213
             * task_name : 任务001
             * task_creattime : 1537769228
             * task_level : 1
             */

            private int detail_id;
            private int task_id;
            private int user_id;
            private String user_name;
            private int detail_type;
            private int detail_explain;
            private String money;
            private int detail_creattime;
            private String task_name;
            private int task_creattime;
            private int task_level;

            public int getDetail_id() {
                return detail_id;
            }

            public void setDetail_id(int detail_id) {
                this.detail_id = detail_id;
            }

            public int getTask_id() {
                return task_id;
            }

            public void setTask_id(int task_id) {
                this.task_id = task_id;
            }

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

            public int getDetail_type() {
                return detail_type;
            }

            public void setDetail_type(int detail_type) {
                this.detail_type = detail_type;
            }

            public int getDetail_explain() {
                return detail_explain;
            }

            public void setDetail_explain(int detail_explain) {
                this.detail_explain = detail_explain;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public int getDetail_creattime() {
                return detail_creattime;
            }

            public void setDetail_creattime(int detail_creattime) {
                this.detail_creattime = detail_creattime;
            }

            public String getTask_name() {
                return task_name;
            }

            public void setTask_name(String task_name) {
                this.task_name = task_name;
            }

            public int getTask_creattime() {
                return task_creattime;
            }

            public void setTask_creattime(int task_creattime) {
                this.task_creattime = task_creattime;
            }

            public int getTask_level() {
                return task_level;
            }

            public void setTask_level(int task_level) {
                this.task_level = task_level;
            }
        }
    }
}
