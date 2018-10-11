package com.weibangbang.model;

import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:08
 * 功能描述：
 * @author Administrator
 */
public class HomeModel extends BaseModel{

    /**
     * 首页轮播图接口
     * @param banner_id
     */
    public void postBanners(String banner_id, BaseView baseView) {
        mCall = mApiService.postBanners(banner_id);
        request(baseView);
    }

    /**
     * 首页公告列表接口
     */
    public void postNotice(BaseView baseView){
        mCall = mApiService.postNotice();
        request(baseView);
    }




}
