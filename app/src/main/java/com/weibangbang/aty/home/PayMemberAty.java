package com.weibangbang.aty.home;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.alipay.AliPay;
import com.weibangbang.alipay.AliPayCallBack;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.presenter.HomePresenter;

import org.json.JSONException;
import org.json.JSONObject;

import static com.weibangbang.alipay.AliPay.SDK_PAY_FLAG;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/8 16:50
 * 功能描述：支付会员
 */
public class PayMemberAty extends BaseActivity {

    private String mPrice;
    private TextView commit_tv;
    private TextView price_tv;

    private ImageView alipay_img, wechat_img;
    private TextView alipay_tip_tv, wechat_tip_tv;

    private HomePresenter mHomePresenter;

    private String pay_way = "2";
    private String upgrade;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_member;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.pay_member), true);
        commit_tv = findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.lijizhifu);
        mPrice = getIntent().getExtras().getString("price");
        upgrade = getIntent().getExtras().getString("upgrade");
        price_tv = findViewById(R.id.price_tv);
        price_tv.setText("￥" + mPrice);

        alipay_img = findViewById(R.id.alipay_img);
        wechat_img = findViewById(R.id.wechat_img);
        alipay_tip_tv = findViewById(R.id.alipay_tip_tv);
        wechat_tip_tv = findViewById(R.id.wechat_tip_tv);
        alipay_img.setSelected(true);
        alipay_tip_tv.setVisibility(View.VISIBLE);
        alipay_tip_tv.setText("支付￥" + mPrice);
    }

    @Override
    public void initData() {
        mHomePresenter = new HomePresenter(this);
    }


    public void onAlipay(View view) {
        alipay_img.setSelected(true);
        alipay_tip_tv.setVisibility(View.VISIBLE);
        alipay_tip_tv.setText("支付￥" + mPrice);
        wechat_img.setSelected(false);
        wechat_tip_tv.setVisibility(View.GONE);
        pay_way = "2";
    }

    public void onWechat(View view) {
        alipay_img.setSelected(false);
        alipay_tip_tv.setVisibility(View.GONE);
        wechat_img.setSelected(true);
        wechat_tip_tv.setVisibility(View.VISIBLE);
        wechat_tip_tv.setText("支付￥" + mPrice);
        pay_way = "1";
    }

    public void onCommit(View view) {
        mHomePresenter.postVipUpgrade(Config.getToken(), upgrade, pay_way);
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Vip/vip_upgrade.html")) {
            //微信
            if ("1".equals(pay_way)) {
            }
            //支付宝
            if ("2".equals(pay_way)) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    String data = jsonObject.optString("data");
                    AliPay aliPay = new AliPay(data, SDK_PAY_FLAG, new AliPayCallBack() {
                        @Override
                        public void onComplete(String resultInfo) {
                            Log.e("TAG", "onComplete: " + resultInfo);
                        }

                        @Override
                        public void onFailure() {
                            Log.e("TAG", "onFailure: ");
                        }
                    });
                    aliPay.pay();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
