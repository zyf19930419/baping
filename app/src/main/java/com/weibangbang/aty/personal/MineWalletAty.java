package com.weibangbang.aty.personal;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.personal.MineWalletBean;
import com.weibangbang.presenter.PersonalPresenter;
import com.weibangbang.utils.DateUtils;
import com.weibangbang.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:37
 * 功能描述：我的钱包
 */
public class MineWalletAty extends BaseActivity {

    private TextView mineWallet_balance_tv; // 余额
    private TextView mineWallet_withdraw_tv; // 提现
//    private TextView mineWallet_date_tv; // 日期
//    private TextView mineWallet_total_tv; // 合计
    private ListView mineWallet_list_lv; // ListView
    private PersonalPresenter mPersonalPresenter;
    private MyAdapter mMyAdapter;

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

    private List<MineWalletBean.DataBean.DetailDayBean> mList=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_wallet;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.mine_wallet,true);
        mineWallet_balance_tv = findViewById(R.id.mineWallet_balance_tv); // 余额
        mineWallet_withdraw_tv = findViewById(R.id.mineWallet_withdraw_tv); // 提现
//        mineWallet_date_tv = findViewById(R.id.mineWallet_date_tv); // 日期
//        mineWallet_total_tv = findViewById(R.id.mineWallet_total_tv); // 合计
        mineWallet_list_lv = findViewById(R.id.mineWallet_list_lv); // ListView

//        mineWallet_withdraw_tv.setOnClickListener(this);
//        mineWallet_date_tv.setOnClickListener(this);
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
                mPersonalPresenter.postMyWallet(Config.getToken(),p);
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
                mPersonalPresenter.postMyWallet(Config.getToken(),p);
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
        mPersonalPresenter.postMyWallet(Config.getToken(),p);
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        refreshVisibleState();
        if (requestUrl.endsWith("User/my_wallet.html")){
            MineWalletBean mineWalletBean = JSON.parseObject(jsonStr, MineWalletBean.class);
            MineWalletBean.DataBean data = mineWalletBean.getData();
            String user_balance = data.getBalance_find().getUser_balance();
            mineWallet_balance_tv.setText(user_balance);
            List<MineWalletBean.DataBean.DetailDayBean> detail_day = data.getDetail_day();
            if (p==1){
                mList.clear();
            }
            if (null!=detail_day){
                mList.addAll(detail_day);
            }
            if (null==mMyAdapter){
                mMyAdapter=new MyAdapter(mContext,detail_day);
                mineWallet_list_lv.setAdapter(mMyAdapter);
            }else {
                mMyAdapter.setData(mList);
            }
        }
    }

    @Override
    public void onFailure(String msg) {
        super.onFailure(msg);
        refreshVisibleState();
    }

    /**
     * 提现按钮
     */
    public void onTiXian(View view) {
        startActivity(WithdrawMoneyAty.class);
    }

    private static class  MyAdapter extends BaseAdapter{
        private List<MineWalletBean.DataBean.DetailDayBean> detail_day;
        private Context mContext;
        public MyAdapter(Context context,List<MineWalletBean.DataBean.DetailDayBean> detail_day) {
            this.detail_day = detail_day;
            mContext=context;
        }

        public void setData(List<MineWalletBean.DataBean.DetailDayBean> data){
            this.detail_day=data;
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return detail_day.size()>0?detail_day.size():0;
        }

        @Override
        public Object getItem(int position) {
            return detail_day.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder holder;
            if (view==null){
                holder=new ViewHolder();
                view= LayoutInflater.from(mContext).inflate(R.layout.item_mine_wallet,parent,false);
                holder.date_tv=view.findViewById(R.id.itemMineWallet_date_tv);
                holder.time_tv=view.findViewById(R.id.itemMineWallet_time_tv);
                holder.title_tv=view.findViewById(R.id.itemMineWallet_type_tv);
                holder.content_tv=view.findViewById(R.id.itemMineWallet_name_tv);
                holder.price_tv=view.findViewById(R.id.itemMineWallet_money_tv);
                view.setTag(holder);
            }else {
                holder= (ViewHolder) view.getTag();
            }

            MineWalletBean.DataBean.DetailDayBean detailDayBean = detail_day.get(position);
            String date = DateUtils.getDate(String.valueOf(detailDayBean.getDetail_creattime()));
            holder.date_tv.setText(date);
            String time = DateUtils.getTime(String.valueOf(detailDayBean.getDetail_creattime()));
            holder.time_tv.setText(time);
            holder.title_tv.setText(detailDayBean.getTask_name());
            holder.price_tv.setText(detailDayBean.getMoney());
            int detail_type = detailDayBean.getDetail_type();
            //明细类型1:任务奖励2:余额提现 ,
            if (1==detail_type){
                holder.content_tv.setText("任务奖励");
            }
            if (2==detail_type){
                holder.content_tv.setText("余额提现");
            }
            return view;
        }

        class ViewHolder{
            private TextView date_tv,time_tv,title_tv,content_tv,price_tv;
        }
    }
}
