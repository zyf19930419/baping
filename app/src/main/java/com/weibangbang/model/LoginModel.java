package com.weibangbang.model;

import com.weibangbang.api.body.LoginBody;
import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/14 0014
 * 联系方式：32457127@qq.com
 */
public class LoginModel extends BaseModel {
    /**
     * 发送短信验证码接口
     * @param phone 手机号
     * @param type 1.发送注册验证码 2.发送忘记密码验证码
     */
    public void postSendmessage(String phone, String type,BaseView baseView) {
        mCall = mApiService.postSendmessage(phone,type);
        request(baseView);
    }

    /**
     *注册接口
     * @param phone 电话号码
     * @param code 短信验证码
     * @param password 	登录密码
     * @param nvitation 邀请码（非必填）
     */
    public void postRegister(String phone, String code,String password, String nvitation,BaseView baseView) {
        mCall = mApiService.postRegister(phone, code, password, nvitation);
        request(baseView);
    }

    /**
     *忘记密码接口
     * @param phone 	手机号
     * @param code 短信验证码
     * @param password 	重置的密码
     */
    public void postForget(String phone, String code,String password,BaseView baseView) {
        mCall = mApiService.postForget(phone, code, password);
        request(baseView);
    }

    /**
     *登录接口
     * @param phone
     * @param password
     */
    public void postLogin(String phone, String password,BaseView baseView) {
        LoginBody loginBody=new LoginBody();
        loginBody.setPhone(phone);
        loginBody.setPassword(password);
        mCall = mApiService.postLogin(loginBody);
        request(baseView);
    }
}
