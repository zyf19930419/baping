package com.bapingtianxia.baping.aty.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bapingtianxia.baping.R;
import com.bapingtianxia.baping.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:50
 * 功能描述：我要赚佣
 */
public class MakeMoneyAty extends BaseActivity {

    private TextView txt_title;
    private ImageView back_img;

    @Override
    public int getLayoutId() {
        return R.layout.activity_make_money;
    }

    @Override
    public void initView() {
        txt_title = findViewById(R.id.txt_title);
        txt_title.setText(getResources().getString(R.string.woyaozhuangyong));
        back_img=findViewById(R.id.back_img);
        back_img.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }
}
