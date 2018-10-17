package com.weibangbang.aty.home;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.utils.GlideApp;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:57
 * 功能描述：分享赚钱
 */
public class ShareMoneyAty extends BaseActivity {
    private TextView joinTip_tv, invitation_code_tv;
    private ImageView qrCode_img;

    @Override
    public int getLayoutId() {
        return R.layout.acvity_share_money;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.fenxiangzhuanqian), true);
        joinTip_tv = findViewById(R.id.joinTip_tv);
        invitation_code_tv = findViewById(R.id.invitation_code_tv);
        qrCode_img=findViewById(R.id.qrCode_img);

        SpannableString spannableString = new SpannableString(getResources().getString(R.string.join_tip));
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(styleSpan, 4, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F9B93D")), 4, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        joinTip_tv.setText(spannableString);
        String userInviterQrcode = Config.getUserInviterQrcode();
        String userInviter = Config.getUserInviter();
        if (!userInviter.isEmpty()){
            invitation_code_tv.setText(userInviter);
        }
        if (!userInviterQrcode.isEmpty()){
            GlideApp.with(mContext).load(userInviterQrcode).into(qrCode_img);
        }

    }

    @Override
    public void initData() {

    }

    /**
     * 点击分享按钮
     */
    public void onCommit(View view) {
    }

    /**
     * 复制按钮
     */
    public void onCopy(View view) {
        if (!TextUtils.isEmpty(invitation_code_tv.getText())) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("", invitation_code_tv.getText());
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(this, "复制成功", Toast.LENGTH_SHORT).show();
        }

    }
}
