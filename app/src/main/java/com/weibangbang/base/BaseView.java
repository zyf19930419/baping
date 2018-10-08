package com.weibangbang.base;


/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 10:58
 * 功能描述：
 */
public interface BaseView {

    void showLoading(String title);

    void stopLoading();

    void onComplete(String requestUrl, Object object);

    void onFaile(String requestUrl,String msg);
}
