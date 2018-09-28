package com.weibangbang.aty.home;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.view.EditLayout;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:53
 * 功能描述：免费领佣
 */
public class FreeLeadAty extends BaseActivity{

    private EditLayout mEditLayout;
    @Override
    public int getLayoutId() {
        return R.layout.activity_free_lead;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.mianfeilingyong),true);

        mEditLayout=findViewById(R.id.edit_layout);
//        mEditLayout.setEditTextHint("666666666");
    }

    @Override
    public void initData() {

    }
}
