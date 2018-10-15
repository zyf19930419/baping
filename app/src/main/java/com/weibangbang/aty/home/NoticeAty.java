package com.weibangbang.aty.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.weibangbang.R;
import com.weibangbang.adapter.TaskHallAdapter;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/10 15:21
 * 功能描述：公告栏
 */
public class NoticeAty  extends BaseActivity{

    private RecyclerView mRecyclerView;
    private TaskHallAdapter mTaskHallAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_notice;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.notice_board),true);

        mRecyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mTaskHallAdapter=new TaskHallAdapter(getResources().getString(R.string.notice_board),null);
        mRecyclerView.setAdapter(mTaskHallAdapter);
    }

    @Override
    public void initData() {

    }
}
