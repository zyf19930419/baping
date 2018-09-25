package com.bapingtianxia.baping.fgt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TimePicker;

import com.bapingtianxia.baping.R;
import com.bapingtianxia.baping.aty.home.ContactCustomerAty;
import com.bapingtianxia.baping.aty.home.FreeLeadAty;
import com.bapingtianxia.baping.aty.home.InviteFriendsAty;
import com.bapingtianxia.baping.aty.home.MakeMoneyAty;
import com.bapingtianxia.baping.aty.home.OpenMemberAty;
import com.bapingtianxia.baping.aty.home.PutInAty;
import com.bapingtianxia.baping.base.BaseFragment;
import com.bapingtianxia.baping.utils.DisplayHelper;
import com.bapingtianxia.baping.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 11:15
 * 功能描述：首页
 */
public class HomeMainFgt extends BaseFragment implements View.OnClickListener{

    private Banner mBanner;
    private List<String> images;
    private RelativeLayout re_zhuangyong,re_lingyong,re_huiyuan,re_toufang,re_haoyou,re_kefu;

    @Override
    protected int getLayoutResId() {
        return R.layout.fgt_home;
    }

    @Override
    protected void initialized(View view) {
        initBanner(view);
        initView(view);
    }

    private void initView(View view) {
        re_zhuangyong=view.findViewById(R.id.re_zhuangyong);
        re_lingyong=view.findViewById(R.id.re_lingyong);
        re_huiyuan=view.findViewById(R.id.re_huiyuan);
        re_toufang=view.findViewById(R.id.re_toufang);
        re_haoyou=view.findViewById(R.id.re_haoyou);
        re_kefu=view.findViewById(R.id.re_kefu);
        re_zhuangyong.setOnClickListener(this);
        re_lingyong.setOnClickListener(this);
        re_huiyuan.setOnClickListener(this);
        re_toufang.setOnClickListener(this);
        re_haoyou.setOnClickListener(this);
        re_kefu.setOnClickListener(this);
    }

    private void initBanner(View view) {
        images=new ArrayList<>();
        images.add("http://e.hiphotos.baidu.com/image/pic/item/72f082025aafa40fafb5fbc1a664034f78f019be.jpg");
        images.add("http://f.hiphotos.baidu.com/image/h%3D300/sign=bcf7dcc18f025aafcc3278cbcbecab8d/f3d3572c11dfa9ece7f7cc166fd0f703908fc1d2.jpg");
        images.add("http://d.hiphotos.baidu.com/image/pic/item/279759ee3d6d55fbb1cd662760224f4a20a4dda3.jpg");
        images.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=c84fda6342c2d562ed08d6edd71090f3/7e3e6709c93d70cf4ab0de0ef5dcd100baa12b6e.jpg");
        mBanner=view.findViewById(R.id.banner);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    protected void requestData() {

    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.re_zhuangyong:
                startActivity(MakeMoneyAty.class);
                break;
            case R.id.re_lingyong:
                startActivity(FreeLeadAty.class);
                break;
            case R.id.re_huiyuan:
                startActivity(OpenMemberAty.class);
                break;
            case R.id.re_toufang:
                startActivity(PutInAty.class);
                break;
            case R.id.re_haoyou:
                startActivity(InviteFriendsAty.class);
                break;
            case R.id.re_kefu:
                startActivity(ContactCustomerAty.class);
                break;
        }
    }
}
