package com.weibangbang.aty.member;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.adapter.RankingAndMemberAdapter;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.member.DailyRankingsBean;
import com.weibangbang.presenter.MemberPresenter;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:18
 * 功能描述：排行榜
 */
public class RankingListAty extends BaseActivity{
    private TextView general_tv,advance_tv;
    private RecyclerView mRecyclerView;
    private RankingAndMemberAdapter mAdapter;

    private MemberPresenter mPresenter;
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

        mRecyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    @Override
    public void initData() {
        mPresenter =new MemberPresenter(this);
        mPresenter.postDailyRankings();
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("ranking_day.html")){
            DailyRankingsBean dailyRankingsBean = JSON.parseObject(jsonStr, DailyRankingsBean.class);
            List<DailyRankingsBean.DataBean> data = dailyRankingsBean.getData();
            if (data!=null && data.size()>0){
                mAdapter=new RankingAndMemberAdapter();
                mRecyclerView.setAdapter(mAdapter);
            }
        }
        if (requestUrl.endsWith("ranking_list.html")){

        }
    }

    /**
     * 日排行榜
     */
    public void onGeneral_layout(View view) {
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        mPresenter.postDailyRankings();
    }
    /**
     *总排行榜
     */
    public void onAdvance_layout(View view) {
        general_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        advance_tv.setCompoundDrawablePadding(10);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
        mPresenter.postUniversalLeaderboard();
    }
}
