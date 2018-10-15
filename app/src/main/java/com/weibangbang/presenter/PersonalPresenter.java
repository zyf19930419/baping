package com.weibangbang.presenter;

import com.weibangbang.base.BaseView;
import com.weibangbang.model.PersonalModel;

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
}
