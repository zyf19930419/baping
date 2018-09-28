package com.weibangbang.aty.home;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:57
 * 功能描述：分享赚钱
 */
public class InviteFriendsAty extends BaseActivity{
    @Override
    public int getLayoutId() {
        return R.layout.acvity_invite_friends;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.fenxiangzhuanqian),true);
    }

    @Override
    public void initData() {

    }
}
