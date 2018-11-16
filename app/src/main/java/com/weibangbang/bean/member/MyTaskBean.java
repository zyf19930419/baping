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
     * data : [{"user_task_id":10,"user_id":1,"task_id":1,"user_task_status":1,"user_task_printscreen":"","user_task_money":"0.00","user_task_createtime":1539878982,"task_name":"任务标题","task_require":"任务要求","task_content":"任务文案","task_image":"20181015/acd5cc13b267de2fa3de244222cfbd8c.jpg","task_creattime":1537769228,"task_level":1},{"user_task_id":9,"user_id":1,"task_id":1,"user_task_status":1,"user_task_printscreen":"","user_task_money":"0.00","user_task_createtime":1539877616,"task_name":"任务标题","task_require":"任务要求","task_content":"任务文案","task_image":"20181015/acd5cc13b267de2fa3de244222cfbd8c.jpg","task_creattime":1537769228,"task_level":1},{"user_task_id":8,"user_id":1,"task_id":1,"user_task_status":1,"user_task_printscreen":"","user_task_money":"0.00","user_task_createtime":1539874086,"task_name":"任务标题","task_require":"任务要求","task_content":"任务文案","task_image":"20181015/acd5cc13b267de2fa3de244222cfbd8c.jpg","task_creattime":1537769228,"task_level":1},{"user_task_id":7,"user_id":1,"task_id":1,"user_task_status":1,"user_task_printscreen":"","user_task_money":"0.00","user_task_createtime":1539859748,"task_name":"任务标题","task_require":"任务要求","task_content":"任务文案","task_image":"20181015/acd5cc13b267de2fa3de244222cfbd8c.jpg","task_creattime":1537769228,"task_level":1},{"user_task_id":6,"user_id":1,"task_id":1,"user_task_status":1,"user_task_printscreen":"","user_task_money":"0.00","user_task_createtime":1539791606,"task_name":"任务标题","task_require":"任务要求","task_content":"任务文案","task_image":"20181015/acd5cc13b267de2fa3de244222cfbd8c.jpg","task_creattime":1537769228,"task_level":1},{"user_task_id":5,"user_id":1,"task_id":1,"user_task_status":1,"user_task_printscreen":"","user_task_money":"0.00","user_task_createtime":1539791350,"task_name":"任务标题","task_require":"任务要求","task_content":"任务文案","task_image":"20181015/acd5cc13b267de2fa3de244222cfbd8c.jpg","task_creattime":1537769228,"task_level":1},{"user_task_id":4,"user_id":1,"task_id":1,"user_task_status":1,"user_task_printscreen":"","user_task_money":"0.00","user_task_createtime":1539791240,"task_name":"任务标题","task_require":"任务要求","task_content":"任务文案","task_image":"20181015/acd5cc13b267de2fa3de244222cfbd8c.jpg","task_creattime":1537769228,"task_level":1},{"user_task_id":3,"user_id":1,"task_id":2,"user_task_status":2,"user_task_printscreen":"20181018/0218b2ad50f6000a89f2cb77905faa8e.jpg","user_task_money":"0.00","user_task_createtime":1539582813,"task_name":"飞跃天门山","task_require":"10分钟内飞跃天门山","task_content":"天门山位于我国.....","task_image":"20181017/e2013053abd39e770b2dc70b897e6ac6.gif","task_creattime":1539768508,"task_level":2}]
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
         * user_task_id : 10
         * user_id : 1
         * task_id : 1
         * user_task_status : 1
         * user_task_printscreen :
         * user_task_money : 0.00
         * user_task_createtime : 1539878982
         * task_name : 任务标题
         * task_require : 任务要求
         * task_content : 任务文案
         * task_image : 20181015/acd5cc13b267de2fa3de244222cfbd8c.jpg
         * task_creattime : 1537769228
         * task_level : 1
         * user_task_status_chinese
         */

        private int user_task_id;
        private int user_id;
        private int task_id;
        private int user_task_status;
        private String user_task_printscreen;
        private String user_task_money;
        private int user_task_createtime;
        private String task_name;
        private String task_require;
        private String task_content;
        private String task_image;
        private int task_creattime;
        private int task_level;
        private String user_task_status_chinese;

        public String getUser_task_status_chinese() {
            return user_task_status_chinese;
        }

        public void setUser_task_status_chinese(String user_task_status_chinese) {
            this.user_task_status_chinese = user_task_status_chinese;
        }

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

        public String getTask_name() {
            return task_name;
        }

        public void setTask_name(String task_name) {
            this.task_name = task_name;
        }

        public String getTask_require() {
            return task_require;
        }

        public void setTask_require(String task_require) {
            this.task_require = task_require;
        }

        public String getTask_content() {
            return task_content;
        }

        public void setTask_content(String task_content) {
            this.task_content = task_content;
        }

        public String getTask_image() {
            return task_image;
        }

        public void setTask_image(String task_image) {
            this.task_image = task_image;
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
