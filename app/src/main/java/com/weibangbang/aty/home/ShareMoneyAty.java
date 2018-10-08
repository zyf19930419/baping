package com.weibangbang.aty.home;

import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:57
 * 功能描述：分享赚钱
 */
public class ShareMoneyAty extends BaseActivity{
    private TextView commit_tv;
    @Override
    public int getLayoutId() {
        return R.layout.acvity_share_money;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.fenxiangzhuanqian),true);
        commit_tv=findViewById(R.id.commit_tv);
//        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(DisplayHelper.dp2px(this,100), ViewGroup.LayoutParams.WRAP_CONTENT);
//        params.setMargins(0,DisplayHelper.dp2px(this,20),0,0);
//        params.gravity= Gravity.CENTER_HORIZONTAL;
//        commit_tv.setLayoutParams(params);
        commit_tv.setText(R.string.share_money_button);
    }

    @Override
    public void initData() {

    }
}
