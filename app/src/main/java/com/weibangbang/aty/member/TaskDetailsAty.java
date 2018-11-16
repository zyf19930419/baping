package com.weibangbang.aty.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.api.Config;
import com.weibangbang.aty.LoginAty;
import com.weibangbang.aty.home.OpenMemberAty;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.member.TaskDetailsBean;
import com.weibangbang.presenter.MemberPresenter;
import com.weibangbang.utils.BitmapUtils;
import com.weibangbang.utils.GlideApp;
import com.weibangbang.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import static com.mob.MobSDK.getContext;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/11 14:00
 * 功能描述：
 */
public class TaskDetailsAty extends BaseActivity {
    private TextView commit_tv,money_tv1,money_tv2,money_tv3,num_tv;
    private int mTask_id;
    private MemberPresenter mMemberPresenter;

    private TextView title_tv, status_tv, copy_tv;

    private ImageView task_img;

    @Override
    public int getLayoutId() {
        return R.layout.activity_task_details;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.task_details), true);
        commit_tv = findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenlingqu);
        mTask_id = getIntent().getExtras().getInt("task_id");

        money_tv1 = findViewById(R.id.money_tv1);
        money_tv2 = findViewById(R.id.money_tv2);
        money_tv3 = findViewById(R.id.money_tv3);
        num_tv = findViewById(R.id.num_tv);

        title_tv = findViewById(R.id.title_tv);
        status_tv = findViewById(R.id.status_tv);
        copy_tv = findViewById(R.id.copy_tv);
        task_img = findViewById(R.id.task_img);
    }

    @Override
    public void initData() {
        mMemberPresenter = new MemberPresenter(this);
        mMemberPresenter.posTaskInfo(Config.getToken(), String.valueOf(mTask_id));
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Work/task_info.html")) {
            TaskDetailsBean taskDetailsBean = JSON.parseObject(jsonStr, TaskDetailsBean.class);
            title_tv.setText(taskDetailsBean.getData().getTask_name());
            status_tv.setText(taskDetailsBean.getData().getTask_require());
            copy_tv.setText(taskDetailsBean.getData().getTask_content());
            money_tv1.setText("我的悬赏：¥"+taskDetailsBean.getData().getTask_profit());
            money_tv2.setText("邀请人悬赏：¥"+taskDetailsBean.getData().getUser_inviter());
            money_tv3.setText("二级邀请人悬赏：¥"+taskDetailsBean.getData().getUser_inviter_2());
            num_tv.setText("任务数量："+taskDetailsBean.getData().getTask_getnum()+"/"+taskDetailsBean.getData().getTask_number());
            final String img_url = ApiService.BASE_IMAGE + taskDetailsBean.getData().getTask_image();
            GlideApp.with(mContext).load(img_url).into(task_img);
            task_img.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    BitmapUtils.gainInstance().savePic(mContext, img_url, System.currentTimeMillis() + "", new BitmapUtils.Listener() {
                        @Override
                        public void saveSuccess() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getContext(), "图片保存成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    return false;
                }
            });
        }

        if (requestUrl.endsWith("Work/task_get.html")) {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                String msg = jsonObject.getString("msg");
                ToastUtils.showToast(msg);
                finish();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 复制按钮点击事件
     *
     * @param view
     */
    public void onCopy(View view) {
        copyText(copy_tv.getText().toString());
    }

    /**
     * 确认领取按钮点击事件
     *
     * @param view
     */
    public void onCommit(View view) {
        if (!Config.isLogin()) {
            startActivity(LoginAty.class);
            return;
        }
        if (0 == Config.getVipId()) {
            startActivity(OpenMemberAty.class);
        } else {
            mMemberPresenter.posTaskGet(Config.getToken(), String.valueOf(mTask_id));
        }
    }

}
