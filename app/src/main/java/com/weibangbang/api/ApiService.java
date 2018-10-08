package com.weibangbang.api;


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
    //http://weibangbang.dazhu-ltd.cn/index.php/index/index/banner.html
    String BASE_URL = "http://weibangbang.dazhu-ltd.cn/index.php/index/index/";

    @POST("banner.html")
    @FormUrlEncoded
   Call<Object> postBanner(@Field("banner_id") String banner_id);
}
