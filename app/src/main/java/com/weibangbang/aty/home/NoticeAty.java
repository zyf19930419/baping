package com.weibangbang.aty.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.adapter.TaskHallAdapter;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.home.NoticeBean;
import com.weibangbang.presenter.HomePresenter;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/10 15:21
 * 功能描述：公告栏
 */
public class NoticeAty extends BaseActivity {

    private RecyclerView mRecyclerView;
    private TaskHallAdapter mTaskHallAdapter;
    private HomePresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_notice;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.notice_board), true);

        mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

    }

    @Override
    public void initData() {
        mPresenter = new HomePresenter(this);
        mPresenter.postNotice();
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("notice.html")) {
            NoticeBean noticeBean = JSON.parseObject(jsonStr, NoticeBean.class);
            final List<NoticeBean.DataBean> data = noticeBean.getData();
            if (null != data) {
                mTaskHallAdapter = new TaskHallAdapter(data);
                mRecyclerView.setAdapter(mTaskHallAdapter);
                mTaskHallAdapter.setOnButtonClickListener(new TaskHallAdapter.onButtonClickListener() {
                    @Override
                    public void onButtonClick(int position) {
                        int notice_id = data.get(position).getNotice_id();
                        Bundle bundle = new Bundle();
                        bundle.putInt("notice_id", notice_id);
                        startActivity(NoticeDetailsAty.class, bundle);
                    }
                });
            }

        }
    }
}
