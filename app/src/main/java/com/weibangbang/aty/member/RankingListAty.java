package com.weibangbang.aty.member;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:18
 * 功能描述：排行榜
 */
public class RankingListAty extends BaseActivity{
    private TextView general_tv,advance_tv;
    @Override
    public int getLayoutId() {
        return R.layout.ranking_list;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.paihangbang),true);
        general_tv=findViewById(R.id.general_task_tv);
        advance_tv=findViewById(R.id.advance_task_tv);
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
    }

    @Override
    public void initData() {

    }

    /**
     * 日排行榜
     */
    public void onGeneral_layout(View view) {
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
    }
    /**
     *总排行榜
     */
    public void onAdvance_layout(View view) {
        general_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        advance_tv.setCompoundDrawablePadding(10);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
    }
}
