package com.weibangbang.presenter;

import com.weibangbang.base.BaseView;
import com.weibangbang.model.HomeModel;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:21
 * 功能描述：
 */
public class HomePresenter extends BasePresenter{

    private HomeModel mModel;
    public HomePresenter(BaseView baseView) {
        super(baseView);
        mModel=new HomeModel();
    }

    /**
     * 首页轮播图接口
     * @param banner_id
     */
    public void postBanner(String banner_id){
        mModel.postBanners(banner_id,mBaseView);
    }

    /**
     * 首页公告列表接口
     */
    public void postNotice(){
        mModel.postNotice(mBaseView);
    }

    /**
     * 首页公告详情接口
     */
    public void postNoticeDetails(String notice_id){
        mModel.postNoticeDetails(notice_id,mBaseView);
    }



}
