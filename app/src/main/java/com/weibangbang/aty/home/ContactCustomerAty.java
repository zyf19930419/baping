package com.weibangbang.aty.home;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:51
 * 功能描述：
 */
public class ContactCustomerAty extends BaseActivity{
    private TextView phone1_tv,phone2_tv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_contact_customer;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.lianxikefu),true);
    }

    @Override
    public void initData() {
        phone1_tv=findViewById(R.id.phone1_tv);
        phone2_tv=findViewById(R.id.phone2_tv);

    }

    public void onKefu1(View view) {
        ClipboardManager cm= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("kefu1",phone1_tv.getText());
        cm.setPrimaryClip(clipData);
        Toast.makeText(this, "复制成功", Toast.LENGTH_LONG).show();
    }

    public void onKefu2(View view) {
        ClipboardManager cm= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("kefu2",phone2_tv.getText());
        cm.setPrimaryClip(clipData);
        Toast.makeText(this, "复制成功", Toast.LENGTH_LONG).show();
    }
}
