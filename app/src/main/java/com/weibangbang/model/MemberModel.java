package com.weibangbang.model;

import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 9:08
 * 功能描述：
 */
public class MemberModel extends BaseModel{
    /**
     * 日排行榜
     */
    public void postDailyRankings(BaseView baseView){
        mCall = mApiService.postDailyRankings();
        request(baseView);
    }

    /**
     * 总排行榜
     */
    public void postUniversalLeaderboard(BaseView baseView){
        mCall = mApiService.postUniversalLeaderboard();
        request(baseView);
    }
}
