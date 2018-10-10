package com.weibangbang.aty.personal;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:37
 * 功能描述：我的钱包
 */
public class MineWalletAty extends BaseActivity implements View.OnClickListener {

    private ImageView back_img; // 返回按钮
    private TextView txt_title; // 标题栏
    private TextView mineWallet_balance_tv; // 余额
    private TextView mineWallet_withdraw_tv; // 提现
    private TextView mineWallet_date_tv; // 日期
    private TextView mineWallet_total_tv; // 合计
    private ListView mineWallet_list_lv; // ListView

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_wallet;
    }

    @Override
    public void initView() {
        back_img = findViewById(R.id.back_img); // 返回按钮
        txt_title = findViewById(R.id.txt_title); // 标题栏
        mineWallet_balance_tv = findViewById(R.id.mineWallet_balance_tv); // 余额
        mineWallet_withdraw_tv = findViewById(R.id.mineWallet_withdraw_tv); // 提现
        mineWallet_date_tv = findViewById(R.id.mineWallet_date_tv); // 日期
        mineWallet_total_tv = findViewById(R.id.mineWallet_total_tv); // 合计
        mineWallet_list_lv = findViewById(R.id.mineWallet_list_lv); // ListView

        back_img.setOnClickListener(this);
        back_img.setVisibility(View.VISIBLE);
        mineWallet_withdraw_tv.setOnClickListener(this);
        mineWallet_date_tv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        txt_title.setText(getResources().getString(R.string.mine_wallet));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                this.finish();
                break;
        }
    }
}
