package com.weibangbang.aty.home;

import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:56
 * 功能描述：投放广告
 */
public class PutInAty extends BaseActivity{
    private TextView commit_tv;
    @Override
    public int getLayoutId() {
        return R.layout.acvity_put_in;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.toufangguanggao),true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.tijiao);
    }

    @Override
    public void initData() {

    }
}
