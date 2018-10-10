package com.weibangbang.bean.home;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:23
 * 功能描述：
 */
public class BannerBean {

    /**
     * code : 1
     * msg :
     * data : [{"banner_id":1,"banner_name":"茅台","banner_content":"20180924\\ed881c5a774f02899dab27c965be38d6.jpg","banner_sort":1,"banner_area":1,"banner_creattime":0}]
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
         * banner_id : 1
         * banner_name : 茅台
         * banner_content : 20180924\ed881c5a774f02899dab27c965be38d6.jpg
         * banner_sort : 1
         * banner_area : 1
         * banner_creattime : 0
         */

        private int banner_id;
        private String banner_name;
        private String banner_content;
        private int banner_sort;
        private int banner_area;
        private int banner_creattime;

        public int getBanner_id() {
            return banner_id;
        }

        public void setBanner_id(int banner_id) {
            this.banner_id = banner_id;
        }

        public String getBanner_name() {
            return banner_name;
        }

        public void setBanner_name(String banner_name) {
            this.banner_name = banner_name;
        }

        public String getBanner_content() {
            return banner_content;
        }

        public void setBanner_content(String banner_content) {
            this.banner_content = banner_content;
        }

        public int getBanner_sort() {
            return banner_sort;
        }

        public void setBanner_sort(int banner_sort) {
            this.banner_sort = banner_sort;
        }

        public int getBanner_area() {
            return banner_area;
        }

        public void setBanner_area(int banner_area) {
            this.banner_area = banner_area;
        }

        public int getBanner_creattime() {
            return banner_creattime;
        }

        public void setBanner_creattime(int banner_creattime) {
            this.banner_creattime = banner_creattime;
        }
    }
}
