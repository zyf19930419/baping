package com.weibangbang.model;

import com.weibangbang.api.body.LaunchCommitBody;
import com.weibangbang.api.body.TokenBody;
import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:08
 * 功能描述：
 *
 * @author Administrator
 */
public class HomeModel extends BaseModel {

    /**
     * 首页轮播图接口
     *
     * @param banner_id 轮播图id
     */
    public void postBanners(String banner_id, BaseView baseView) {
        mCall = mApiService.postBanners(banner_id);
        request(baseView);
    }

    /**
     * 首页公告列表接口
     */
    public void postNotice(BaseView baseView) {
        mCall = mApiService.postNotice();
        request(baseView);
    }


    /**
     * 公告详情接口
     *
     * @param notice_id 任务id
     */
    public void postNoticeDetails(String notice_id, BaseView baseView) {
        mCall = mApiService.postNoticeDetails(notice_id);
        request(baseView);
    }

    /**
     * 我要赚佣接口
     *
     * @param token
     */
    public void postMakeMoney(String token, BaseView baseView) {
        TokenBody tokenBody = new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postMakeMoney(tokenBody);
        request(baseView);
    }

    /**
     * 联系客服接口
     */
    public void postContactCustomerService(BaseView baseView) {
        mCall = mApiService.postContactCustomerService();
        request(baseView);
    }

    /**
     * 投放广告接口
     */
    public void postLaunchCommit(String token, String user_launch_content, String user_launch_compellation, String user_launch_phone, BaseView baseView) {
        LaunchCommitBody launchCommitBody = new LaunchCommitBody();
        launchCommitBody.setToken(token);
        launchCommitBody.setUser_launch_content(user_launch_content);
        launchCommitBody.setUser_launch_compellation(user_launch_compellation);
        launchCommitBody.setUser_launch_phone(user_launch_phone);
        mCall = mApiService.postLaunchCommit(launchCommitBody);
        request(baseView);
    }
}
