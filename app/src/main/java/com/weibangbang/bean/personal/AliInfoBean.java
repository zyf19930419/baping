package com.weibangbang.bean.personal;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/31 8:46
 * 功能描述：
 */
public class AliInfoBean {

    /**
     * code : 1
     * msg :
     * data : {"paramData":{"apiname":"com.alipay.account.auth","method":"alipay.open.auth.sdk.code.get","app_id":"2018101161603996","app_name":"mc","biz_type":"openservice","pid":"2088331047751571","product_id":"APP_FAST_LOGIN","scope":"kuaijie","target_id":"11540910981","auth_type":"AUTHACCOUNT","sign_type":"RSA2","sign":"ELnKBMepvNyv3iVEEbOb7mMyvT0zCTkCrqVylznkIS3s7XpMR3+sJiLFEFTPOVRBv/DUl6HfgQ3+X1juE2p/PCiwz4ym6yeam+ncJDaJqSqBJvHRNQAV2nntvNI6P75HqY4nLu7YGeDO/ZBQu2DrBtHtsx5CGg0AaQmpakvYd2PrdzNs+ow6Ch+i+Hwy/MNly7vSbdFSemRyrUzpoOJSibxqsrjIQPHKYIgNTvfDK3gL4XKjqqZeo/5X/IfGsM1Q9rasZAnLjJnMIdj/Us+N/utJHw3I8pWRIhxwJhTkPnA0agVFGkBgnvFSYTacpdpvkyfM8lwY3/OSKuexUscnaw=="}}
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
         * paramData : {"apiname":"com.alipay.account.auth","method":"alipay.open.auth.sdk.code.get","app_id":"2018101161603996","app_name":"mc","biz_type":"openservice","pid":"2088331047751571","product_id":"APP_FAST_LOGIN","scope":"kuaijie","target_id":"11540910981","auth_type":"AUTHACCOUNT","sign_type":"RSA2","sign":"ELnKBMepvNyv3iVEEbOb7mMyvT0zCTkCrqVylznkIS3s7XpMR3+sJiLFEFTPOVRBv/DUl6HfgQ3+X1juE2p/PCiwz4ym6yeam+ncJDaJqSqBJvHRNQAV2nntvNI6P75HqY4nLu7YGeDO/ZBQu2DrBtHtsx5CGg0AaQmpakvYd2PrdzNs+ow6Ch+i+Hwy/MNly7vSbdFSemRyrUzpoOJSibxqsrjIQPHKYIgNTvfDK3gL4XKjqqZeo/5X/IfGsM1Q9rasZAnLjJnMIdj/Us+N/utJHw3I8pWRIhxwJhTkPnA0agVFGkBgnvFSYTacpdpvkyfM8lwY3/OSKuexUscnaw=="}
         */

        private ParamDataBean paramData;

        public ParamDataBean getParamData() {
            return paramData;
        }

        public void setParamData(ParamDataBean paramData) {
            this.paramData = paramData;
        }

        public static class ParamDataBean {

            /**
             * apiname : com.alipay.account.auth
             * method : alipay.open.auth.sdk.code.get
             * app_id : 2018101161603996
             * app_name : mc
             * biz_type : openservice
             * pid : 2088331047751571
             * product_id : APP_FAST_LOGIN
             * scope : kuaijie
             * target_id : 11540910981
             * auth_type : AUTHACCOUNT
             * sign_type : RSA2
             * sign : ELnKBMepvNyv3iVEEbOb7mMyvT0zCTkCrqVylznkIS3s7XpMR3+sJiLFEFTPOVRBv/DUl6HfgQ3+X1juE2p/PCiwz4ym6yeam+ncJDaJqSqBJvHRNQAV2nntvNI6P75HqY4nLu7YGeDO/ZBQu2DrBtHtsx5CGg0AaQmpakvYd2PrdzNs+ow6Ch+i+Hwy/MNly7vSbdFSemRyrUzpoOJSibxqsrjIQPHKYIgNTvfDK3gL4XKjqqZeo/5X/IfGsM1Q9rasZAnLjJnMIdj/Us+N/utJHw3I8pWRIhxwJhTkPnA0agVFGkBgnvFSYTacpdpvkyfM8lwY3/OSKuexUscnaw==
             */

            private String apiname;
            private String method;
            private String app_id;
            private String app_name;
            private String biz_type;
            private String pid;
            private String product_id;
            private String scope;
            private String target_id;
            private String auth_type;
            private String sign_type;
            private String sign;

            public String getApiname() {
                return apiname;
            }

            public void setApiname(String apiname) {
                this.apiname = apiname;
            }

            public String getMethod() {
                return method;
            }

            public void setMethod(String method) {
                this.method = method;
            }

            public String getApp_id() {
                return app_id;
            }

            public void setApp_id(String app_id) {
                this.app_id = app_id;
            }

            public String getApp_name() {
                return app_name;
            }

            public void setApp_name(String app_name) {
                this.app_name = app_name;
            }

            public String getBiz_type() {
                return biz_type;
            }

            public void setBiz_type(String biz_type) {
                this.biz_type = biz_type;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public String getScope() {
                return scope;
            }

            public void setScope(String scope) {
                this.scope = scope;
            }

            public String getTarget_id() {
                return target_id;
            }

            public void setTarget_id(String target_id) {
                this.target_id = target_id;
            }

            public String getAuth_type() {
                return auth_type;
            }

            public void setAuth_type(String auth_type) {
                this.auth_type = auth_type;
            }

            public String getSign_type() {
                return sign_type;
            }

            public void setSign_type(String sign_type) {
                this.sign_type = sign_type;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            /**
             * apiname=com.alipay.account.auth&app_id=xxxxx&app_name=mc&auth_type=AUTHACCOUNT&biz_type=openservice&method=alipay.open.auth.sdk.code.get&pid=xxxxx&product_id=APP_FAST_LOGIN&scope=kuaijie&sign_type=RSA2&target_id=20141225xxxx&sign=fMcp4GtiM6rxSIeFnJCVePJKV43eXrUP86CQgiLhDHH2u%2FdN75eEvmywc2ulkm7qKRetkU9fbVZtJIqFdMJcJ9Yp%2BJI%2FF%2FpESafFR6rB2fRjiQQLGXvxmDGVMjPSxHxVtIqpZy5FDoKUSjQ2%2FILDKpu3%2F%2BtAtm2jRw1rUoMhgt0%3D
             */
            @Override
            public String toString() {
                return "apiname=" + apiname  +
                        "&method=" + method  +
                        "&app_id=" + app_id  +
                        "&app_name=" + app_name  +
                        "&biz_type=" + biz_type  +
                        "&pid=" + pid  +
                        "&product_id=" + product_id  +
                        "&scope=" + scope  +
                        "&target_id=" + target_id  +
                        "&auth_type=" + auth_type  +
                        "&sign_type=" + sign_type  +
                        "&sign=" + sign ;
            }
        }
    }
}
