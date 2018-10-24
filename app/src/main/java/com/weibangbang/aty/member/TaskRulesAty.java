package com.weibangbang.aty.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.member.TaskRulesBean;
import com.weibangbang.presenter.MemberPresenter;
import com.weibangbang.utils.GlideApp;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:17
 * 功能描述：任务规则
 */
public class TaskRulesAty extends BaseActivity {

    private ImageView show_img, rules_img;
    private TextView rules_tv;

    private MemberPresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_task_rules;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.renwuguize), true);
        show_img = findViewById(R.id.show_img);
        rules_img = findViewById(R.id.rules_img);
        rules_tv = findViewById(R.id.rules_tv);
    }

    @Override
    public void initData() {
        mPresenter = new MemberPresenter(this);
        mPresenter.postTaskRules();
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Work/task_rules.html")) {
            TaskRulesBean taskRulesBean = JSON.parseObject(jsonStr, TaskRulesBean.class);
            TaskRulesBean.DataBean data = taskRulesBean.getData();
            if (!TextUtils.isEmpty(data.getRule_explain())) {
                show_img.setVisibility(View.GONE);
                rules_tv.setVisibility(View.VISIBLE);
                rules_tv.setText(data.getRule_explain());
            }

            GlideApp.with(mContext)
                    .load(ApiService.BASE_IMAGE + data.getRule_picture())
                    .into(rules_img);
        }
    }

    @Override
    public void onFailure(String msg) {
        super.onFailure(msg);
    }
}
