package com.weibangbang.presenter;

import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 9:13
 * 功能描述：
 */
public abstract class BasePresenter {
    public BaseView mBaseView;

    public BasePresenter(BaseView baseView) {
        mBaseView = baseView;
    }
}
