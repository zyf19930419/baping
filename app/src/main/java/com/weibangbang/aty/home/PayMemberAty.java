package com.weibangbang.aty.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.paysdk.AliPayAPI;
import com.mob.paysdk.MobPayAPI;
import com.mob.paysdk.OnPayListener;
import com.mob.paysdk.PayOrder;
import com.mob.paysdk.PayResult;
import com.mob.paysdk.PaySDK;
import com.mob.paysdk.WXPayAPI;
import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.presenter.HomePresenter;

import org.json.JSONException;
import org.json.JSONObject;

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
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                String data = jsonObject.optString("data");
                PayOrder order = new PayOrder();
                order.setOrderNo("订单号");
                order.setAmount(Integer.parseInt(mPrice)*100);
                order.setSubject("1111");
                order.setBody("支付主体");
                //微信
                if ("1".equals(pay_way)) {
                    WXPayAPI wxpay = PaySDK.createMobPayAPI(WXPayAPI.class);
                    wxpay.pay(order,new MyOnPayListener());
                }
                //支付宝
                if ("2".equals(pay_way)) {
                    AliPayAPI alipay = PaySDK.createMobPayAPI(AliPayAPI.class);
                    alipay.pay(order, new MyOnPayListener());
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    class MyOnPayListener implements OnPayListener{
        @Override
        public boolean onWillPay(String s, Object o, MobPayAPI mobPayAPI) {
            // TODO 保存本次支付操作的 ticketId
            // 返回false表示不阻止本次支付
            return false;
        }

        @Override
        public void onPayEnd(PayResult payResult, Object o, MobPayAPI mobPayAPI) {
            // TODO 处理支付的结果，成功或失败可以在payResult中获取
            int result = payResult.getPayCode();
            if (PayResult.PAYCODE_OK == result) {
                Toast.makeText(mContext, R.string.main_pay_success, Toast.LENGTH_SHORT).show();
            } else if (PayResult.PAYCODE_CANCEL == result) {
                Toast.makeText(mContext, R.string.main_pay_cancel, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(mContext, R.string.main_pay_fail, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
