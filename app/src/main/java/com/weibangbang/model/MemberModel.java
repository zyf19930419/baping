package com.weibangbang.model;

import com.weibangbang.api.body.LobbyBody;
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
     * 任务规则
     */
    public void postTaskRules(BaseView baseView) {
        mCall = mApiService.postTaskRules();
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


}
