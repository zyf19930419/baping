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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.presenter.HomePresenter;
import com.weibangbang.utils.GlideApp;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:57
 * 功能描述：分享赚钱
 */
public class ShareMoneyAty extends BaseActivity {
    private TextView joinTip_tv, invitation_code_tv;
    private ImageView qrCode_img;
    private HomePresenter mHomePresenter;

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
        qrCode_img = findViewById(R.id.qrCode_img);

        SpannableString spannableString = new SpannableString(getResources().getString(R.string.join_tip));
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(styleSpan, 4, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F9B93D")), 4, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        joinTip_tv.setText(spannableString);
        String userInviterQrcode = Config.getUserInviterQrcode();
        String userInviter = Config.getUserInviter();
        if (!userInviter.isEmpty()) {
            invitation_code_tv.setText(userInviter);
        }
        if (!userInviterQrcode.isEmpty()) {
            GlideApp.with(mContext).load(userInviterQrcode).into(qrCode_img);
        }
        mHomePresenter = new HomePresenter(this);
    }

    @Override
    public void initData() {

    }

    /**
     * 点击分享按钮
     */
    public void onCommit(View view) {
        mHomePresenter.postShare();
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Index/share.html")){
            JSONObject jsonObject=JSONObject.parseObject(jsonStr);
            if (jsonObject.containsKey("data")){
                JSONObject object=JSONObject.parseObject(jsonObject.getString("data"));
                String title=object.containsKey("title")?object.getString("title"):"";
                String brief=object.containsKey("brief")?object.getString("brief"):"";
                String url=object.containsKey("url")?object.getString("url"):"";
                showShare(title,brief,url);
            }

        }
    }

    private void showShare(String title, String bref, String share_usl) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(title);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(bref);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        oks.setImageUrl("http://e.hiphotos.baidu.com/image/h%3D300/sign=047b418c923df8dcb93d8991fd1072bf/aec379310a55b3199f70cd0e4ea98226cffc173b.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(share_usl);

        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Toast.makeText(mContext, "分享成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.e("TAG", "onError: " + throwable.getMessage());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Toast.makeText(mContext, "分享取消", Toast.LENGTH_SHORT).show();
            }
        });
        // 启动分享GUI
        oks.show(this);
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
