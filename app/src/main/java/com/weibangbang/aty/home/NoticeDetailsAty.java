package com.weibangbang.aty.home;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.home.NoticeDetailsBean;
import com.weibangbang.presenter.HomePresenter;
import com.weibangbang.utils.GlideApp;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/10 15:29
 * 功能描述：公告详情
 */
public class NoticeDetailsAty extends BaseActivity {


    private HomePresenter mHomePresenter;
    private int mNotice_id;
    private TextView content_tv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_notice_details;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.notice_details), true);
        Bundle extras = getIntent().getExtras();
        mNotice_id = extras.getInt("notice_id");
        content_tv = findViewById(R.id.content_tv);
    }

    @Override
    public void initData() {
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.postNoticeDetails(String.valueOf(mNotice_id));
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Index/notice_details.html")) {
            NoticeDetailsBean noticeDetailsBean = JSON.parseObject(jsonStr, NoticeDetailsBean.class);
            NoticeDetailsBean.DataBean data = noticeDetailsBean.getData();
            Spanned result;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                result = Html.fromHtml(data.getNotice_content(), Html.FROM_HTML_MODE_LEGACY, imgGetter, null);
            } else {
                result = Html.fromHtml(data.getNotice_content(), imgGetter, null);
            }
            content_tv.setText(result);

        }
    }

    Html.ImageGetter imgGetter = new Html.ImageGetter() {
        public Drawable getDrawable(String source) {
            final LevelListDrawable drawable = new LevelListDrawable();
            GlideApp.with(NoticeDetailsAty.this).asBitmap().load(source).into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                    if(resource != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),resource);
                        drawable.addLevel(1, 1, bitmapDrawable);
                        drawable.setBounds(0, 0, resource.getWidth(), resource.getHeight());
                        drawable.setLevel(1);
                        content_tv.invalidate();
                        content_tv.setText(content_tv.getText());
                    }
                }
            });
            return drawable;
        }
    };
}
