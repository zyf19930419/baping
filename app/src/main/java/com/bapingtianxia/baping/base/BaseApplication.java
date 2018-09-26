package com.bapingtianxia.baping.base;

import android.app.Application;
import android.content.Context;

import com.bapingtianxia.baping.utils.LogUtils;
import com.mob.MobSDK;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/18 14:13
 * 功能描述：
 */
public class BaseApplication extends Application {
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
        LogUtils.isDebug=true;
        MobSDK.init(this);
    }

    public static Context getAppContext() {
        return mApplication;
    }

    public static BaseApplication getApplication() {
        return mApplication;
    }
}
