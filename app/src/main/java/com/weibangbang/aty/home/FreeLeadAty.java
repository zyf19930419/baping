package com.weibangbang.aty.home;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.home.BannerBean;
import com.weibangbang.loader.BannerLoader;
import com.weibangbang.presenter.HomePresenter;
import com.weibangbang.utils.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.json.JSONException;
import org.json.JSONObject;

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

    private EditText name_edit,phone_edit,address_edit;
    private HomePresenter mHomePresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_free_lead;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.mianfeilingyong),true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.lijilingqu);
        name_edit=findViewById(R.id.name_edit);
        phone_edit=findViewById(R.id.phone_edit);
        address_edit=findViewById(R.id.address_edit);
    }

    @Override
    public void initData() {
        mHomePresenter = new HomePresenter(this);
    }

    public void onCommit(View view) {
        String name = name_edit.getText().toString();
        String phone = phone_edit.getText().toString();
        String address = address_edit.getText().toString();
        mHomePresenter.postBanner();
        mHomePresenter.postReceiveCommit(Config.getToken(),name,phone,address);
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
        if (requestUrl.endsWith("Receive/receive_commit.html")){
            try {
                JSONObject jsonObject=new JSONObject(jsonStr);
                String msg = jsonObject.getString("msg");
                ToastUtils.showToast(msg);
                finish();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
