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
import com.weibangbang.bean.personal.MemberShipBean;
import com.weibangbang.utils.GlideApp;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/10 8:40
 * 功能描述：排行榜和会员列表适配器
 */
public class RankingAndMemberAdapter extends RecyclerView.Adapter<RankingAndMemberAdapter.MyViewHolder> {

    private List<DailyRankingsBean.DataBean> data;
    private List<MemberShipBean.DataBean> memberShipData;
    /**
     * 1 排行榜
     * 2 会员列表
     */
    private int type = 0;
    private Context mContext;


    public void setData(List<DailyRankingsBean.DataBean> data,int type) {
        this.data = data;
        this.type=type;
        notifyDataSetChanged();
    }

    public void setMemberShipData(List<MemberShipBean.DataBean> memberShipData, int type) {
        this.memberShipData = memberShipData;
        this.type = type;
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
        holder.order_tv.setText(String.valueOf(position + 1));
        if (1==type){
            DailyRankingsBean.DataBean dataBean = data.get(position);
            holder.name_tv.setText(dataBean.getUser_name());
            holder.vip_name_tv.setVisibility(View.GONE);
            if (!TextUtils.isEmpty(dataBean.getUser_portrait())) {
                GlideApp.with(mContext).load(ApiService.BASE_IMAGE + dataBean.getUser_portrait()).circleCrop().into(holder.head_img);
            }

            holder.price_tv.setText(dataBean.getUser_history_brokerage());
        }


        if (2==type){
            MemberShipBean.DataBean dataBean = memberShipData.get(position);
            if (!TextUtils.isEmpty(dataBean.getUser_portrait())) {
                GlideApp.with(mContext).load(ApiService.BASE_IMAGE + dataBean.getUser_portrait()).circleCrop().into(holder.head_img);
            }
            holder.name_tv.setText(dataBean.getUser_name());
            holder.vip_name_tv.setVisibility(View.VISIBLE);
            holder.vip_name_tv.setText(dataBean.getVip_name());
            holder.price_tv.setText(dataBean.getUser_history_brokerage());
        }



    }

    @Override
    public int getItemCount() {
        if (1 == type) {
            return data.size() > 0 ? data.size() : 0;
        }

        if (2 == type) {
            return memberShipData.size() > 0 ? memberShipData.size() : 0;
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView order_tv, name_tv,vip_name_tv, price_tv;
        private ImageView head_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            order_tv = itemView.findViewById(R.id.order_tv);
            name_tv = itemView.findViewById(R.id.name_tv);
            vip_name_tv=itemView.findViewById(R.id.vip_name_tv);
            price_tv = itemView.findViewById(R.id.price_tv);
            head_img = itemView.findViewById(R.id.head_img);
        }
    }
}
