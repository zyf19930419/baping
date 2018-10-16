package com.weibangbang.bean.home;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/16 0016
 * 联系方式：32457127@qq.com
 */
public class CustomerBean {


    /**
     * code : 1
     * msg :
     * data : {"service":[{"service_id":1,"service_name":"微信","service_contact":"15977777777","service_creattime":1539480792},{"service_id":2,"service_name":"微信","service_contact":"18888888888","service_creattime":1539480810}],"information":{"service_id":1,"service_phone":"022-2458-0118","service_time":"AM 9.00~11.00 PM 1.00~6.00"}}
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
         * service : [{"service_id":1,"service_name":"微信","service_contact":"15977777777","service_creattime":1539480792},{"service_id":2,"service_name":"微信","service_contact":"18888888888","service_creattime":1539480810}]
         * information : {"service_id":1,"service_phone":"022-2458-0118","service_time":"AM 9.00~11.00 PM 1.00~6.00"}
         */

        private InformationBean information;
        private List<ServiceBean> service;

        public InformationBean getInformation() {
            return information;
        }

        public void setInformation(InformationBean information) {
            this.information = information;
        }

        public List<ServiceBean> getService() {
            return service;
        }

        public void setService(List<ServiceBean> service) {
            this.service = service;
        }

        public static class InformationBean {
            /**
             * service_id : 1
             * service_phone : 022-2458-0118
             * service_time : AM 9.00~11.00 PM 1.00~6.00
             */

            private int service_id;
            private String service_phone;
            private String service_time;

            public int getService_id() {
                return service_id;
            }

            public void setService_id(int service_id) {
                this.service_id = service_id;
            }

            public String getService_phone() {
                return service_phone;
            }

            public void setService_phone(String service_phone) {
                this.service_phone = service_phone;
            }

            public String getService_time() {
                return service_time;
            }

            public void setService_time(String service_time) {
                this.service_time = service_time;
            }
        }

        public static class ServiceBean {
            /**
             * service_id : 1
             * service_name : 微信
             * service_contact : 15977777777
             * service_creattime : 1539480792
             */

            private int service_id;
            private String service_name;
            private String service_contact;
            private int service_creattime;

            public int getService_id() {
                return service_id;
            }

            public void setService_id(int service_id) {
                this.service_id = service_id;
            }

            public String getService_name() {
                return service_name;
            }

            public void setService_name(String service_name) {
                this.service_name = service_name;
            }

            public String getService_contact() {
                return service_contact;
            }

            public void setService_contact(String service_contact) {
                this.service_contact = service_contact;
            }

            public int getService_creattime() {
                return service_creattime;
            }

            public void setService_creattime(int service_creattime) {
                this.service_creattime = service_creattime;
            }
        }
    }
}
