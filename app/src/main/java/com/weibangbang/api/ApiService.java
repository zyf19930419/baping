package com.weibangbang.api;

import com.weibangbang.api.body.ForgetBody;
import com.weibangbang.api.body.LoginBody;
import com.weibangbang.api.body.RegisterBody;
import com.weibangbang.api.body.SendmessageBody;
import com.weibangbang.api.body.TokenBody;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 14:35
 * 功能描述：
 */
public interface ApiService {
    String OFFICIAL_WEB = "http://weibangbang.dazhu-ltd.cn/";

    String BASE_URL=OFFICIAL_WEB+"index.php/index/";

    @FormUrlEncoded
    @POST("index/banner.html")
    Call<ResponseBody> postBanners(@Field("banner_id") String banner_id );

    @POST("index/notice.html")
    Call<ResponseBody> postNotice();


    @POST("Work/ranking_day.html")
    Call<ResponseBody> postDailyRankings(@Body TokenBody tokenBody);

    @POST("Work/ranking_list.html")
    Call<ResponseBody> postUniversalLeaderboard(@Body TokenBody tokenBody);

    @POST("Index/notice_details.html")
    Call<ResponseBody> postNoticeDetails(@Field("notice_id") String notice_id);

    @POST("Work/lobby.html")
    Call<ResponseBody> postMakeMoney(@Body TokenBody tokenBody);

    @POST("Service/service_list.html")
    Call<ResponseBody> postContactCustomerService();

    @POST("Work/task_rules.html")
    Call<ResponseBody> postTaskRules();


    @POST("Account/send_message.html")
    Call<ResponseBody> postSendmessage(@Body SendmessageBody sendmessageBody);


    @POST("Account/register.html")
    Call<ResponseBody> postRegister(@Body RegisterBody registerBody);


    @POST("Account/forget.html")
    Call<ResponseBody> postForget(@Body ForgetBody forgetBody);

    @POST("Account/login.html")
    Call<ResponseBody> postLogin(@Body LoginBody loginBody);
}
