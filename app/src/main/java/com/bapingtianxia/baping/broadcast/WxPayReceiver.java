package com.bapingtianxia.baping.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tencent.mm.opensdk.modelbase.BaseResp;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/26 15:58
 * 功能描述：微信支付回调广播接收
 */
public class WxPayReceiver extends BroadcastReceiver {

    private WxPayCallBack mWxPayCallBack;

    public WxPayReceiver(WxPayCallBack wxPayCallBack) {
        mWxPayCallBack = wxPayCallBack;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int errCode = intent.getIntExtra("errCode", 1);
        if (errCode == BaseResp.ErrCode.ERR_OK) {
            if (null!=mWxPayCallBack){
                mWxPayCallBack.onComplete();
            }
        } else {
            if (null!=mWxPayCallBack){
                mWxPayCallBack.onFailure();
            }
        }
    }
}
