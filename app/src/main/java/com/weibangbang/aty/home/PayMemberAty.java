package com.weibangbang.aty.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/8 16:50
 * 功能描述：支付会员
 */
public class PayMemberAty extends BaseActivity{

    private String mPrice;
    private TextView commit_tv;
    private TextView price_tv;

    private ImageView alipay_img,wechat_img;
    private TextView alipay_tip_tv,wechat_tip_tv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_member;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.pay_member),true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.lijizhifu);
        mPrice = getIntent().getExtras().getString("price");
        price_tv=findViewById(R.id.price_tv);
        price_tv.setText("￥"+mPrice);

        alipay_img=findViewById(R.id.alipay_img);
        wechat_img=findViewById(R.id.wechat_img);
        alipay_tip_tv=findViewById(R.id.alipay_tip_tv);
        wechat_tip_tv=findViewById(R.id.wechat_tip_tv);
        alipay_img.setSelected(true);
        alipay_tip_tv.setVisibility(View.VISIBLE);
        alipay_tip_tv.setText("支付￥"+mPrice);
    }

    @Override
    public void initData() {

    }



    public void onAlipay(View view) {
        alipay_img.setSelected(true);
        alipay_tip_tv.setVisibility(View.VISIBLE);
        alipay_tip_tv.setText("支付￥"+mPrice);
        wechat_img.setSelected(false);
        wechat_tip_tv.setVisibility(View.GONE);
    }

    public void onWechat(View view) {
        alipay_img.setSelected(false);
        alipay_tip_tv.setVisibility(View.GONE);
        wechat_img.setSelected(true);
        wechat_tip_tv.setVisibility(View.VISIBLE);
        wechat_tip_tv.setText("支付￥"+mPrice);
    }

    public void onCommit(View view) {

    }
}
