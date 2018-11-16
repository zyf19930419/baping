package com.weibangbang.presenter;

import com.weibangbang.base.BaseView;
import com.weibangbang.model.PersonalModel;

import java.io.File;
import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 9:08
 * 功能描述：
 */
public class PersonalPresenter extends BasePresenter{
    private PersonalModel mModel;
    public PersonalPresenter(BaseView baseView) {
        super(baseView);
        mModel=new PersonalModel();
    }

    /**
     * 个人中心-总收入，今日收入，已提现接口(新2)
     */
    public void postPersonalPage(String token){
        mModel.postPersonalPage(token,mBaseView);
    }

    /**
     *个人信息修改显示页接口
     */
    public void postInformationDisplay(String token){
        mModel.postInformationDisplay(token,mBaseView);
    }
    /**
     *个人信息修改页接口
     */
    public void postInformation(String token,String name,String sex,String age,String address,String portrait){
        mModel.postInformation(token,name,sex,age,address,portrait,mBaseView);
    }

    /**
     * 我的团队-我的一级会员接口
     */
    public void postTeam11J(String token,int p){
        mModel.postTeam11J(token,p,mBaseView);
    }


    /**
     * 我的团队-我的二级会员接口
     */
    public void postTeam22J(String token,int p){
        mModel.postTeam22J(token,p,mBaseView);
    }

    /**
     *我的钱包
     */
    public void postMyWallet(String token,int p){
        mModel.postMyWallet(token,p,mBaseView);
    }

    /**
     *可提现金额
     */
    public void postUserBalance(String token){
        mModel.postUserBalance(token,mBaseView);
    }
    /**
     * 提现
     */
    public void postWithDrawal(String token,String money, String way, String account){
        mModel.postWithDrawal(token,money,way,account,mBaseView);
    }

    /**
     * 修改密码接口
     */
    public void postChangePassword(String token,String old_pass,String new_pass){
        mModel.postChangePassword(token,old_pass,new_pass,mBaseView);
    }

    /**
     * 退出登录接口
     * @param token
     */
    public void postLoginOut(String token){
        mModel.postLoginOut(token,mBaseView);
    }

    /**
     * 图片上传
     */
    public void postUpLoad(List<File> fileList){
        mModel.postUpLoad(fileList,mBaseView);
    }

    /**
     *支付宝授权签名接口
     */
    public void postAliShare(String token){
        mModel.postAliShare(token,mBaseView);
    }
}
