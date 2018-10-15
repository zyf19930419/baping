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
import com.weibangbang.bean.member.LobbyBean;
import com.weibangbang.presenter.MemberPresenter;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:16
 * 功能描述：任务大厅
 */
public class TaskHallAty extends BaseActivity{
    private TextView general_tv,advance_tv;

    private RecyclerView mRecyclerView;
    private TaskHallAdapter mTaskHallAdapter;
    private MemberPresenter mMemberPresenter;
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
    }

    @Override
    public void initData() {
        mMemberPresenter=new MemberPresenter(this);
        mMemberPresenter.postlobby(Config.getToken(),"1");
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Work/lobby.html")){
            LobbyBean lobbyBean= JSON.parseObject(jsonStr,LobbyBean.class);
            List<LobbyBean.DataBean> data = lobbyBean.getData();
            if (null!=data){
                mTaskHallAdapter=new TaskHallAdapter(getResources().getString(R.string.renwudating),data);
                mRecyclerView.setAdapter(mTaskHallAdapter);
                mTaskHallAdapter.setOnButtonClickListener(new TaskHallAdapter.onButtonClickListener() {
                    @Override
                    public void onButtonClick(int position) {
                        startActivity(TaskDetailsAty.class);
                    }
                });
            }
        }
    }

    /**
     * 普通任务
     */
    public void onGeneral_layout(View view) {
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        mMemberPresenter.postlobby(Config.getToken(),"1");
    }
    /**
     *高级任务
     */
    public void onAdvance_layout(View view) {
        general_tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        advance_tv.setCompoundDrawablePadding(10);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.mipmap.icon_white_point),null,null,null);
        mMemberPresenter.postlobby(Config.getToken(),"2");
    }
}
