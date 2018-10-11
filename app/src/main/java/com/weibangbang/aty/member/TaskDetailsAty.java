package com.weibangbang.aty.member;

import android.view.View;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 14:00
 * 功能描述：
 */
public class TaskDetailsAty extends BaseActivity{
    private TextView button_tv;
    private TextView commit_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_task_details;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.task_details),true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenlingqu);
        button_tv=findViewById(R.id.button_tv);
        button_tv.setVisibility(View.GONE);
    }

    @Override
    public void initData() {

    }
}
