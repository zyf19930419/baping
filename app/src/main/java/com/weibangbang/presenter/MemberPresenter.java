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
    public void postlobby(String vip){
        mModel.postlobby(vip,mBaseView);
    }

    /**
     * 任务大厅点击查看的任务详情
     */
    public void posTaskInfo(String token,String id){
        mModel.posTaskInfo(token,id,mBaseView);
    }

    /**
     * 领取任务接口
     */
    public void posTaskGet(String token,String id){
        mModel.posTaskGet(token,id,mBaseView);
    }
    /**
     * 任务规则
     */
    public void postTaskRules(){
        mModel.postTaskRules(mBaseView);
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

    /**
     * 上传截图接口
     */
    public void postTaskPrintscreen(String token,String id,String printscreen){
        mModel.postTaskPrintscreen(token,id,printscreen,mBaseView);
    }


}
