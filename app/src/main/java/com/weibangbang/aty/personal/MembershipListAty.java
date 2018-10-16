package com.weibangbang.aty.personal;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.adapter.RankingAndMemberAdapter;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.personal.MemberShipBean;
import com.weibangbang.presenter.PersonalPresenter;

import java.util.List;

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
    private PersonalPresenter mPersonalPresenter;

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
        mPersonalPresenter = new PersonalPresenter(this);
        if ("一".equals(mLevel)){
            mPersonalPresenter.postTeam11J(Config.getToken());
        }else if ("二".equals(mLevel)){
            mPersonalPresenter.postTeam22J(Config.getToken());
        }
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        MemberShipBean memberShipBean = JSON.parseObject(jsonStr, MemberShipBean.class);
        List<MemberShipBean.DataBean> data = memberShipBean.getData();
        if (requestUrl.endsWith("User/team11J.html")){
            mAdapter.setMemberShipData(data,2);
        }
        if (requestUrl.endsWith("User/team22J.html")){
            mAdapter.setMemberShipData(data,2);
        }
    }
}
