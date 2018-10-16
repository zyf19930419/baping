package com.weibangbang.bean.member;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/16 11:08
 * 功能描述：
 */
public class MyTaskBean {

    /**
     * code : 1
     * msg :
     * data : [{"user_task_id":1,"user_id":1,"task_id":1,"user_task_status":3,"user_task_printscreen":"","user_task_money":"0.00","user_task_createtime":1538987130}]
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
         * user_task_id : 1
         * user_id : 1
         * task_id : 1
         * user_task_status : 3
         * user_task_printscreen :
         * user_task_money : 0.00
         * user_task_createtime : 1538987130
         */

        private int user_task_id;
        private int user_id;
        private int task_id;
        private int user_task_status;
        private String user_task_printscreen;
        private String user_task_money;
        private int user_task_createtime;

        public int getUser_task_id() {
            return user_task_id;
        }

        public void setUser_task_id(int user_task_id) {
            this.user_task_id = user_task_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getTask_id() {
            return task_id;
        }

        public void setTask_id(int task_id) {
            this.task_id = task_id;
        }

        public int getUser_task_status() {
            return user_task_status;
        }

        public void setUser_task_status(int user_task_status) {
            this.user_task_status = user_task_status;
        }

        public String getUser_task_printscreen() {
            return user_task_printscreen;
        }

        public void setUser_task_printscreen(String user_task_printscreen) {
            this.user_task_printscreen = user_task_printscreen;
        }

        public String getUser_task_money() {
            return user_task_money;
        }

        public void setUser_task_money(String user_task_money) {
            this.user_task_money = user_task_money;
        }

        public int getUser_task_createtime() {
            return user_task_createtime;
        }

        public void setUser_task_createtime(int user_task_createtime) {
            this.user_task_createtime = user_task_createtime;
        }
    }
}
