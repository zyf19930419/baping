package com.weibangbang.aty.personal;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.presenter.PersonalPresenter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 创建者：voodoo_jie
 * <br>创建时间：2018/10/10 010下午 01:40
 * <br>功能描述：提现界面
 */
public class WithdrawMoneyAty extends BaseActivity implements View.OnClickListener {

    private TextView withdrawMoney_money_tv;
    private EditText withdrawMoney_moneyInput_et;
    private TextView commit_tv;
    private ImageView alipay_img;
    private ImageView wechat_img;
    private TextView alipay_tip_tv;
    private TextView wechat_tip_tv;
    private PersonalPresenter mPersonalPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_withdraw_money;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.put_forward), true);

        commit_tv = findViewById(R.id.commit_tv);
        alipay_img = findViewById(R.id.alipay_img);
        wechat_img = findViewById(R.id.wechat_img);
        alipay_tip_tv = findViewById(R.id.alipay_tip_tv);
        wechat_tip_tv = findViewById(R.id.wechat_tip_tv);
        withdrawMoney_moneyInput_et = findViewById(R.id.withdrawMoney_moneyInput_et);
        withdrawMoney_money_tv=findViewById(R.id.withdrawMoney_money_tv);

        commit_tv.setText(R.string.lijitixian); // 立即提现按钮
        commit_tv.setOnClickListener(this);
        withdrawMoney_moneyInput_et.addTextChangedListener(new MyTextWatcher());

        alipay_img.setSelected(true);
        alipay_tip_tv.setVisibility(View.VISIBLE);
        alipay_tip_tv.setText("提现￥0.00");
        wechat_tip_tv.setText("提现￥0.00");

        alipay_tip_tv.setSingleLine(true);
        wechat_tip_tv.setSingleLine(true);

    }

    @Override
    public void initData() {
        mPersonalPresenter=new PersonalPresenter(this);
        mPersonalPresenter.postUserBalance(Config.getToken());
    }

    public void onAlipay(View view) {
        alipay_img.setSelected(true);
        alipay_tip_tv.setVisibility(View.VISIBLE);
        wechat_img.setSelected(false);
        wechat_tip_tv.setVisibility(View.GONE);
    }

    public void onWechat(View view) {
        alipay_img.setSelected(false);
        alipay_tip_tv.setVisibility(View.GONE);
        wechat_img.setSelected(true);
        wechat_tip_tv.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit_tv:
                String s = withdrawMoney_moneyInput_et.getText().toString();
                if (s.isEmpty()) {
                    showShortToast("请输入金额", Toast.LENGTH_SHORT);
                    return;
                }
//                mPersonalPresenter.postWithDrawal();
                break;
        }
    }


    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("User/withdrawal.html")){
        }
        /**
         * {"code":1,"msg":"","data":{"user_balance":"99.00"}}
         */
        if (requestUrl.endsWith("User/user_balance.html")){
            try {
                JSONObject jsonObject=new JSONObject(jsonStr);
                JSONObject jsonObject2=new JSONObject(jsonObject.optString("data"));
                withdrawMoney_money_tv.setText(jsonObject2.optString("user_balance"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            alipay_tip_tv.setText("提现￥" + (editable.toString().isEmpty() ? "0.00" : editable.toString()));
            wechat_tip_tv.setText("提现￥" + (editable.toString().isEmpty() ? "0.00" : editable.toString()));
        }
    }


}
