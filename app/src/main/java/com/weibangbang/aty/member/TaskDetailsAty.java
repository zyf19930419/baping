package com.weibangbang.aty.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.member.TaskDetailsBean;
import com.weibangbang.presenter.MemberPresenter;
import com.weibangbang.utils.ToastUtils;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 14:00
 * 功能描述：
 */
public class TaskDetailsAty extends BaseActivity{
    private TextView button_tv;
    private TextView commit_tv;
    private int mTask_id;
    private MemberPresenter mMemberPresenter;

    private TextView title_tv,status_tv,copy_tv;

    private ImageView task_img;

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
        mTask_id = getIntent().getExtras().getInt("task_id");

        title_tv=findViewById(R.id.title_tv);
        status_tv=findViewById(R.id.status_tv);
        copy_tv=findViewById(R.id.copy_tv);
        task_img=findViewById(R.id.task_img);
    }

    @Override
    public void initData() {
        mMemberPresenter = new MemberPresenter(this);
        mMemberPresenter.posTaskInfo(Config.getToken(), String.valueOf(mTask_id));
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Work/task_info.html")){
            TaskDetailsBean taskDetailsBean = JSON.parseObject(jsonStr, TaskDetailsBean.class);
            title_tv.setText(taskDetailsBean.getData().get(0).getTask_name());
            status_tv.setText(taskDetailsBean.getData().get(0).getTask_content());
        }
    }

    /**
     * 复制按钮点击事件
     *
     * @param view
     */
    public void onCopy(View view) {
        copyText(copy_tv.getText().toString());
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
