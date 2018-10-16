package com.weibangbang.aty.member;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.adapter.TaskHallAdapter;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.member.MyTaskBean;
import com.weibangbang.presenter.MemberPresenter;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:19
 * 功能描述：我的任务
 */
public class MyTaskAty extends BaseActivity{
    private TextView general_tv,advance_tv;

    private RecyclerView mRecyclerView;
    private TaskHallAdapter mTaskHallAdapter;
    private MemberPresenter mMemberPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mytask;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.woderenwu),true);
        general_tv=findViewById(R.id.general_task_tv);
        advance_tv=findViewById(R.id.advance_task_tv);
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);

        mRecyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);

    }

    @Override
    public void initData() {
        mMemberPresenter = new MemberPresenter(this);
        mMemberPresenter.postReceivie(Config.getToken());
    }

    /**
     * 已领用
     */
    public void onGeneral_layout(View view) {
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        mMemberPresenter.postReceivie(Config.getToken());
    }
    /**
     *已完成
     */
    public void onAdvance_layout(View view) {
        general_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        advance_tv.setCompoundDrawablePadding(10);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
        mMemberPresenter.postTaskAccomplish(Config.getToken());
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        MyTaskBean myTaskBean = JSON.parseObject(jsonStr, MyTaskBean.class);
        List<MyTaskBean.DataBean> data = myTaskBean.getData();
        if (null!=data){
            if (requestUrl.endsWith("Work/receive.html")){
                mTaskHallAdapter=new TaskHallAdapter(getResources().getString(R.string.woderenwu),data,0);
                mRecyclerView.setAdapter(mTaskHallAdapter);
            }

            if (requestUrl.endsWith("Work/task_accomplish.html")){
                mTaskHallAdapter=new TaskHallAdapter(getResources().getString(R.string.woderenwu),data,1);
                mRecyclerView.setAdapter(mTaskHallAdapter);
            }
        }

    }
}
