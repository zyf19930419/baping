package com.weibangbang.aty.personal;

import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:35
 * 功能描述：修改密码
 */
public class ChangePasswordAty extends BaseActivity {
    private TextView commit_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.change_password,true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenxiugai);
    }

    @Override
    public void initData() {

    }
}
