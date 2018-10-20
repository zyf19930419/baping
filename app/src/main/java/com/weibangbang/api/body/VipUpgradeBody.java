package com.weibangbang.api.body;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/20 0020
 * 联系方式：32457127@qq.com
 */
public class VipUpgradeBody {

    private String token;
    private String upgrade;
    private String pay_way;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(String upgrade) {
        this.upgrade = upgrade;
    }

    public String getPay_way() {
        return pay_way;
    }

    public void setPay_way(String pay_way) {
        this.pay_way = pay_way;
    }
}
