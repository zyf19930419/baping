package com.weibangbang.aty.home;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.aty.LoginAty;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.home.LaunchCommitBean;
import com.weibangbang.presenter.HomePresenter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 15:56
 * 功能描述：投放广告
 */
public class PutInAty extends BaseActivity implements View.OnClickListener {

    private TextView commit_tv;
    private EditText name_edit; // 姓名
    private EditText phone_edit; // 手机号
    private EditText guanggao_edit; // 广告描述
    private HomePresenter mHomePresenter;
    private TextView weixin_tv;

    @Override
    public int getLayoutId() {
        return R.layout.acvity_put_in;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.toufangguanggao), true);
        commit_tv = findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.tijiaotoufang);

        name_edit = findViewById(R.id.name_edit);
        phone_edit = findViewById(R.id.phone_edit);
        guanggao_edit = findViewById(R.id.guanggao_edit);
        weixin_tv=findViewById(R.id.weixin_tv);
        findViewById(R.id.commit_tv).setOnClickListener(this);

    }

    @Override
    public void initData() {
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.postAttract();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit_tv:
                if (!Config.isLogin()){
                    startActivity(LoginAty.class);
                    return;
                }
                String nameStr = name_edit.getText().toString();
                String phoneStr = phone_edit.getText().toString();
                String guanggaoStr = guanggao_edit.getText().toString();
                if (!TextUtils.isEmpty(nameStr) || !TextUtils.isEmpty(phoneStr) || !TextUtils.isEmpty(guanggaoStr)) {
                    submit(nameStr, phoneStr, guanggaoStr);
                } else {
                    showShortToast("请将信息输入完整", Toast.LENGTH_SHORT);
                }
                break;
        }
    }

    /**
     * 提交投放广告的信息
     *
     * @param name     姓名
     * @param phone    电话
     * @param guanggao 内容
     */
    private void submit(String name, String phone, String guanggao) {

        mHomePresenter.postLaunchCommit(Config.getToken(), guanggao, name, phone);
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Launch/launch_commit.html")) {
            LaunchCommitBean launchCommitBean = JSON.parseObject(jsonStr, LaunchCommitBean.class);
            showShortToast(launchCommitBean.getMsg(), Toast.LENGTH_SHORT);
            if (1 == launchCommitBean.getCode()) {
                finish();
            }
            return;
        }
        if (requestUrl.endsWith("index/attract.html")){
            try {
                JSONObject jsonObject=new JSONObject(jsonStr);
                JSONObject object=new JSONObject(jsonObject.optString("data"));
                weixin_tv.setText(object.has("advertising_business")?object.getString("advertising_business"):"");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    @Override
    public void onFailure(String msg) {
        super.onFailure(msg);
    }
}
