package com.weibangbang.api.body;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/16 9:52
 * 功能描述：
 */
public class ChangePasswordBody {
    private String token;
    private String old_pass;
    private String new_pass;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOld_pass() {
        return old_pass;
    }

    public void setOld_pass(String old_pass) {
        this.old_pass = old_pass;
    }

    public String getNew_pass() {
        return new_pass;
    }

    public void setNew_pass(String new_pass) {
        this.new_pass = new_pass;
    }
}
