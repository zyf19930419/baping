package com.weibangbang.fgt;

import android.view.View;
import android.widget.RelativeLayout;

import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.aty.home.ContactCustomerAty;
import com.weibangbang.aty.home.FreeLeadAty;
import com.weibangbang.aty.home.MakeMoneyAty;
import com.weibangbang.aty.home.OpenMemberAty;
import com.weibangbang.aty.home.PutInAty;
import com.weibangbang.aty.home.ShareMoneyAty;
import com.weibangbang.base.BaseFragment;
import com.weibangbang.bean.home.BannerBean;
import com.weibangbang.bean.home.NoticeBean;
import com.weibangbang.presenter.WbbPresenter;
import com.weibangbang.utils.GlideImageLoader;
import com.weibangbang.utils.GsonUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 11:15
 * 功能描述：首页
 */
public class HomeMainFgt extends BaseFragment implements View.OnClickListener {

    private Banner mBanner;
    private List<String> images;
    private RelativeLayout re_zhuangyong, re_lingyong, re_huiyuan, re_toufang, re_haoyou, re_kefu;

    @Override
    protected int getLayoutResId() {
        return R.layout.fgt_home;
    }

    @Override
    protected void initialized(View view) {
        initView(view);
    }

    private void initView(View view) {
        re_zhuangyong = view.findViewById(R.id.re_zhuangyong);
        re_lingyong = view.findViewById(R.id.re_lingyong);
        re_huiyuan = view.findViewById(R.id.re_huiyuan);
        re_toufang = view.findViewById(R.id.re_toufang);
        re_haoyou = view.findViewById(R.id.re_haoyou);
        re_kefu = view.findViewById(R.id.re_kefu);
        images = new ArrayList<>();
        mBanner = view.findViewById(R.id.banner);
        re_zhuangyong.setOnClickListener(this);
        re_lingyong.setOnClickListener(this);
        re_huiyuan.setOnClickListener(this);
        re_toufang.setOnClickListener(this);
        re_haoyou.setOnClickListener(this);
        re_kefu.setOnClickListener(this);
    }

    @Override
    protected void requestData() {
        WbbPresenter presenter = new WbbPresenter(this);
        presenter.postBanner("1");
        presenter.postNotice();
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
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("banner.html")) {
            BannerBean bannerBean = GsonUtils.gsonToBean(jsonStr, BannerBean.class);
            List<BannerBean.DataBean> dataBeanList = bannerBean.getData();
            for (BannerBean.DataBean bean : dataBeanList) {
                images.add(ApiService.BASE_URL + bean.getBanner_content());
            }
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

        if (requestUrl.endsWith("notice.html")) {
            NoticeBean noticeBean = GsonUtils.gsonToBean(jsonStr, NoticeBean.class);
        }

    }


    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
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
                startActivity(ShareMoneyAty.class);
                break;
            case R.id.re_kefu:
                startActivity(ContactCustomerAty.class);
                //                if (DisplayHelper.hasApplication(getContext(), "com.tencent.mm")) {
                //                    DisplayHelper.getWechatApi(getContext(),"com.tencent.mm");
                //                } else {
                //                    Toast.makeText(getContext(), "请安装微信", Toast.LENGTH_LONG).show();
                //                }
                break;
        }
    }
}
