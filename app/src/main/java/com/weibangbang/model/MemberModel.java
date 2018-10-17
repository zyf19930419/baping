package com.weibangbang.model;

import com.weibangbang.api.body.LobbyBody;
import com.weibangbang.api.body.TaskInfoBody;
import com.weibangbang.api.body.TokenBody;
import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 9:08
 * 功能描述：
 */
public class MemberModel extends BaseModel{

    /**
     *任务大厅接口
     * @param token
     * @param vip 1.普通任务2.高级任务 可以不传默认普通
     */
    public void postlobby(String token,String vip,BaseView baseView){
        LobbyBody lobbyBody=new LobbyBody();
        lobbyBody.setToken(token);
        lobbyBody.setVip(vip);
        mCall = mApiService.postlobby(lobbyBody);
        request(baseView);
    }

    /**
     * 任务大厅点击查看的任务详情
     * @param token
     * @param id
     */
    public void posTaskInfo(String token,String id,BaseView baseView){
        TaskInfoBody taskInfoBody=new TaskInfoBody();
        taskInfoBody.setToken(token);
        taskInfoBody.setId(id);
        mCall = mApiService.posTaskInfo(taskInfoBody);
        request(baseView);
    }

    /**
     *领取任务接口
     * @param token
     * @param id
     */
    public void posTaskGet(String token,String id,BaseView baseView){
        TaskInfoBody taskInfoBody=new TaskInfoBody();
        taskInfoBody.setToken(token);
        taskInfoBody.setId(id);
        mCall = mApiService.posTaskGet(taskInfoBody);
        request(baseView);
    }

    /**
     * 任务规则
     */
    public void postTaskRules(String token,BaseView baseView) {
        TokenBody tokenBody=new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postTaskRules(tokenBody);
        request(baseView);
    }

    /**
     * 日排行榜
     */
    public void postDailyRankings(String token,BaseView baseView){
        TokenBody tokenBody=new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postDailyRankings(tokenBody);
        request(baseView);
    }

    /**
     * 总排行榜
     */
    public void postUniversalLeaderboard(String token,BaseView baseView){
        TokenBody tokenBody=new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postUniversalLeaderboard(tokenBody);
        request(baseView);
    }

    /**
     *我的任务-已领用接口
     */
    public void postReceivie(String token,BaseView baseView){
        TokenBody tokenBody=new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postReceivie(tokenBody);
        request(baseView);
    }

    /**
     * 我的任务已完成接口
     */
    public void postTaskAccomplish(String token,BaseView baseView){
        TokenBody tokenBody=new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postTaskAccomplish(tokenBody);
        request(baseView);
    }


}
