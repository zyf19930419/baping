package com.weibangbang.model;

import com.weibangbang.api.ApiService;
import com.weibangbang.base.BaseView;
import com.weibangbang.utils.RetrofitUtils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/8 0008
 * 联系方式：32457127@qq.com
 */
public class WbbModel {

    private final ApiService mApiService;

    public WbbModel() {
        RetrofitUtils instance = RetrofitUtils.getInstance(ApiService.BASE_URL);
        Retrofit mRetrofit = instance.getRetrofit();
        mApiService = mRetrofit.create(ApiService.class);
    }

    public void postBanner(String banner_id, final BaseView baseView){
        Call<Object> bannerBeanCall = mApiService.postBanner(banner_id);
        bannerBeanCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                String requestUrl = call.request().url().toString();
                if (response.isSuccessful()){
                    baseView.onComplete(requestUrl,response.body());
                }else {
                    baseView.onFaile(requestUrl,response.message());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                String requestUrl = call.request().url().toString();
                baseView.onFaile(requestUrl,t.toString());
            }
        });
    }
}
