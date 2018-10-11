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
}
