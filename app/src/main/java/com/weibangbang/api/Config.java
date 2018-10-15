package com.weibangbang.api;

import android.text.TextUtils;

import com.weibangbang.common.ActivityStack;
import com.weibangbang.utils.SharedPreferencesUtils;

/**
 * 创建者：zhangyunfei
 * 时间：2018/10/14 0014
 * 联系方式：32457127@qq.com
 */
public class Config {
    public static  boolean isLogin(){
        boolean isLogin= SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).getBoolean(Constant.ISLOGIN,false);
        return isLogin;
    }

    public static String getToken(){
        String token=SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).getString(Constant.TOKEN,"");
        return token;
    }
    public static void setToken(String token){
        if (TextUtils.isEmpty(token)){
            SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).putBoolean(Constant.ISLOGIN,false);
        }else {
            SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).putBoolean(Constant.ISLOGIN,true);
        }
        SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).putString(Constant.TOKEN,token);
    }
}
