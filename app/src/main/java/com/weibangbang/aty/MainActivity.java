package com.weibangbang.aty;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

;
import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.common.ActivityStack;
import com.weibangbang.fgt.HomeMainFgt;
import com.weibangbang.fgt.MemberMainFgt;
import com.weibangbang.fgt.PersonalMainFgt;
import com.weibangbang.utils.PermissionHelper;

public class MainActivity extends BaseActivity {
    private long firstTime = 0;
    private TextView txt_title;
    private Fragment[] mFragments;
    private HomeMainFgt mHomeMainFgt;
    private MemberMainFgt mMemberMainFgt;
    private PersonalMainFgt mPersonalMainFgt;
    private ImageView[] imagebuttons;
    private TextView[] textviews;
    private int index;
    private int redColor, txtColor;

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //申请权限
        requestSomePermission();
        redColor = ContextCompat.getColor(this, R.color.bar_color);
        txtColor = ContextCompat.getColor(this, R.color.txt_color);
        txt_title = findViewById(R.id.txt_title);

        imagebuttons = new ImageView[3];
        imagebuttons[0] = findViewById(R.id.ib_home);
        imagebuttons[1] = findViewById(R.id.ib_member);
        imagebuttons[2] = findViewById(R.id.ib_personal);
        textviews = new TextView[3];
        textviews[0] = findViewById(R.id.tv_home);
        textviews[1] = findViewById(R.id.tv_member);
        textviews[2] = findViewById(R.id.tv_personal);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        index = 0;
        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index");
        } else {
            mHomeMainFgt = new HomeMainFgt();
            mMemberMainFgt = new MemberMainFgt();
            mPersonalMainFgt = new PersonalMainFgt();

            mFragments = new Fragment[]{mHomeMainFgt, mMemberMainFgt, mPersonalMainFgt};

            transaction.add(R.id.fragment_container, mHomeMainFgt, "mHomeMainFgt");
            transaction.add(R.id.fragment_container, mMemberMainFgt, "mMemberMainFgt");
            transaction.add(R.id.fragment_container, mPersonalMainFgt, "mPersonalMainFgt");
        }
        transaction.commit();
        switchTo(index);
    }

    private void switchTo(int position) {
        imagebuttons[0].setSelected(false);
        imagebuttons[1].setSelected(false);
        imagebuttons[2].setSelected(false);
        textviews[0].setTextColor(txtColor);
        textviews[1].setTextColor(txtColor);
        textviews[2].setTextColor(txtColor);
        imagebuttons[position].setSelected(true);
        textviews[position].setTextColor(redColor);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (position) {
            //首页
            case 0:
                transaction.hide(mMemberMainFgt);
                transaction.hide(mPersonalMainFgt);
                transaction.show(mHomeMainFgt);
                transaction.commitAllowingStateLoss();
                break;
            //会员中心
            case 1:
                transaction.hide(mHomeMainFgt);
                transaction.hide(mPersonalMainFgt);
                transaction.show(mMemberMainFgt);
                transaction.commitAllowingStateLoss();
                break;
            //个人中心
            case 2:
                transaction.hide(mHomeMainFgt);
                transaction.hide(mMemberMainFgt);
                transaction.show(mPersonalMainFgt);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
    }

    @Override
    public void initView() {
    }

    private void requestSomePermission() {
        if (!PermissionHelper.hasSelfPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            PermissionHelper.requestPermissions(this, 100, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionHelper.OnPermissionListener() {
                @Override
                public void onPermissionGranted() {

                }

                @Override
                public void onPermissionDenied() {
                    PermissionHelper.showTipsDialog(MainActivity.this);
                }
            });
        }
    }

    @Override
    public void initData() {

    }

    public void onTabClicked(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.re_home:
                index = 0;
                txt_title.setText(getResources().getString(R.string.app_name));
                break;
            case R.id.re_member:
                index = 1;
                txt_title.setText("会员中心");
                break;
            case R.id.re_personal:
                index = 2;
                txt_title.setText("个人中心");
                break;
        }
        switchTo(index);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (System.currentTimeMillis() - firstTime < 1500) {
            ActivityStack.getInstance().appExit();
        } else {
            firstTime = System.currentTimeMillis();
            showShortToast("再按一次返回桌面", Gravity.CENTER);
        }
    }

}
