package com.weibangbang.fgt;

import android.view.View;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.api.Config;
import com.weibangbang.aty.LoginAty;
import com.weibangbang.aty.home.ContactCustomerAty;
import com.weibangbang.aty.home.FreeLeadAty;
import com.weibangbang.aty.home.MakeMoneyAty;
import com.weibangbang.aty.home.OpenMemberAty;
import com.weibangbang.aty.home.PutInAty;
import com.weibangbang.aty.home.ShareMoneyAty;
import com.weibangbang.base.BaseFragment;
import com.weibangbang.bean.home.BannerBean;
import com.weibangbang.presenter.HomePresenter;
import com.weibangbang.loader.BannerLoader;
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

//    private MyViewFlipper myViewFilpper;
//    private List<View> mViews;
    private HomePresenter mPresenter;

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
//        myViewFilpper = view.findViewById(R.id.myViewFilpper);
        images = new ArrayList<>();
        mBanner = view.findViewById(R.id.banner);
        re_zhuangyong.setOnClickListener(this);
        re_lingyong.setOnClickListener(this);
        re_huiyuan.setOnClickListener(this);
        re_toufang.setOnClickListener(this);
        re_haoyou.setOnClickListener(this);
        re_kefu.setOnClickListener(this);
        mPresenter = new HomePresenter(this);
    }

    @Override
    protected void requestData() {
        mPresenter.postBanner();
//        mPresenter.postNotice();
    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
//        myViewFilpper.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
//        myViewFilpper.stopFlipping();
//        myViewFilpper.removeAllViews();
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

//        if (requestUrl.endsWith("notice.html")) {
//            NoticeBean noticeBean = JSON.parseObject(jsonStr, NoticeBean.class);
//            final List<NoticeBean.DataBean> data = noticeBean.getData();
//            mViews = new ArrayList<>();
//            if (data != null && data.size() > 0) {
//                for (int i = 0; i < data.size(); i++) {
//                    //设置滚动的单个布局
//                    LinearLayout moreView = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.adv_item, null);
//                    //初始化布局的控件
//                    TextView title_tv = moreView.findViewById(R.id.title_tv);
//                    TextView content_tv = moreView.findViewById(R.id.content_tv);
//                    //进行对控件赋值
//                    title_tv.setText(data.get(i).getNotice_title());
//                    content_tv.setText(data.get(i).getNotice_brief());
//                    //添加到循环滚动数组里面去
//                    mViews.add(moreView);
//                }
//
//            }
//            myViewFilpper.setViews(mViews);
//            myViewFilpper.getCurrentView().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int notice_id = data.get(myViewFilpper.getDisplayedChild()).getNotice_id();
//                    Bundle bundle=new Bundle();
//                    bundle.putInt("notice_id",notice_id);
//                    startActivity(NoticeDetailsAty.class,bundle);
//                }
//            });
//        }

    }


    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.re_zhuangyong:
                if (Config.isLogin()) {
                    startActivity(MakeMoneyAty.class);
                } else {
                    startActivity(LoginAty.class);
                }
                break;
            case R.id.re_lingyong:
                if (Config.isLogin()) {
                    startActivity(FreeLeadAty.class);
                } else {
                    startActivity(LoginAty.class);
                }
                break;
            case R.id.re_huiyuan:
                if (Config.isLogin()) {
                    startActivity(OpenMemberAty.class);
                } else {
                    startActivity(LoginAty.class);
                }
                break;
            case R.id.re_toufang:
                if (Config.isLogin()) {
                    startActivity(PutInAty.class);
                } else {
                    startActivity(LoginAty.class);
                }
                break;
            case R.id.re_haoyou:
                if (Config.isLogin()) {
                    startActivity(ShareMoneyAty.class);
                } else {
                    startActivity(LoginAty.class);
                }
                break;
            case R.id.re_kefu:
                if (Config.isLogin()) {
                    startActivity(ContactCustomerAty.class);
                } else {
                    startActivity(LoginAty.class);
                }
                //                if (DisplayHelper.hasApplication(getContext(), "com.tencent.mm")) {
                //                    DisplayHelper.getWechatApi(getContext(),"com.tencent.mm");
                //                } else {
                //                    Toast.makeText(getContext(), "请安装微信", Toast.LENGTH_LONG).show();
                //                }
                break;
        }
    }
}
