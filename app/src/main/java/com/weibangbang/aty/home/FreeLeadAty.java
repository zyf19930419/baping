package com.weibangbang.aty.home;

import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:53
 * 功能描述：免费领佣
 */
public class FreeLeadAty extends BaseActivity{

    private TextView commit_tv;
    private Banner mBanner;
    private List<String> images;
    @Override
    public int getLayoutId() {
        return R.layout.activity_free_lead;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.mianfeilingyong),true);

        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.lijilingqu);
        initBanner();
    }

    private void initBanner() {
        images = new ArrayList<>();
        images.add("http://e.hiphotos.baidu.com/image/pic/item/72f082025aafa40fafb5fbc1a664034f78f019be.jpg");
        images.add("http://f.hiphotos.baidu.com/image/h%3D300/sign=bcf7dcc18f025aafcc3278cbcbecab8d/f3d3572c11dfa9ece7f7cc166fd0f703908fc1d2.jpg");
        images.add("http://d.hiphotos.baidu.com/image/pic/item/279759ee3d6d55fbb1cd662760224f4a20a4dda3.jpg");
        images.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=c84fda6342c2d562ed08d6edd71090f3/7e3e6709c93d70cf4ab0de0ef5dcd100baa12b6e.jpg");
        mBanner = findViewById(R.id.banner);
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
    public void initData() {

    }
}
