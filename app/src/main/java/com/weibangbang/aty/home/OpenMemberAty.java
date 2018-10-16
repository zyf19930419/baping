package com.weibangbang.aty.home;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.home.VipListBean;
import com.weibangbang.presenter.HomePresenter;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:54
 * 功能描述：开通会员
 */
public class OpenMemberAty extends BaseActivity {
    private TextView commit_tv;
    private ImageView[] imagebuttons;
    private ImageView[] imagebuttons2;
    private TextView[] textviews;
    private int redColor, txtColor;
    private String price;
    private HomePresenter mHomePresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_open_member;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.kaitonghuiyuan), true);
        commit_tv = findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.become_regular_member);
        redColor = ContextCompat.getColor(this, R.color.red_bg);
        txtColor = ContextCompat.getColor(this, R.color.txt_color);
        imagebuttons = new ImageView[2];
        imagebuttons[0] = findViewById(R.id.regular_member_img);
        imagebuttons[1] = findViewById(R.id.senior_member_img);
        imagebuttons[0].setSelected(true);
        imagebuttons2 = new ImageView[2];
        imagebuttons2[0] = findViewById(R.id.regular_member_img2);
        imagebuttons2[1] = findViewById(R.id.senior_member_img2);
        imagebuttons2[0].setSelected(true);
        textviews = new TextView[2];
        textviews[0] = findViewById(R.id.regular_member_tv);
        textviews[1] = findViewById(R.id.senior_member_tv);
        textviews[0].setTextColor(redColor);
        price = "99.00";
    }

    @Override
    public void initData() {
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.postVipList(Config.getToken());
    }

    /**
     * 普通会员
     *
     * @param view
     */
    public void onRegularClicked(View view) {
        imagebuttons[0].setSelected(true);
        imagebuttons[1].setSelected(false);
        imagebuttons2[0].setSelected(true);
        imagebuttons2[1].setSelected(false);
        textviews[0].setTextColor(redColor);
        textviews[1].setTextColor(txtColor);
        commit_tv.setText(R.string.become_regular_member);
        price = "99.00";
    }

    /**
     * 高级会员
     *
     * @param view
     */
    public void onSeniorClicked(View view) {
        imagebuttons[1].setSelected(true);
        imagebuttons[0].setSelected(false);
        imagebuttons2[1].setSelected(true);
        imagebuttons2[0].setSelected(false);
        textviews[1].setTextColor(redColor);
        textviews[0].setTextColor(txtColor);
        commit_tv.setText(R.string.become_senior_member);
        price = "999.00";
    }


    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Vip/vip_list.html")) {
            VipListBean vipListBean = JSON.parseObject(jsonStr, VipListBean.class);
            List<VipListBean.DataBean> data = vipListBean.getData();
            if (null!=data ){

            }
        }
    }

    /**
     * 开通会员
     *
     * @param view
     */
    public void onCommit(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("price", price);
        startActivity(PayMemberAty.class, bundle);
    }
}
