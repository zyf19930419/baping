package com.weibangbang.model;

import com.weibangbang.api.body.LobbyBody;
import com.weibangbang.api.body.MyTaskBody;
import com.weibangbang.api.body.TaskInfoBody;
import com.weibangbang.api.body.TaskPrintscreenBody;
import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 9:08
 * 功能描述：
 */
public class MemberModel extends BaseModel{

    /**
     *任务大厅接口
     * @param vip 1.普通任务2.高级任务 可以不传默认普通
     */
    public void postlobby(String vip,int p,BaseView baseView){
        LobbyBody lobbyBody=new LobbyBody();
        lobbyBody.setVip(vip);
        lobbyBody.setPage(String.valueOf(p));
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
    public void postTaskRules(BaseView baseView) {
        mCall = mApiService.postTaskRules();
        request(baseView);
    }

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

    /**
     *我的任务-已领用接口
     */
    public void postReceivie(String token,int p,BaseView baseView){
        MyTaskBody taskBody=new MyTaskBody();
        taskBody.setToken(token);
        taskBody.setPage(String.valueOf(p));
        mCall = mApiService.postReceivie(taskBody);
        request(baseView);
    }

    /**
     * 我的任务已完成接口
     */
    public void postTaskAccomplish(String token,int p,BaseView baseView){
        MyTaskBody taskBody=new MyTaskBody();
        taskBody.setToken(token);
        taskBody.setPage(String.valueOf(p));
        mCall = mApiService.postTaskAccomplish(taskBody);
        request(baseView);
    }

    /**
     *上传截图接口
     * @param token
     * @param id 任务id
     * @param printscreen
     */
    public void postTaskPrintscreen(String token,String id,String printscreen,BaseView baseView){
        TaskPrintscreenBody taskPrintscreenBody=new TaskPrintscreenBody();
        taskPrintscreenBody.setToken(token);
        taskPrintscreenBody.setId(id);
        taskPrintscreenBody.setPrintscreen(printscreen);
        mCall = mApiService.postTaskPrintscreen(taskPrintscreenBody);
        request(baseView);
    }


}
