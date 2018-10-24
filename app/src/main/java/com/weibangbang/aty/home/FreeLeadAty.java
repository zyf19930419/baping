package com.weibangbang.aty.home;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.api.Config;
import com.weibangbang.aty.LoginAty;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.home.ReceiveInfoBean;
import com.weibangbang.presenter.HomePresenter;
import com.weibangbang.utils.GlideApp;
import com.weibangbang.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:53
 * 功能描述：免费领佣
 */
public class FreeLeadAty extends BaseActivity{

    private TextView commit_tv;
    private ImageView banner_img;

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
        banner_img=findViewById(R.id.banner_img);
    }

    @Override
    public void initData() {
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.postReceiveInfo(Config.getToken());
    }

    public void onCommit(View view) {
        if (!Config.isLogin()){
            startActivity(LoginAty.class);
            return;
        }
        String name = name_edit.getText().toString();
        String phone = phone_edit.getText().toString();
        String address = address_edit.getText().toString();
        mHomePresenter.postReceiveCommit(Config.getToken(),name,phone,address);
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Receive/receive_info.html")){
            ReceiveInfoBean receiveInfoBean = JSON.parseObject(jsonStr, ReceiveInfoBean.class);
            String receive_picture = ApiService.BASE_IMAGE+receiveInfoBean.getData().getReceive_picture();
            GlideApp.with(mContext).load(receive_picture).into(banner_img);
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

    @Override
    public void onFailure(String msg) {
        super.onFailure(msg);
    }
}
