package com.weibangbang.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/16 13:54
 * 功能描述：日期工具类
 */
public class DateUtils {
    public static String getDate(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy/MM/dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }


    public static String getTime(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("HH:MM");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }
}
