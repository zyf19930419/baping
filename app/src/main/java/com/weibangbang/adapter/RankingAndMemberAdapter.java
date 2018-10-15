package com.weibangbang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.bean.member.DailyRankingsBean;
import com.weibangbang.utils.GlideApp;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/10 8:40
 * 功能描述：排行榜和会员列表适配器
 */
public class RankingAndMemberAdapter extends RecyclerView.Adapter<RankingAndMemberAdapter.MyViewHolder> {

    private List<DailyRankingsBean.DataBean> data;

    private Context mContext;


    public void setData(List<DailyRankingsBean.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_ranking, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DailyRankingsBean.DataBean dataBean = data.get(position);
        holder.order_tv.setText(String.valueOf(position + 1));
        holder.name_tv.setText(dataBean.getUser_name());
        if (TextUtils.isEmpty(dataBean.getUser_portrait())) {
            GlideApp.with(mContext).load(ApiService.OFFICIAL_WEB + dataBean.getUser_portrait()).circleCrop().into(holder.head_img);
        }

        holder.price_tv.setText(dataBean.getUser_history_brokerage());


    }

    @Override
    public int getItemCount() {
        return data.size() > 0 ? data.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView order_tv, name_tv, price_tv;
        private ImageView head_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            order_tv = itemView.findViewById(R.id.order_tv);
            name_tv = itemView.findViewById(R.id.name_tv);
            price_tv = itemView.findViewById(R.id.price_tv);
            head_img = itemView.findViewById(R.id.head_img);
        }
    }
}
