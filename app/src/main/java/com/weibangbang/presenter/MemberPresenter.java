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
     *任务大厅接口
     */
    public void postlobby(String token,String vip){
        mModel.postlobby(token,vip,mBaseView);
    }

    /**
     * 任务大厅点击查看的任务详情
     */
    public void posTaskInfo(String token,String id){
        mModel.posTaskInfo(token,id,mBaseView);
    }
    /**
     * 任务规则
     */
    public void postTaskRules(String token){
        mModel.postTaskRules(token,mBaseView);
    }

    /**
     * 日排行榜
     */
    public void postDailyRankings(String token){
        mModel.postDailyRankings(token,mBaseView);
    }

    /**
     * 总排行榜
     */
    public void postUniversalLeaderboard(String token){
        mModel.postUniversalLeaderboard(token,mBaseView);
    }

    /**
     *我的任务-已领用接口
     */
    public void postReceivie(String token){
        mModel.postReceivie(token,mBaseView);
    }

    /**
     * 我的任务已完成接口
     */
    public void postTaskAccomplish(String token){
        mModel.postTaskAccomplish(token,mBaseView);
    }


}
