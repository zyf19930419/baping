package com.weibangbang.bean.home;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/17 0017
 * 联系方式：32457127@qq.com
 */
public class ReceiveInfoBean {

    /**
     * code : 1
     * msg :
     * data : {"receive_id":1,"receive_name":"夏威夷阳光","receive_price":15,"receive_picture":"20181017/be6a9c53d05071d5e0377b29b87723d3.gif","receive_remark":"高级vip领取","receive_creattime":1539589585}
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
         * receive_id : 1
         * receive_name : 夏威夷阳光
         * receive_price : 15
         * receive_picture : 20181017/be6a9c53d05071d5e0377b29b87723d3.gif
         * receive_remark : 高级vip领取
         * receive_creattime : 1539589585
         */

        private int receive_id;
        private String receive_name;
        private int receive_price;
        private String receive_picture;
        private String receive_remark;
        private int receive_creattime;

        public int getReceive_id() {
            return receive_id;
        }

        public void setReceive_id(int receive_id) {
            this.receive_id = receive_id;
        }

        public String getReceive_name() {
            return receive_name;
        }

        public void setReceive_name(String receive_name) {
            this.receive_name = receive_name;
        }

        public int getReceive_price() {
            return receive_price;
        }

        public void setReceive_price(int receive_price) {
            this.receive_price = receive_price;
        }

        public String getReceive_picture() {
            return receive_picture;
        }

        public void setReceive_picture(String receive_picture) {
            this.receive_picture = receive_picture;
        }

        public String getReceive_remark() {
            return receive_remark;
        }

        public void setReceive_remark(String receive_remark) {
            this.receive_remark = receive_remark;
        }

        public int getReceive_creattime() {
            return receive_creattime;
        }

        public void setReceive_creattime(int receive_creattime) {
            this.receive_creattime = receive_creattime;
        }
    }
}
