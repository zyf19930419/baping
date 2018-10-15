package com.weibangbang.api.body;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/15 9:36
 * 功能描述：
 */
public class SendmessageBody {
    private String phone;
    private String type;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
