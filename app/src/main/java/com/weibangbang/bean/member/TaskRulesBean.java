package com.weibangbang.bean.member;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/17 9:02
 * 功能描述：
 */
public class TaskRulesBean {

    /**
     * code : 1
     * msg :
     * data : {"rule_id":1,"rule_picture":"20181014/f1896fafefdf9cb3ed75668140912e27.gif","rule_explain":"这是个说明!"}
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
         * rule_id : 1
         * rule_picture : 20181014/f1896fafefdf9cb3ed75668140912e27.gif
         * rule_explain : 这是个说明!
         */

        private int rule_id;
        private String rule_picture;
        private String rule_explain;

        public int getRule_id() {
            return rule_id;
        }

        public void setRule_id(int rule_id) {
            this.rule_id = rule_id;
        }

        public String getRule_picture() {
            return rule_picture;
        }

        public void setRule_picture(String rule_picture) {
            this.rule_picture = rule_picture;
        }

        public String getRule_explain() {
            return rule_explain;
        }

        public void setRule_explain(String rule_explain) {
            this.rule_explain = rule_explain;
        }
    }
}
