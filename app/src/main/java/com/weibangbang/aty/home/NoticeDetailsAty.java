package com.weibangbang.aty.home;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.home.NoticeDetailsBean;
import com.weibangbang.presenter.HomePresenter;

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
                result = Html.fromHtml(data.getNotice_content(),Html.FROM_HTML_MODE_LEGACY);
            } else {
                result = Html.fromHtml(data.getNotice_content());
            }
                content_tv.setText(result);

        }
    }
}
