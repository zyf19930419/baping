package com.weibangbang.alipay;

/**
 * 描述：支付宝回调接口
 */
public interface AliPayCallBack {
    /**
     * 当支付成功时的回调函数
     */
    void onComplete();

    /**
     * 当支付失败时的回调函数（包括用户主动取消支付，或者系统返回的错误
     */
    void onFailure();

}
