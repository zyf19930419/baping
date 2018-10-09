package com.weibangbang.bean;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:40
 * 功能描述：
 */
public class NoticeBean {

    /**
     * code : 1
     * msg :
     * data : [{"notice_id":2,"notice_title":"站内公告","notice_content":"<p>中秋会员优惠<img src=\"/ueditor/php/upload/image/20180923/1537687866514660.jpg\" title=\"1537687866514660.jpg\" alt=\"QQ图片20180908132158.jpg\"/><\/p>","notice_creattime":1537687868}]
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
         * notice_id : 2
         * notice_title : 站内公告
         * notice_content : <p>中秋会员优惠<img src="/ueditor/php/upload/image/20180923/1537687866514660.jpg" title="1537687866514660.jpg" alt="QQ图片20180908132158.jpg"/></p>
         * notice_creattime : 1537687868
         */

        private int notice_id;
        private String notice_title;
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
