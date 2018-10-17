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
    public void postInformation(String token,String name,String sex,String age,String address){
        mModel.postInformation(token,name,sex,age,address,mBaseView);
    }

    /**
     * 我的团队-我的一级会员接口
     */
    public void postTeam11J(String token){
        mModel.postTeam11J(token,mBaseView);
    }


    /**
     * 我的团队-我的二级会员接口
     */
    public void postTeam22J(String token){
        mModel.postTeam22J(token,mBaseView);
    }

    /**
     *我的钱包
     */
    public void postMyWallet(String token){
        mModel.postMyWallet(token,mBaseView);
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
    public void postUpLoad(String token,List<File> fileList){
        mModel.postUpLoad(token,fileList,mBaseView);
    }
}
