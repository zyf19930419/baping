package com.weibangbang.api.body;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/15 9:38
 * 功能描述：
 */
public class RegisterBody {
    private String phone;
    private String code;
    private String password;
    private String nvitation;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNvitation() {
        return nvitation;
    }

    public void setNvitation(String nvitation) {
        this.nvitation = nvitation;
    }
}
