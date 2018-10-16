package com.weibangbang.bean.home;

/**
 * 创建者：voodoo_jie
 * <br>创建时间：2018/10/16 016下午 02:32
 * <br>功能描述：
 */
public class LaunchCommitBean {


    /**
     * code : 1
     * msg : 提交成功
     * data : {"user_id":1,"user_launch_compellation":"尘","user_launch_phone":"15999999999","user_launch_content":"广告内容","user_launch_createtime":"1538993513"}
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
         * user_id : 1
         * user_launch_compellation : 尘
         * user_launch_phone : 15999999999
         * user_launch_content : 广告内容
         * user_launch_createtime : 1538993513
         */

        private int user_id;
        private String user_launch_compellation;
        private String user_launch_phone;
        private String user_launch_content;
        private String user_launch_createtime;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_launch_compellation() {
            return user_launch_compellation;
        }

        public void setUser_launch_compellation(String user_launch_compellation) {
            this.user_launch_compellation = user_launch_compellation;
        }

        public String getUser_launch_phone() {
            return user_launch_phone;
        }

        public void setUser_launch_phone(String user_launch_phone) {
            this.user_launch_phone = user_launch_phone;
        }

        public String getUser_launch_content() {
            return user_launch_content;
        }

        public void setUser_launch_content(String user_launch_content) {
            this.user_launch_content = user_launch_content;
        }

        public String getUser_launch_createtime() {
            return user_launch_createtime;
        }

        public void setUser_launch_createtime(String user_launch_createtime) {
            this.user_launch_createtime = user_launch_createtime;
        }
    }
}
