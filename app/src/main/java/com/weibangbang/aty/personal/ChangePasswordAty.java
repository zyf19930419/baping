package com.weibangbang.aty.personal;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.presenter.PersonalPresenter;
import com.weibangbang.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:35
 * 功能描述：修改密码
 */
public class ChangePasswordAty extends BaseActivity {
    private TextView commit_tv;
    private EditText old_edit,new_edit,confirm_edit;
    private PersonalPresenter mPersonalPresenter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.change_password,true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenxiugai);

        old_edit=findViewById(R.id.old_edit);
        new_edit=findViewById(R.id.new_edit);
        confirm_edit=findViewById(R.id.confirm_edit);
    }

    @Override
    public void initData() {
        mPersonalPresenter = new PersonalPresenter(this);
    }

    public void onCommit(View view) {
        String old_pass = old_edit.getText().toString();
        String new_pass = new_edit.getText().toString();
        String confirm_pass = confirm_edit.getText().toString();
        if (old_pass.equals(new_pass)){
            ToastUtils.showToast("新密码不能与旧密码相同");
            return;
        }
        if (!new_pass.equals(confirm_pass)){
            ToastUtils.showToast("新密码必须和确认密码相同");
            return;
        }
        mPersonalPresenter.postChangePassword(Config.getToken(),old_pass,new_pass);
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("User/change_password.html")){
            try {
                JSONObject jsonObject=new JSONObject(jsonStr);
                String msg = jsonObject.has("msg") ? jsonObject.getString("msg") : "";
                ToastUtils.showToast(msg);
                finish();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
