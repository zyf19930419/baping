package com.weibangbang.alipay;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;
import com.weibangbang.common.ActivityStack;

import java.util.Map;

/**
 * 描述：支付宝支付(此类适用于支付签名在服务器段完成的情况)
 */
public class AliPay implements Runnable {

    private Thread thread;
    private String orderInfo;
    private AliPayCallBack aliPayCallBack;

    public static final int SDK_PAY_FLAG = 1;
    public static final int SDK_AUTH_FLAG = 2;
    private int sdk_type;

    /**
     * 够造函数
     *
     * @param orderInfo 这个参数是有服务器获取到的订单信息
     */
    public AliPay(String orderInfo, int sdk_type,AliPayCallBack aliPayCallBack) {
        this.orderInfo = orderInfo;
        this.aliPayCallBack = aliPayCallBack;
        this.sdk_type=sdk_type;
        thread = new Thread(this);
    }

    /**
     * 吊起支付宝
     */
    public void pay() {
        thread.start();
    }

    @Override
    public void run() {
        PayTask alipay = new PayTask(ActivityStack.getInstance().topActivity());
        Map<String, String> result = alipay.payV2(orderInfo, true);
        Message msg = new Message();
        msg.what = sdk_type;
        msg.obj = result;
        mHandler.sendMessage(msg);
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        aliPayCallBack.onComplete(resultInfo);
                    } else {
                        // 支付失败
                        aliPayCallBack.onFailure();
                    }
                    break;
                }
                default:
                    break;
            }

    }
    };

}
