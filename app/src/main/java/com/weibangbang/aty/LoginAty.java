package com.weibangbang.aty;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:34
 * 功能描述：登录页面
 */
public class LoginAty extends BaseActivity implements View.OnClickListener {

    private LinearLayout login_phone_layout; // 手机号
    private LinearLayout login_pwd_layout; // 第一个密码：新密码、注册密码、登录密码
    private LinearLayout login_pwdAgain_layout; // 确认密码
    private LinearLayout login_verificationCode_layout; // 验证码
    private EditText login_phone_et; // 手机号输入框
    private EditText login_pwd_et; // 第一个密码输入框：新密码、注册密码、登录密码
    private EditText login_pwdAgain_et; // 确认密码输入框
    private EditText login_verificationCode_et; // 验证码
    private TextView login_getVerification_tv; // 获取验证码
    private TextView login_submit_tv; // 提交按钮：登录、确认修改、注册提交
    private TextView login_registerOrLogin_tv; // 注册或登录提示
    private TextView login_register_tv; // 立即注册
    private TextView login_forget_tv; // 忘记密码

    private int loginType = 0; // 登录类型：0登录；1注册；2修改密码

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        login_phone_layout = findViewById(R.id.login_phone_layout);
        login_pwd_layout = findViewById(R.id.login_pwd_layout);
        login_pwdAgain_layout = findViewById(R.id.login_pwdAgain_layout);
        login_verificationCode_layout = findViewById(R.id.login_verificationCode_layout);
        login_phone_et = findViewById(R.id.login_phone_et);
        login_pwd_et = findViewById(R.id.login_pwd_et);
        login_pwdAgain_et = findViewById(R.id.login_pwdAgain_et);
        login_verificationCode_et = findViewById(R.id.login_verificationCode_et);
        login_getVerification_tv = findViewById(R.id.login_getVerification_tv);
        login_submit_tv = findViewById(R.id.login_submit_tv);
        login_registerOrLogin_tv = findViewById(R.id.login_registerOrLogin_tv);
        login_register_tv = findViewById(R.id.login_register_tv);
        login_forget_tv = findViewById(R.id.login_forget_tv);

        login_getVerification_tv.setOnClickListener(this);
        login_submit_tv.setOnClickListener(this);
        login_register_tv.setOnClickListener(this);
        login_forget_tv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            loginType = intent.getIntExtra("loginType", 0);
        }
        changeViewVisibility(loginType);
    }

    /**
     * 设置登录界面的显示控件
     *
     * @param loginType
     */
    private void changeViewVisibility(int loginType) {
        switch (loginType) {
            case 0: // 登录：只显示手机号和密码
                login_phone_layout.setVisibility(View.VISIBLE);
                login_pwd_layout.setVisibility(View.VISIBLE);
                login_pwdAgain_layout.setVisibility(View.GONE);
                login_verificationCode_layout.setVisibility(View.GONE);
                login_submit_tv.setText(R.string.login);
                login_forget_tv.setVisibility(View.VISIBLE);
                break;
            case 1: // 注册：全部显示，将按钮修改为注册
                login_phone_layout.setVisibility(View.VISIBLE);
                login_pwd_layout.setVisibility(View.VISIBLE);
                login_pwdAgain_layout.setVisibility(View.VISIBLE);
                login_verificationCode_layout.setVisibility(View.VISIBLE);
                login_submit_tv.setText(R.string.register);
                login_forget_tv.setVisibility(View.VISIBLE);
                break;
            case 2: // 修改密码：全部显示，将按钮设置为确认修改，将第一个密码框的提示语修改为新密码，隐藏忘记密码
                login_phone_layout.setVisibility(View.VISIBLE);
                login_pwd_layout.setVisibility(View.VISIBLE);
                login_pwdAgain_layout.setVisibility(View.VISIBLE);
                login_verificationCode_layout.setVisibility(View.VISIBLE);
                login_pwd_et.setHint(R.string.new_password);
                login_submit_tv.setText(R.string.submit_updata);
                login_forget_tv.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_getVerification_tv: // 获取验证码
                login_getVerification_tv.setClickable(false);
                login_getVerification_tv.setTextColor(getResources().getColor(R.color.txt_color));
                new CountDownTimer(60 * 1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        login_getVerification_tv.setText((l / 1000) + "秒");
                    }

                    @Override
                    public void onFinish() {
                        login_getVerification_tv.setText(R.string.get);
                        login_getVerification_tv.setTextColor(getResources().getColor(R.color.colorPrimary));
                        login_getVerification_tv.setClickable(true);
                    }
                }.start();
                showShortToast(R.string.verification_code_sending, Toast.LENGTH_SHORT);
                break;
            case R.id.login_submit_tv: // 登录、注册、修改密码
                break;
            case R.id.login_register_tv: // 立即注册、立即登录
                if (loginType == 0) { // 登录状态的时候
                    loginType = 1;
                    login_registerOrLogin_tv.setText(R.string.have_account);
                    login_register_tv.setText(R.string.login_now);
                } else {
                    loginType = 0;
                    login_registerOrLogin_tv.setText(R.string.no_account);
                    login_register_tv.setText(R.string.register_now);
                }
                changeViewVisibility(loginType);
                break;
            case R.id.login_forget_tv: // 忘记密码
                changeViewVisibility(2);
                break;
        }
    }
}
