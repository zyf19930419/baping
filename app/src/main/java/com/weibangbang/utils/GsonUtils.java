package com.weibangbang.utils;


import com.google.gson.Gson;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 13:52
 * 功能描述：gson工具类
 */
public class GsonUtils {
    private static Gson mGson=new Gson();
    public static  <T> T gsonToBean(String jsonString,Class<T> tClass){
        T t=mGson.fromJson(jsonString,tClass);
        return  t;
    }
}
