package com.weibangbang.aty.personal;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:38
 * 功能描述：我的团队
 */
public class MineTeamAty extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_team;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.mine_team,true);
    }

    @Override
    public void initData() {

    }
}
