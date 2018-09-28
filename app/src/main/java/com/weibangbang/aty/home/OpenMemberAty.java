package com.weibangbang.aty.home;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:54
 * 功能描述：开通会员
 */
public class OpenMemberAty extends BaseActivity{
    @Override
    public int getLayoutId() {
        return R.layout.open_member;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.kaitonghuiyuan),true);
    }

    @Override
    public void initData() {

    }
}
