package com.weibangbang.aty.home;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/10 15:29
 * 功能描述：公告详情
 */
public class NoticeDetailsAty extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_notice_details;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.notice_details),true);
    }

    @Override
    public void initData() {

    }
}
