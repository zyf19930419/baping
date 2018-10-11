package com.weibangbang.presenter;

import com.weibangbang.base.BaseView;
import com.weibangbang.model.MemberModel;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 9:08
 * 功能描述：
 */
public class MemberPresenter extends BasePresenter{

    private MemberModel mModel;
    public MemberPresenter(BaseView baseView) {
        super(baseView);
        mModel=new MemberModel();
    }
    /**
     * 日排行榜
     */
    public void postDailyRankings(){
        mModel.postDailyRankings(mBaseView);
    }

    /**
     * 总排行榜
     */
    public void postUniversalLeaderboard(){
        mModel.postUniversalLeaderboard(mBaseView);
    }
}