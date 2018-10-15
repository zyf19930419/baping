package com.weibangbang.api.body;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/15 9:39
 * 功能描述：
 */
public class ForgetBody {
    private String phone;
    private String code;
    private String password;

    public ForgetBody(String phone, String code, String password) {
        this.phone = phone;
        this.code = code;
        this.password = password;
    }

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
}
