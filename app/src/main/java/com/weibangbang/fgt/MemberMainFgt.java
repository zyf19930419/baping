package com.weibangbang.fgt;

import android.view.View;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.api.Config;
import com.weibangbang.aty.LoginAty;
import com.weibangbang.aty.member.MyTaskAty;
import com.weibangbang.aty.member.RankingListAty;
import com.weibangbang.aty.member.TaskHallAty;
import com.weibangbang.aty.member.TaskRulesAty;
import com.weibangbang.base.BaseFragment;
import com.weibangbang.bean.home.BannerBean;
import com.weibangbang.loader.BannerLoader;
import com.weibangbang.presenter.HomePresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 11:16
 * 功能描述：会员中心
 */
public class MemberMainFgt extends BaseFragment implements View.OnClickListener {

    private Banner mBanner;
    private List<String> images;
    private RelativeLayout re_dating, re_guize, re_paihang, re_renwu;
    private HomePresenter mPresenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fgt_member;
    }

    @Override
    protected void initialized(View view) {
        initView(view);
    }

    private void initView(View view) {
        images = new ArrayList<>();
        mBanner = view.findViewById(R.id.banner);
        re_dating = view.findViewById(R.id.re_dating);
        re_guize = view.findViewById(R.id.re_guize);
        re_paihang = view.findViewById(R.id.re_paihang);
        re_renwu = view.findViewById(R.id.re_renwu);
        re_dating.setOnClickListener(this);
        re_guize.setOnClickListener(this);
        re_paihang.setOnClickListener(this);
        re_renwu.setOnClickListener(this);
        mPresenter = new HomePresenter(this);
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
    protected void requestData() {
        if (isViewVisible) {
            mPresenter.postBanner();
        }
    }


    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.re_dating:
                startActivity(TaskHallAty.class);
                break;
            case R.id.re_guize:
                startActivity(TaskRulesAty.class);
                break;
            case R.id.re_paihang:
                startActivity(RankingListAty.class);
                break;
            case R.id.re_renwu:
                if (Config.isLogin()){
                    startActivity(MyTaskAty.class);
                }else {
                    startActivity(LoginAty.class);
                }

                break;

        }
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("banner.html")) {
            BannerBean bannerBean = JSON.parseObject(jsonStr, BannerBean.class);
            List<BannerBean.DataBean> dataBeanList = bannerBean.getData();
            if (dataBeanList != null && dataBeanList.size() > 0) {
                for (BannerBean.DataBean bean : dataBeanList) {
                    images.add(ApiService.BASE_IMAGE + bean.getBanner_content());
                }
                //设置banner样式
                mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置图片加载器
                mBanner.setImageLoader(new BannerLoader());
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
        }
    }

    @Override
    public void onFailure(String msg) {
        super.onFailure(msg);
    }
}
