package com.weibangbang.presenter;

import com.weibangbang.base.BaseView;
import com.weibangbang.model.HomeModel;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:21
 * 功能描述：
 */
public class HomePresenter extends BasePresenter {

    private HomeModel mModel;

    public HomePresenter(BaseView baseView) {
        super(baseView);
        mModel = new HomeModel();
    }

    /**
     * 首页轮播图接口
     *
     */
    public void postBanner() {
        mModel.postBanners(mBaseView);
    }

    /**
     * 首页公告列表接口
     */
    public void postNotice() {
        mModel.postNotice(mBaseView);
    }

    /**
     * 首页公告详情接口
     */
    public void postNoticeDetails(String notice_id) {
        mModel.postNoticeDetails(notice_id, mBaseView);
    }

    /**
     * 我要赚佣接口
     */
    public void postMakeMoney(String token) {
        mModel.postMakeMoney(token, mBaseView);
    }

    /**
     *免费领取提交接口
     */
    public void postReceiveCommit(String token,String name,String phone,String address) {
        mModel.postReceiveCommit(token,name,phone,address,mBaseView);
    }

    /**
     * 开通会员
     */
    public void postVipList(String token) {
        mModel.postVipList(token, mBaseView);
    }


    /**
     * 联系客服接口
     */
    public void postContactCustomerService(String token) {
        mModel.postContactCustomerService(token,mBaseView);
    }

    /**
     * 投放广告接口
     */
    public void postLaunchCommit(String token, String user_launch_content, String user_launch_compellation, String user_launch_phone) {
        mModel.postLaunchCommit(token, user_launch_content, user_launch_compellation, user_launch_phone, mBaseView);
    }
}
