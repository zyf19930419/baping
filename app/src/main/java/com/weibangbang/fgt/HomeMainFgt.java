package com.weibangbang.fgt;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

;
import com.google.gson.Gson;
import com.weibangbang.R;
import com.weibangbang.aty.home.FreeLeadAty;
import com.weibangbang.aty.home.ShareMoneyAty;
import com.weibangbang.aty.home.MakeMoneyAty;
import com.weibangbang.aty.home.OpenMemberAty;
import com.weibangbang.aty.home.PutInAty;
import com.weibangbang.base.BaseFragment;
import com.weibangbang.bean.BannerBean;
import com.weibangbang.presenter.WbbPresenter;
import com.weibangbang.utils.DisplayHelper;
import com.weibangbang.utils.GlideImageLoader;
import com.weibangbang.utils.GsonUtils;
import com.weibangbang.utils.RetrofitUtils;
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
public class HomeMainFgt extends BaseFragment implements View.OnClickListener {

    private Banner mBanner;
    private List<String> images;
    private RelativeLayout re_zhuangyong, re_lingyong, re_huiyuan, re_toufang, re_haoyou, re_kefu;
    private WbbPresenter mPresenter;

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
        re_zhuangyong = view.findViewById(R.id.re_zhuangyong);
        re_lingyong = view.findViewById(R.id.re_lingyong);
        re_huiyuan = view.findViewById(R.id.re_huiyuan);
        re_toufang = view.findViewById(R.id.re_toufang);
        re_haoyou = view.findViewById(R.id.re_haoyou);
        re_kefu = view.findViewById(R.id.re_kefu);
        re_zhuangyong.setOnClickListener(this);
        re_lingyong.setOnClickListener(this);
        re_huiyuan.setOnClickListener(this);
        re_toufang.setOnClickListener(this);
        re_haoyou.setOnClickListener(this);
        re_kefu.setOnClickListener(this);
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
        mPresenter=new WbbPresenter(this);
        mPresenter.postBanner("1");
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
                if (DisplayHelper.hasApplication(getContext(), "com.tencent.mm")) {
                    DisplayHelper.getWechatApi(getContext(),"com.tencent.mm");
                } else {
                    Toast.makeText(getContext(), "请安装微信", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    @Override
    public void onComplete(String requestUrl, Object object) {
        String jsonStr = GsonUtils.getGson().toJson(object);
        BannerBean bannerBean = GsonUtils.gsonToBean(jsonStr, BannerBean.class);
        List<BannerBean.DataBean> data = bannerBean.getData();
        Log.e("TAG", "onComplete: "+data.toString() );
    }

    @Override
    public void onFaile(String requestUrl, String msg) {

    }

}
