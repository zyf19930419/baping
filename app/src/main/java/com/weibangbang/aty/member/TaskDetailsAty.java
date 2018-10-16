package com.weibangbang.aty.member;

import android.view.View;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.utils.ToastUtils;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 14:00
 * 功能描述：
 */
public class TaskDetailsAty extends BaseActivity {
    private TextView button_tv;
    private TextView commit_tv;

    private TextView title_tv; // 任务标题
    private TextView status_tv; // 任务简介
    private TextView taskDetails_wenAn_tv; // 文案

    @Override
    public int getLayoutId() {
        return R.layout.activity_task_details;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.task_details), true);
        commit_tv = findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenlingqu);
        button_tv = findViewById(R.id.button_tv);
        button_tv.setVisibility(View.GONE);

        title_tv = findViewById(R.id.title_tv);
        status_tv = findViewById(R.id.status_tv);
        taskDetails_wenAn_tv = findViewById(R.id.taskDetails_wenAn_tv);

    }

    @Override
    public void initData() {
    }

    /**
     * 复制按钮点击事件
     *
     * @param view
     */
    public void onCopy(View view) {
        copyText(taskDetails_wenAn_tv.getText().toString());
    }

    /**
     * 确认领取按钮点击事件
     *
     * @param view
     */
    public void onCommit(View view) {
        ToastUtils.showToast("确认领取任务");
    }

}
