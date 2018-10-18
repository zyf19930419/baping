package com.weibangbang.bean.personal;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/18 0018
 * 联系方式：32457127@qq.com
 */
public class UpLoadBean {

    /**
     * code : 1
     * msg : 上传成功
     * data : {"path":"20181018/a6d23ac6a3d147ef83372735cda80963.jpg"}
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
         * path : 20181018/a6d23ac6a3d147ef83372735cda80963.jpg
         */

        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
