package com.weibangbang.bean.member;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/15 0015
 * 联系方式：32457127@qq.com
 */
public class LobbyBean {

    /**
     * code : 1
     * msg :
     * data : [{"task_id":1,"task_name":"任务001","task_require":"","task_image":"","task_content":"<p><img src=\"/ueditor/php/upload/image/20180924/1537769218131759.jpg\" title=\"1537769218131759.jpg\" alt=\"QQ图片20180908132158.jpg\"/>任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001<\/p>","task_creattime":1537769228,"task_level":1}]
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
         * task_id : 1
         * task_name : 任务001
         * task_require :
         * task_image :
         * task_content : <p><img src="/ueditor/php/upload/image/20180924/1537769218131759.jpg" title="1537769218131759.jpg" alt="QQ图片20180908132158.jpg"/>任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001任务001</p>
         * task_creattime : 1537769228
         * task_level : 1
         * "task_profit": "4.00",
         "user_inviter": "1.00",
         "user_inviter_2": "1.00",
         "task_number": 1000,
         "task_getnum": 0
         */

        private int task_id;
        private String task_name;
        private String task_require;
        private String task_image;
        private String task_content;
        private int task_creattime;
        private int task_level;
        private String task_profit;
        private String user_inviter;
        private String user_inviter_2;
        private String task_number;
        private String task_getnum;

        public String getTask_profit() {
            return task_profit;
        }

        public void setTask_profit(String task_profit) {
            this.task_profit = task_profit;
        }

        public String getUser_inviter() {
            return user_inviter;
        }

        public void setUser_inviter(String user_inviter) {
            this.user_inviter = user_inviter;
        }

        public String getUser_inviter_2() {
            return user_inviter_2;
        }

        public void setUser_inviter_2(String user_inviter_2) {
            this.user_inviter_2 = user_inviter_2;
        }

        public String getTask_number() {
            return task_number;
        }

        public void setTask_number(String task_number) {
            this.task_number = task_number;
        }

        public String getTask_getnum() {
            return task_getnum;
        }

        public void setTask_getnum(String task_getnum) {
            this.task_getnum = task_getnum;
        }

        public int getTask_id() {
            return task_id;
        }

        public void setTask_id(int task_id) {
            this.task_id = task_id;
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

        public String getTask_image() {
            return task_image;
        }

        public void setTask_image(String task_image) {
            this.task_image = task_image;
        }

        public String getTask_content() {
            return task_content;
        }

        public void setTask_content(String task_content) {
            this.task_content = task_content;
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
