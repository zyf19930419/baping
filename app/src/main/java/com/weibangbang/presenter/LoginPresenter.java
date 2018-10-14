package com.weibangbang.presenter;

import com.weibangbang.base.BaseView;
import com.weibangbang.model.LoginModel;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/14 0014
 * 联系方式：32457127@qq.com
 */
public class LoginPresenter extends BasePresenter {
    private LoginModel mModel;
    public LoginPresenter(BaseView baseView) {
        super(baseView);
        mModel=new LoginModel();
    }

    /**
     * 发送短信验证码接口
     */
    public void postSendmessage(String phone,String type){
        mModel.postSendmessage(phone,type,mBaseView);
    }

    /**
     * 注册接口
     */
    public void postRegister(String phone,String code,String password,String nvitation){
        mModel.postRegister(phone,code,password,nvitation,mBaseView);
    }

    /**
     * 忘记密码接口
     */
    public void postForget(String phone,String code,String password){
        mModel.postForget(phone,code,password,mBaseView);
    }

    /**
     * 登录接口
     */
    public void postLogin(String phone,String password){
        mModel.postLogin(phone,password,mBaseView);
    }
}
