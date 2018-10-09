package com.weibangbang.aty.member;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:17
 * 功能描述：任务规则
 */
public class TaskRulesAty extends BaseActivity{
    @Override
    public int getLayoutId() {
        return R.layout.activity_task_rules;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.renwuguize),true);
    }

    @Override
    public void initData() {

    }
}
