package com.weibangbang.aty.member;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.weibangbang.R;
import com.weibangbang.adapter.TaskHallAdapter;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.member.MyTaskBean;
import com.weibangbang.bean.personal.UpLoadBean;
import com.weibangbang.presenter.MemberPresenter;
import com.weibangbang.presenter.PersonalPresenter;
import com.weibangbang.utils.ToastUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.weibangbang.aty.personal.PersonaInfoAty.IMAGE_PICKER;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 16:19
 * 功能描述：我的任务
 */
public class MyTaskAty extends BaseActivity {
    private TextView general_tv, advance_tv;

    private RecyclerView mRecyclerView;
    private TaskHallAdapter mTaskHallAdapter;
    private MemberPresenter mMemberPresenter;
    private PersonalPresenter mPersonalPresenter;
    private int mTask_id;
    private boolean isFirst = false;
    private int state = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mytask;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.woderenwu), true);
        general_tv = findViewById(R.id.general_task_tv);
        advance_tv = findViewById(R.id.advance_task_tv);
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.mipmap.icon_white_point), null, null, null);

        mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

    }

    @Override
    public void initData() {
        if (!isFirst) {
            mMemberPresenter = new MemberPresenter(this);
            mPersonalPresenter = new PersonalPresenter(this);
            mMemberPresenter.postReceivie(Config.getToken());
            isFirst = true;
        }
    }

    /**
     * 已领用
     */
    public void onGeneral_layout(View view) {
        general_tv.setCompoundDrawablePadding(10);
        general_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.mipmap.icon_white_point), null, null, null);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mMemberPresenter.postReceivie(Config.getToken());
        state = 0;
    }

    /**
     * 已完成
     */
    public void onAdvance_layout(View view) {
        general_tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        advance_tv.setCompoundDrawablePadding(10);
        advance_tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.mipmap.icon_white_point), null, null, null);
        mMemberPresenter.postTaskAccomplish(Config.getToken());
        state = 1;
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Work/receive.html")) {
            MyTaskBean myTaskBean = JSON.parseObject(jsonStr, MyTaskBean.class);
            final List<MyTaskBean.DataBean> data = myTaskBean.getData();
            if (null != data) {
                mTaskHallAdapter = new TaskHallAdapter(getResources().getString(R.string.woderenwu), data, 0);
                mRecyclerView.setAdapter(mTaskHallAdapter);
                mTaskHallAdapter.setOnButtonClickListener(new TaskHallAdapter.onButtonClickListener() {
                    @Override
                    public void onButtonClick(int position) {
                        setImagePicker();
                        Intent intent = new Intent(mContext, ImageGridActivity.class);
                        startActivityForResult(intent, IMAGE_PICKER);
                        mTask_id = data.get(position).getUser_task_id();
                    }
                });
            }
        }
        if (requestUrl.endsWith("Work/task_accomplish.html")) {
            MyTaskBean myTaskBean = JSON.parseObject(jsonStr, MyTaskBean.class);
            final List<MyTaskBean.DataBean> data = myTaskBean.getData();
            if (null != data) {
                mTaskHallAdapter = new TaskHallAdapter(getResources().getString(R.string.woderenwu), data, 1);
                mRecyclerView.setAdapter(mTaskHallAdapter);
                mTaskHallAdapter.setOnButtonClickListener(new TaskHallAdapter.onButtonClickListener() {
                    @Override
                    public void onButtonClick(int position) {
                        setImagePicker();
                        Intent intent = new Intent(mContext, ImageGridActivity.class);
                        startActivityForResult(intent, IMAGE_PICKER);
                        mTask_id = data.get(position).getUser_task_id();
                    }
                });
            }
        }
        if (requestUrl.endsWith("Base/upload_img.html")) {
            UpLoadBean upLoadBean = JSON.parseObject(jsonStr, UpLoadBean.class);
            ToastUtils.showToast(upLoadBean.getMsg());
            mMemberPresenter.postTaskPrintscreen(Config.getToken(), String.valueOf(mTask_id), upLoadBean.getData().getPath());
        }

        if (requestUrl.endsWith("Work/task_printscreen.html")) {
            if (0 == state) {
                mMemberPresenter.postReceivie(Config.getToken());
            }else if (1==state){
                mMemberPresenter.postTaskAccomplish(Config.getToken());
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                List<File> fileList = new ArrayList<>();
                for (int i = 0; i < images.size(); i++) {
                    fileList.add(new File(images.get(i).path));
                }
                if (fileList.size() > 0) {
                    mPersonalPresenter.postUpLoad(fileList);
                }

            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
