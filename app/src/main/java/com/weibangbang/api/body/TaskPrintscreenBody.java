package com.weibangbang.api.body;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/18 0018
 * 联系方式：32457127@qq.com
 */
public class TaskPrintscreenBody {
    private String token;
    private String id;
    private String printscreen;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrintscreen() {
        return printscreen;
    }

    public void setPrintscreen(String printscreen) {
        this.printscreen = printscreen;
    }
}
