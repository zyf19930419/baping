package com.weibangbang.fgt;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseFragment;
import com.weibangbang.utils.GlideApp;

;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 11:16
 * 功能描述：个人中心
 */
public class PersonalMainFgt extends BaseFragment {
    private ImageView head_img;
    private TextView commit_tv;
    @Override
    protected int getLayoutResId() {
        return R.layout.fgt_personal;
    }

    @Override
    protected void initialized(View view) {

        head_img=view.findViewById(R.id.head_img);
        commit_tv=view.findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.login_out);
        GlideApp.with(mContext).load("http://www.qqzhi.com/uploadpic/2014-09-12/094013726.jpg").circleCrop().into(head_img);
    }

    @Override
    protected void requestData() {

    }
}
