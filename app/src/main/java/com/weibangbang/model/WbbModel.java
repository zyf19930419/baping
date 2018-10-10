package com.weibangbang.model;

import com.weibangbang.api.ApiService;
import com.weibangbang.base.BaseView;
import com.weibangbang.utils.LogUtils;
import com.weibangbang.utils.RetrofitUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:08
 * 功能描述：
 */
public class WbbModel {

    private Call<ResponseBody> mCall;
    private final ApiService mApiService;

    public WbbModel() {
        RetrofitUtils retrofitUtils = RetrofitUtils.getInstance(ApiService.BASE_URL);
        Retrofit retrofit = retrofitUtils.getRetrofit();
        mApiService = retrofit.create(ApiService.class);
    }

    /**
     * 首页轮播图接口
     * @param banner_id
     */
    public void postBanners(String banner_id, BaseView baseView) {
        mCall = mApiService.postBanners(banner_id);
        request(baseView);
    }

    /**
     * 首页公告列表接口
     */
    public void postNotice(BaseView baseView){
        mCall = mApiService.postNotice();
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

    private void request(final BaseView baseView) {
        mCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String requestUrl = call.request().url().toString();
                LogUtils.e(response.toString());
                if (response.isSuccessful()) {
                    try {
                        String jsonStr = response.body().string();
                        baseView.onComplete(requestUrl, jsonStr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    baseView.onFailure("数据解析失败");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                baseView.onFailure(t.getMessage());
            }
        });
    }
}
