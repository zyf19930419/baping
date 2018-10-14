package com.weibangbang.api;

import com.weibangbang.api.body.LoginBody;

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
    Call<ResponseBody> postDailyRankings();

    @POST("Work/ranking_list.html")
    Call<ResponseBody> postUniversalLeaderboard();

    @FormUrlEncoded
    @POST("Index/notice_details.html")
    Call<ResponseBody> postNoticeDetails(@Field("notice_id") String notice_id);

    @FormUrlEncoded
    @POST("Work/lobby.html")
    Call<ResponseBody> postMakeMoney(@Field("token") String token);

    @POST("Service/service_list.html")
    Call<ResponseBody> postContactCustomerService();

    @POST("Work/task_rules.html")
    Call<ResponseBody> postTaskRules();


    @FormUrlEncoded
    @POST("Account/send_message.html")
    Call<ResponseBody> postSendmessage(@Field("phone") String phone,@Field("type") String type);


    @FormUrlEncoded
    @POST("Account/register.html")
    Call<ResponseBody> postRegister(@Field("phone") String phone,@Field("code") String code,@Field("password") String password,@Field("nvitation") String nvitation);


    @FormUrlEncoded
    @POST("Account/forget.html")
    Call<ResponseBody> postForget(@Field("phone") String phone,@Field("code") String code,@Field("password") String password);

    @POST("Account/login.html")
    Call<ResponseBody> postLogin(@Body LoginBody loginBody);
}
