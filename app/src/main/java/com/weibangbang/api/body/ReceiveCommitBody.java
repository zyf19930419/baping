package com.weibangbang.api.body;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/15 0015
 * 联系方式：32457127@qq.com
 */
public class ReceiveCommitBody {
    private String token;
    private String compellation;
    private String phone;
    private String address;
    private String createtime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCompellation() {
        return compellation;
    }

    public void setCompellation(String compellation) {
        this.compellation = compellation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
