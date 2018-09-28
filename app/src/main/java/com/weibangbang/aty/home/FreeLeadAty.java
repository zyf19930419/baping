package com.weibangbang.aty.home;

import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.view.EditLayout;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:53
 * 功能描述：免费领佣
 */
public class FreeLeadAty extends BaseActivity{

    private TextView commit_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_free_lead;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.mianfeilingyong),true);

        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenlingqu);
    }

    @Override
    public void initData() {

    }
}
