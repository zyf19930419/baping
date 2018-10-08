package com.weibangbang.presenter;

import android.print.PrintJobId;

import com.weibangbang.base.BaseView;
import com.weibangbang.model.WbbModel;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/8 0008
 * 联系方式：32457127@qq.com
 */
public class WbbPresenter {
    private BaseView mBaseView;
    private WbbModel mModel;
    public WbbPresenter(BaseView baseView) {
        mModel=new WbbModel();
        mBaseView=baseView;
    }

    public void postBanner(String banner_id){
        mModel.postBanner(banner_id,mBaseView);
    }
}
