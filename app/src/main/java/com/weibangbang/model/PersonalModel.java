package com.weibangbang.model;

import com.weibangbang.api.body.TokenBody;
import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 9:08
 * 功能描述：
 */
public class PersonalModel extends BaseModel{
    /**
     * 个人中心-总收入，今日收入，已提现接口(新2)
     */
    public void postPersonalPage(String token,BaseView baseView) {
        TokenBody tokenBody=new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postPersonalPage(tokenBody);
        request(baseView);
    }

    /**
     *我的团队-我的一级会员接口
     */
    public void postTeam11J(String token,BaseView baseView) {
        TokenBody tokenBody=new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postTeam11J(tokenBody);
        request(baseView);
    }

    /**
     *我的团队-我的二级会员接口
     */
    public void postTeam22J(String token,BaseView baseView) {
        TokenBody tokenBody=new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postTeam22J(tokenBody);
        request(baseView);
    }


    /**
     * 退出登录接口
     */
    public void postLoginOut(String token, BaseView baseView) {
        TokenBody tokenBody = new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postLoginOut(tokenBody);
        request(baseView);
    }
}
