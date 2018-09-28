package com.weibangbang.aty.home;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:50
 * 功能描述：我要赚佣
 */
public class MakeMoneyAty extends BaseActivity {

    private RecyclerView mRecyclerView;
    private MakeMoneyAdapter mMoneyAdapter;
    private  TextView commit_tv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_make_money;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.woyaozhuangyong),true);

        mRecyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);

        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.lijizhuanyong);
    }

    @Override
    public void initData() {
        mMoneyAdapter=new MakeMoneyAdapter();
        mRecyclerView.setAdapter(mMoneyAdapter);
    }


    private class MakeMoneyAdapter extends RecyclerView.Adapter<MakeMoneyAdapter.ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.make_money_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.content_tv.setText("第"+(position+1)+"步\u3000~\u3000"+R.string.make_money_tips);
        }

        @Override
        public int getItemCount() {
            return 5;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            private  TextView content_tv;

            public ViewHolder(View itemView) {
                super(itemView);
                content_tv=itemView.findViewById(R.id.content_tv);
            }
        }
    }
}
