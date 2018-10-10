package com.weibangbang.aty.personal;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.adapter.RankingAndMemberAdapter;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/10 8:45
 * 功能描述：会员列表
 */
public class MembershipListAty extends BaseActivity{
    private TextView tip_tv;
    private RecyclerView mRecyclerView;
    private RankingAndMemberAdapter mAdapter;
    private String mLevel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_membership_list;
    }

    @Override
    public void initView() {
        mLevel = getIntent().getExtras().getString("level");



        setTitleBar(getResources().getString(R.string.huiyuanliebiao),true);

        tip_tv=findViewById(R.id.tip_tv);
        if ("一".equals(mLevel)){
          tip_tv.setText(R.string.membership_tips1);
        }else if ("二".equals(mLevel)){
            tip_tv.setText(R.string.membership_tips2);
        }

        mRecyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter=new RankingAndMemberAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initData() {

    }
}
