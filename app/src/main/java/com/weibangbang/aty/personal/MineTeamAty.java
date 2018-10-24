package com.weibangbang.aty.personal;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.presenter.HomePresenter;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:38
 * 功能描述：我的团队
 */
public class MineTeamAty extends BaseActivity {
    private TextView commit_tv;
    private HomePresenter mHomePresenter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_team;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.mine_team,true);

        commit_tv = findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.inviting_friends);
    }

    @Override
    public void initData() {
        mHomePresenter = new HomePresenter(this);
    }

    /**
     * 邀请好友按钮
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
        oks.setImageData(BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("ic_launcher", "mipmap", getApplicationInfo().packageName)));
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
     * 查看一级会员列表
     */
    public void onFirstMember(View view) {
        Bundle bundle=new Bundle();
        bundle.putString("level","一");
        startActivity(MembershipListAty.class,bundle);
    }

    /**
     * 查看二级会员列表
     */
    public void onSecondMember(View view) {
        Bundle bundle=new Bundle();
        bundle.putString("level","二");
        startActivity(MembershipListAty.class,bundle);
    }
}
