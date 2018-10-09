package com.weibangbang.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weibangbang.R;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 13:53
 * 功能描述：
 */
public class TaskHallAdapter extends RecyclerView.Adapter<TaskHallAdapter.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
