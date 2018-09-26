package com.bapingtianxia.baping.broadcast;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/26 16:00
 * 功能描述：
 */
public interface WxPayCallBack {
    void onComplete();

    void onFailure();
}
