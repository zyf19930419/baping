package com.weibangbang.aty.personal;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.adapter.RankingAndMemberAdapter;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.personal.MemberShipBean;
import com.weibangbang.presenter.PersonalPresenter;
import com.weibangbang.utils.DisplayHelper;
import com.weibangbang.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
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

    private SuperSwipeRefreshLayout mSuperSwipeRefreshLayout;
    private int p = 1; // 请求的分页
    // Header View
    private ProgressBar progressBar;
    private TextView textView;
    private ImageView imageView;
    // Footer View
    private ProgressBar footerProgressBar;
    private TextView footerTextView;
    private ImageView footerImageView;

    private List<MemberShipBean.DataBean> mList=new ArrayList<>();
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
        mSuperSwipeRefreshLayout = findViewById(R.id.super_refreshLayout);
        mSuperSwipeRefreshLayout.setHeaderView(createHeaderView());
        mSuperSwipeRefreshLayout.setFooterView(createFooterView());
        mSuperSwipeRefreshLayout.setHeaderViewBackgroundColor(Color.WHITE);
        mSuperSwipeRefreshLayout.setTargetScrollWithLayout(true);
        mSuperSwipeRefreshLayout.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {
            @Override
            public void onRefresh() {
                textView.setText("正在刷新");
                imageView.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                p = 1;
                if ("一".equals(mLevel)){
                    mPersonalPresenter.postTeam11J(Config.getToken(),p);
                }else if ("二".equals(mLevel)){
                    mPersonalPresenter.postTeam22J(Config.getToken(),p);
                }
            }

            @Override
            public void onPullDistance(int distance) {

            }

            @Override
            public void onPullEnable(boolean enable) {
                textView.setText(enable ? "松开刷新" : "下拉刷新");
                imageView.setVisibility(View.VISIBLE);
                imageView.setRotation(enable ? 180 : 0);
            }
        });
        mSuperSwipeRefreshLayout.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {
                footerTextView.setText("正在加载...");
                footerImageView.setVisibility(View.GONE);
                footerProgressBar.setVisibility(View.VISIBLE);
                p++;
                if ("一".equals(mLevel)){
                    mPersonalPresenter.postTeam11J(Config.getToken(),p);
                }else if ("二".equals(mLevel)){
                    mPersonalPresenter.postTeam22J(Config.getToken(),p);
                }
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
        mRecyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter=new RankingAndMemberAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
                if (parent.getChildAdapterPosition(view) == (layoutManager.getItemCount() - 1)) {
                    outRect.bottom = DisplayHelper.dp2px(mContext, 15);
                }
            }
        });
    }

    /**
     * 创建头部加载布局
     *
     * @return
     */
    private View createHeaderView() {
        View headerView = LayoutInflater.from(mSuperSwipeRefreshLayout.getContext()).inflate(R.layout.layout_head, null);
        progressBar = headerView.findViewById(R.id.pb_view);
        textView = headerView.findViewById(R.id.text_view);
        textView.setText("下拉刷新");
        imageView = headerView.findViewById(R.id.image_view);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(R.drawable.down_arrow);
        progressBar.setVisibility(View.GONE);
        return headerView;
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
        if (progressBar.getVisibility()== View.VISIBLE){
            mSuperSwipeRefreshLayout.setRefreshing(false);
            progressBar.setVisibility(View.GONE);
        }
        if (footerProgressBar.getVisibility()==View.VISIBLE) {
            mSuperSwipeRefreshLayout.setLoadMore(false);
            footerProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void initData() {
        mPersonalPresenter = new PersonalPresenter(this);
        if ("一".equals(mLevel)){
            mPersonalPresenter.postTeam11J(Config.getToken(),p);
        }else if ("二".equals(mLevel)){
            mPersonalPresenter.postTeam22J(Config.getToken(),p);
        }
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        refreshVisibleState();
        MemberShipBean memberShipBean = JSON.parseObject(jsonStr, MemberShipBean.class);
        List<MemberShipBean.DataBean> data = memberShipBean.getData();
        if (p==1){
            mList.clear();
        }
        mList.addAll(data);
        mAdapter.setMemberShipData(mList,2);
//        if (requestUrl.endsWith("User/team11J.html")){
//            mAdapter.setMemberShipData(mList,2);
//        }
//        if (requestUrl.endsWith("User/team22J.html")){
//            mAdapter.setMemberShipData(mList,2);
//        }
    }

    @Override
    public void onFailure(String msg) {
        super.onFailure(msg);
        refreshVisibleState();
    }
}
