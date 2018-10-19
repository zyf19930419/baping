package com.weibangbang.api.body;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/19 9:17
 * 功能描述：
 */
public class WithDrawalBody {
    private String money;
    private String way;
    private String account;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
