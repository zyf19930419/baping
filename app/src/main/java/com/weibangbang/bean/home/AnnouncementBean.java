package com.weibangbang.bean.home;

/**
 * 创建者：zhangyunfei
 * 时间：2018/11/1 0001
 * 联系方式：32457127@qq.com
 */
public class AnnouncementBean {

    /**
     * code : 1
     * msg :
     * data : {"notice_id":2,"notice_title":"微帮帮预热","notice_brief":"正在做最后调试","notice_content":"即将降临","notice_creattime":1541041848}
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
         * notice_id : 2
         * notice_title : 微帮帮预热
         * notice_brief : 正在做最后调试
         * notice_content : 即将降临
         * notice_creattime : 1541041848
         */

        private int notice_id;
        private String notice_title;
        private String notice_brief;
        private String notice_content;
        private int notice_creattime;

        public int getNotice_id() {
            return notice_id;
        }

        public void setNotice_id(int notice_id) {
            this.notice_id = notice_id;
        }

        public String getNotice_title() {
            return notice_title;
        }

        public void setNotice_title(String notice_title) {
            this.notice_title = notice_title;
        }

        public String getNotice_brief() {
            return notice_brief;
        }

        public void setNotice_brief(String notice_brief) {
            this.notice_brief = notice_brief;
        }

        public String getNotice_content() {
            return notice_content;
        }

        public void setNotice_content(String notice_content) {
            this.notice_content = notice_content;
        }

        public int getNotice_creattime() {
            return notice_creattime;
        }

        public void setNotice_creattime(int notice_creattime) {
            this.notice_creattime = notice_creattime;
        }
    }
}
