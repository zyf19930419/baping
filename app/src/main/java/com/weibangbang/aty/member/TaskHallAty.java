package com.weibangbang.aty.member;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.adapter.TaskHallAdapter;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:16
 * 功能描述：任务大厅
 */
public class TaskHallAty extends BaseActivity{
    private TextView general_tv,advance_tv;

    private RecyclerView mRecyclerView;
    private TaskHallAdapter mTaskHallAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_task_hall;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.renwudating),true);
        general_tv=findViewById(R.id.general_task_tv);
        advance_tv=findViewById(R.id.advance_task_tv);
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);

        mRecyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mTaskHallAdapter=new TaskHallAdapter();
        mRecyclerView.setAdapter(mTaskHallAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        mTaskHallAdapter=new TaskHallAdapter();
        mRecyclerView.setAdapter(mTaskHallAdapter);
    }

    /**
     * 普通任务
     */
    public void onGeneral_layout(View view) {
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
    }
    /**
     *高级任务
     */
    public void onAdvance_layout(View view) {
        general_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        advance_tv.setCompoundDrawablePadding(10);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
    }
}
