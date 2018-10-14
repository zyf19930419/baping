package com.weibangbang.api;

import android.content.Context;

import com.weibangbang.utils.SharedPreferencesUtils;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/14 0014
 * 联系方式：32457127@qq.com
 */
public class Config {
    public static  boolean isLogin(Context context){
        boolean isLogin= SharedPreferencesUtils.getInstance(context).getBoolean("isLogin",false);
        return isLogin;
    }

    public static String getToken(Context context){
        String token=SharedPreferencesUtils.getInstance(context).getString("token","");
        return token;
    }
}
