package com.weibangbang.fgt;

import android.view.View;
import android.widget.RelativeLayout;

;
import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.aty.LoginAty;
import com.weibangbang.aty.home.PutInAty;
import com.weibangbang.aty.member.MyTaskAty;
import com.weibangbang.aty.member.RankingListAty;
import com.weibangbang.aty.member.TaskHallAty;
import com.weibangbang.aty.member.TaskRulesAty;
import com.weibangbang.base.BaseFragment;
import com.weibangbang.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 11:16
 * 功能描述：会员中心
 */
public class MemberMainFgt extends BaseFragment implements View.OnClickListener{

    private Banner mBanner;
    private List<String> images;
    private RelativeLayout re_dating,re_guize,re_paihang,re_renwu;
    @Override
    protected int getLayoutResId() {
        return R.layout.fgt_member;
    }

    @Override
    protected void initialized(View view) {
        initBanner(view);
        initView(view);
    }

    private void initView(View view) {
        re_dating=view.findViewById(R.id.re_dating);
        re_guize=view.findViewById(R.id.re_guize);
        re_paihang=view.findViewById(R.id.re_paihang);
        re_renwu=view.findViewById(R.id.re_renwu);
        re_dating.setOnClickListener(this);
        re_guize.setOnClickListener(this);
        re_paihang.setOnClickListener(this);
        re_renwu.setOnClickListener(this);
    }

    private void initBanner(View view) {
        images = new ArrayList<>();
        images.add("http://e.hiphotos.baidu.com/image/pic/item/72f082025aafa40fafb5fbc1a664034f78f019be.jpg");
        images.add("http://f.hiphotos.baidu.com/image/h%3D300/sign=bcf7dcc18f025aafcc3278cbcbecab8d/f3d3572c11dfa9ece7f7cc166fd0f703908fc1d2.jpg");
        images.add("http://d.hiphotos.baidu.com/image/pic/item/279759ee3d6d55fbb1cd662760224f4a20a4dda3.jpg");
        images.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=c84fda6342c2d562ed08d6edd71090f3/7e3e6709c93d70cf4ab0de0ef5dcd100baa12b6e.jpg");
        mBanner = view.findViewById(R.id.banner);
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
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.re_dating:
                if (Config.isLogin()){
                    startActivity(TaskHallAty.class);
                }else {
                    startActivity(LoginAty.class);
                }
                break;
            case R.id.re_guize:
                startActivity(TaskRulesAty.class);
                break;
            case R.id.re_paihang:
                startActivity(RankingListAty.class);
                break;
            case R.id.re_renwu:
                startActivity(MyTaskAty.class);
                break;

        }
    }



}
