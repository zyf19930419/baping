package com.weibangbang.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 14:35
 * 功能描述：
 */
public interface ApiService {
    String BASE_URL = "http://weibangbang.dazhu-ltd.cn/";

    @FormUrlEncoded
    @POST("index.php/index/index/banner.html")
    Call<ResponseBody> postBanners(@Field("banner_id") String banner_id );

    @POST("index.php/index/index/notice.html")
    Call<ResponseBody> postNotice();


    @POST("index.php/index/Work/ranking_day.html")
    Call<ResponseBody> postDailyRankings();

    @POST("index.php/index/Work/ranking_list.html")
    Call<ResponseBody> postUniversalLeaderboard();

}
