package com.weibangbang.aty.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:38
 * 功能描述：我的团队
 */
public class MineTeamAty extends BaseActivity {
    private TextView commit_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_team;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.mine_team,true);

        commit_tv = findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.inviting_friends);
    }

    @Override
    public void initData() {

    }

    /**
     * 邀请好友按钮
     */
    public void onCommit(View view) {
    }

    /**
     * 查看一级会员列表
     */
    public void onFirstMember(View view) {
        Bundle bundle=new Bundle();
        bundle.putString("level","一");
        startActivity(MembershipListAty.class,bundle);
    }

    /**
     * 查看二级会员列表
     */
    public void onSecondMember(View view) {
        Bundle bundle=new Bundle();
        bundle.putString("level","二");
        startActivity(MembershipListAty.class,bundle);
    }
}
