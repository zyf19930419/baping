package com.weibangbang.aty.personal;

import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:34
 * 功能描述：个人资料
 */
public class PersonaInfoAty extends BaseActivity {
    private TextView commit_tv;
    @Override
    public int getLayoutId() {
        return R.layout.personal_info;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.personal_info,true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenxiugai);
    }

    @Override
    public void initData() {

    }
}
