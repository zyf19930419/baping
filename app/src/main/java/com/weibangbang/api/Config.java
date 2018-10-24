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

    public static void setVipId(int vipId){
        SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).putInt(Constant.VIPID,vipId);
    }

    public static int getVipId(){
        int vipId=SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).getInt(Constant.VIPID,0);
        return vipId;
    }

    /**
     * 分享页面的邀请码
     * @param user_inviter
     */
    public static void setUserInviter(String user_inviter){
        SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).putString(Constant.USER_INVITER,user_inviter);
    }

    /**
     * 分享页面的二维码图片
     * @param user_inviter_qrcode
     */
    public static void setUserInviterQrcode(String user_inviter_qrcode){
        SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).putString(Constant.USER_INVITER_QRCODE,user_inviter_qrcode);
    }

    public static String getUserInviter(){
        String user_inviter=SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).getString(Constant.USER_INVITER,"");
        return user_inviter;
    }

    public static String getUserInviterQrcode(){
        String user_inviter_qrcode=SharedPreferencesUtils.getInstance(ActivityStack.getInstance().topActivity()).getString(Constant.USER_INVITER_QRCODE,"");
        return user_inviter_qrcode;
    }
}
