package com.weibangbang.aty.member;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.adapter.TaskHallAdapter;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.member.LobbyBean;
import com.weibangbang.presenter.MemberPresenter;
import com.weibangbang.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:16
 * 功能描述：任务大厅
 */
public class TaskHallAty extends BaseActivity {
    private TextView general_tv, advance_tv;

    private RecyclerView mRecyclerView;
    private TaskHallAdapter mTaskHallAdapter;
    private MemberPresenter mMemberPresenter;
    private SuperSwipeRefreshLayout mSuperSwipeRefreshLayout;
    private int p = 1; // 请求的分页
    // Footer View
    private ProgressBar footerProgressBar;
    private TextView footerTextView;
    private ImageView footerImageView;
    /**
     * 1.普通任务
     * 2.高级任务
     */
    private String type = "1";

    private List<LobbyBean.DataBean> mList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_task_hall;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.renwudating), true);
        general_tv = findViewById(R.id.general_task_tv);
        advance_tv = findViewById(R.id.advance_task_tv);
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.mipmap.icon_white_point), null, null, null);

        mSuperSwipeRefreshLayout = findViewById(R.id.super_refreshLayout);
        mSuperSwipeRefreshLayout.setEnabled(false);
        mSuperSwipeRefreshLayout.setFooterView(createFooterView());
        mSuperSwipeRefreshLayout.setHeaderViewBackgroundColor(Color.WHITE);
        mSuperSwipeRefreshLayout.setTargetScrollWithLayout(true);
        mSuperSwipeRefreshLayout.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {
                footerTextView.setText("正在加载...");
                footerImageView.setVisibility(View.GONE);
                footerProgressBar.setVisibility(View.VISIBLE);
                p++;
                requestData();
            }

            @Override
            public void onPushDistance(int distance) {
            }

            @Override
            public void onPushEnable(boolean enable) {
                footerTextView.setText(enable ? "松开加载" : "上拉加载");
                footerImageView.setVisibility(View.VISIBLE);
                footerImageView.setRotation(enable ? 0 : 180);
            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
    }

    /**
     * 创建底部加载布局
     *
     * @return
     */
    private View createFooterView() {
        View footerView = LayoutInflater.from(mSuperSwipeRefreshLayout.getContext()).inflate(R.layout.layout_footer, null);
        footerProgressBar = footerView.findViewById(R.id.footer_pb_view);
        footerImageView = footerView.findViewById(R.id.footer_image_view);
        footerTextView = footerView.findViewById(R.id.footer_text_view);
        footerProgressBar.setVisibility(View.GONE);
        footerImageView.setVisibility(View.VISIBLE);
        footerImageView.setImageResource(R.drawable.down_arrow);
        footerTextView.setText("上拉加载更多...");
        return footerView;
    }

    private void refreshVisibleState() {
        if (footerProgressBar.getVisibility()==View.VISIBLE) {
            mSuperSwipeRefreshLayout.setLoadMore(false);
            footerProgressBar.setVisibility(View.GONE);
        }
    }
    @Override
    public void initData() {
        mMemberPresenter = new MemberPresenter(this);
        requestData();
    }

    private void requestData() {
        mMemberPresenter.postlobby(type, p);
    }


    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        refreshVisibleState();
        if (requestUrl.endsWith("Work/lobby.html")) {
            LobbyBean lobbyBean = JSON.parseObject(jsonStr, LobbyBean.class);
            final List<LobbyBean.DataBean> data = lobbyBean.getData();
            if (p == 1) {
                mList.clear();
            }
            if (null != data) {
                mList.addAll(data);
            }
            if (null == mTaskHallAdapter) {
                mTaskHallAdapter = new TaskHallAdapter(getResources().getString(R.string.renwudating), mList);
                mRecyclerView.setAdapter(mTaskHallAdapter);
                mTaskHallAdapter.setOnButtonClickListener(new TaskHallAdapter.onButtonClickListener() {
                    @Override
                    public void onButtonClick(int position) {
                        int task_id = data.get(position).getTask_id();
                        Bundle bundle = new Bundle();
                        bundle.putInt("task_id", task_id);
                        startActivity(TaskDetailsAty.class, bundle);
                    }
                });
            } else {
                mTaskHallAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onFailure(String msg) {
        super.onFailure(msg);
        refreshVisibleState();
    }

    /**
     * 普通任务
     */
    public void onGeneral_layout(View view) {
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.mipmap.icon_white_point), null, null, null);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        type = "1";
        p=1;
        mTaskHallAdapter=null;
        requestData();
    }

    /**
     * 高级任务
     */
    public void onAdvance_layout(View view) {
        general_tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        advance_tv.setCompoundDrawablePadding(10);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.mipmap.icon_white_point), null, null, null);
        type = "2";
        p=1;
        mTaskHallAdapter=null;
        requestData();
    }
}
