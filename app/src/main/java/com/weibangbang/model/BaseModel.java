package com.weibangbang.model;

import android.widget.Toast;

import com.weibangbang.api.ApiService;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseView;
import com.weibangbang.common.ActivityStack;
import com.weibangbang.utils.LogUtils;
import com.weibangbang.utils.RetrofitUtils;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 9:11
 * 功能描述：
 */
public abstract  class BaseModel {

    public Call<ResponseBody> mCall;
    public final ApiService mApiService;

    public BaseModel() {
        RetrofitUtils retrofitUtils = RetrofitUtils.getInstance(ApiService.BASE_URL);
        Retrofit retrofit = retrofitUtils.getRetrofit();
        mApiService = retrofit.create(ApiService.class);
    }

    public void request(final BaseView baseView) {
        mCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String requestUrl = call.request().url().toString();
                if (response.isSuccessful()) {
                    try {
                        String jsonStr = response.body().string();
                        LogUtils.e(response.toString()+"========"+jsonStr);
                        JSONObject jsonObject=new JSONObject(jsonStr);
                        int code = jsonObject.optInt("code");
                        if (1==code){
                            baseView.onComplete(requestUrl, jsonStr);
                        }else {
                            String msg = jsonObject.optString("msg");
                            if (msg.contains("token")){
                                Config.setToken("");
                            }else {
                                Toast.makeText(ActivityStack.getInstance().topActivity(), msg, Toast.LENGTH_SHORT).show();
                                baseView.onFailure(msg);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(ActivityStack.getInstance().topActivity(), "数据解析失败", Toast.LENGTH_SHORT).show();
                    baseView.onFailure("数据解析失败");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(ActivityStack.getInstance().topActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                baseView.onFailure(t.getMessage());
            }
        });
    }
}
