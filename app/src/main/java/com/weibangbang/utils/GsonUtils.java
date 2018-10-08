package com.weibangbang.utils;


import com.google.gson.Gson;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 13:52
 * 功能描述：gson工具类
 */
public class GsonUtils {
    //线程安全的
    private static final Gson GSON=new Gson();

    //获取gson解析器
    public static Gson getGson(){
        return GSON;
    }
    public static  <T> T gsonToBean(String jsonString,Class<T> tClass){
        T t=GSON.fromJson(jsonString,tClass);
        return  t;
    }

}
