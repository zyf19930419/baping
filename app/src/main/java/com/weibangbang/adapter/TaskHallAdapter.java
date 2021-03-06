package com.weibangbang.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.bean.home.NoticeBean;
import com.weibangbang.bean.member.LobbyBean;
import com.weibangbang.bean.member.MyTaskBean;
import com.weibangbang.utils.DateUtils;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 13:53
 * 功能描述：任务大厅、我的任务和公告栏列表页适配器
 */
public class TaskHallAdapter extends RecyclerView.Adapter<TaskHallAdapter.MyViewHolder> {
    private String mTitle;

    private onButtonClickListener mOnButtonClickListener;

    private List<LobbyBean.DataBean> taskHallData;
    private List<MyTaskBean.DataBean> myTaskData;
    private List<NoticeBean.DataBean> noticeData;

    public TaskHallAdapter(String title,List<LobbyBean.DataBean> taskHallData) {
        mTitle = title;
        this.taskHallData=taskHallData;
    }

    public void setTaskHallData(List<LobbyBean.DataBean> taskHallData) {
        this.taskHallData = taskHallData;
        notifyDataSetChanged();
    }

    public TaskHallAdapter(String title, List<MyTaskBean.DataBean> data, int type) {
        mTitle = title;
        this.myTaskData=data;
    }

    public void setMyTaskData(List<MyTaskBean.DataBean> myTaskData) {
        this.myTaskData = myTaskData;
        notifyDataSetChanged();
    }

    public TaskHallAdapter(List<NoticeBean.DataBean> noticeData) {
        mTitle = "公告栏";
        this.noticeData = noticeData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if ("任务大厅".equals(mTitle)){
            LobbyBean.DataBean dataBean = taskHallData.get(position);
            holder.button_tv.setVisibility(View.VISIBLE);
            holder.date_tv.setVisibility(View.GONE);
            holder.button_tv.setText("查 看");
            holder.left_img.setImageResource(R.mipmap.icon_task);
            holder.button_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mOnButtonClickListener){
                        mOnButtonClickListener.onButtonClick(position);
                    }
                }
            });

            holder.title_tv.setText(dataBean.getTask_name());
            holder.status_tv.setText(dataBean.getTask_require());
            holder.num_tv.setVisibility(View.VISIBLE);
            holder.money_tv.setVisibility(View.VISIBLE);
            holder.money_tv.setText("任务悬赏："+dataBean.getTask_profit()+"元");
            holder.num_tv.setText("任务数量："+dataBean.getTask_getnum()+"/"+dataBean.getTask_number());
        }

        if ("我的任务".equals(mTitle)){
            holder.button_tv.setVisibility(View.VISIBLE);
            holder.date_tv.setVisibility(View.GONE);
            holder.left_img.setImageResource(R.mipmap.icon_task);

            MyTaskBean.DataBean dataBean = myTaskData.get(position);

            holder.title_tv.setText(dataBean.getTask_name());
            int user_task_status = dataBean.getUser_task_status();
            //1.领取2.审核中3.审核成功4.审核失败
            switch (user_task_status){
                case 1:
                    holder.button_tv.setBackgroundResource(R.mipmap.icon_button_bg);
                    holder.button_tv.setClickable(true);
                    holder.button_tv.setText("上传截图");
                    holder.button_tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (null != mOnButtonClickListener){
                                mOnButtonClickListener.onButtonClick(position);
                            }
                        }
                    });
                    break;
                case 2:
                    holder.button_tv.setText("审核中");
                    holder.button_tv.setBackgroundResource(R.mipmap.icon_button_grey_bg);
                    holder.button_tv.setClickable(false);
                    break;
                case 3:
                    holder.button_tv.setText("审核成功");
                    holder.button_tv.setBackgroundResource(R.mipmap.icon_button_grey_bg);
                    holder.button_tv.setClickable(false);
                    break;
                case 4:
                    holder.button_tv.setText("审核失败");
                    holder.button_tv.setBackgroundResource(R.mipmap.icon_button_grey_bg);
                    holder.button_tv.setClickable(false);
                    break;

            }
            holder.status_tv.setText("任务状态："+dataBean.getUser_task_status_chinese());
        }

        if ("公告栏".equals(mTitle)){
            holder.button_tv.setVisibility(View.GONE);
            holder.date_tv.setVisibility(View.VISIBLE);
            holder.left_img.setImageResource(R.mipmap.icon_notice);

            NoticeBean.DataBean dataBean = noticeData.get(position);
            holder.title_tv.setText(dataBean.getNotice_title());
            holder.status_tv.setText(dataBean.getNotice_brief());
            holder.date_tv.setText(DateUtils.getDate(String.valueOf(dataBean.getNotice_creattime())));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnButtonClickListener!=null){
                        mOnButtonClickListener.onButtonClick(holder.getLayoutPosition());
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        if ("任务大厅".equals(mTitle)){
            return taskHallData.size()>0?taskHallData.size():0;
        }
        if ("我的任务".equals(mTitle)){
            return myTaskData.size()>0?myTaskData.size():0;
        }
        if ("公告栏".equals(mTitle)){
            return noticeData.size()>0?noticeData.size():0;
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView left_img;
        private TextView title_tv,status_tv,num_tv,money_tv,button_tv,date_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            left_img=itemView.findViewById(R.id.left_img);
            title_tv=itemView.findViewById(R.id.title_tv);
            status_tv=itemView.findViewById(R.id.status_tv);
            num_tv=itemView.findViewById(R.id.num_tv);
            money_tv=itemView.findViewById(R.id.money_tv);
            button_tv=itemView.findViewById(R.id.button_tv);
            date_tv=itemView.findViewById(R.id.date_tv);
        }
    }


    public interface onButtonClickListener{
        void onButtonClick(int position);
    }

    public void setOnButtonClickListener(onButtonClickListener onButtonClickListener){
        mOnButtonClickListener=onButtonClickListener;
    }
}
