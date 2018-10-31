package com.weibangbang.aty;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.aty.home.NoticeAty;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.common.ActivityStack;
import com.weibangbang.fgt.HomeMainFgt;
import com.weibangbang.fgt.MemberMainFgt;
import com.weibangbang.fgt.PersonalMainFgt;
import com.weibangbang.utils.NotificationsUtils;
import com.weibangbang.utils.PermissionHelper;

;

public class MainActivity extends BaseActivity {
    private long firstTime = 0;
    private TextView txt_title;
    private Fragment[] mFragments;
    private HomeMainFgt mHomeMainFgt;
    private MemberMainFgt mMemberMainFgt;
    private PersonalMainFgt mPersonalMainFgt;
    private ImageView[] imagebuttons;
    private TextView[] textviews;
    private int index=0;
    private int redColor, txtColor;
    private int currentTabIndex=0;

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

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    @Override
    public void initView() {
        //申请权限
        requestSomePermission();
        checkNotification();
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
        mHomeMainFgt = new HomeMainFgt();
        mMemberMainFgt = new MemberMainFgt();
        mPersonalMainFgt = new PersonalMainFgt();

        mFragments = new Fragment[]{mHomeMainFgt, mMemberMainFgt, mPersonalMainFgt};

        transaction.add(R.id.fragment_container, mHomeMainFgt, "mHomeMainFgt");
        transaction.add(R.id.fragment_container, mMemberMainFgt, "mMemberMainFgt");
        transaction.add(R.id.fragment_container, mPersonalMainFgt, "mPersonalMainFgt");
        transaction.hide(mMemberMainFgt);
        transaction.hide(mPersonalMainFgt);
        transaction.show(mHomeMainFgt);
        transaction.commit();
        switchTo(index);
    }


    private void checkNotification(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT&&Build.VERSION.SDK_INT<Build.VERSION_CODES.O) {
            if (!NotificationsUtils.isNotificationEnabled(this)) {
                notificationDialog();
            }
        }else if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            if (!NotificationsUtils.isEnableV26(this,getPackageName(),android.os.Process.myUid())){
                notificationDialog();
            }

        }

    }

    private void notificationDialog() {
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("该应用需要打开通知权限");

        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, " 去设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Intent localIntent = new Intent();
                localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (Build.VERSION.SDK_INT >= 9) {
                    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    localIntent.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                } else if (Build.VERSION.SDK_INT <= 8) {
                    localIntent.setAction(Intent.ACTION_VIEW);

                    localIntent.setClassName("com.android.settings",
                            "com.android.settings.InstalledAppDetails");

                    localIntent.putExtra("com.android.settings.ApplicationPkgName",
                            MainActivity.this.getPackageName());
                }
                startActivity(localIntent);
            }
        });
        dialog.show();
    }

    private void switchTo(int position) {
        if (currentTabIndex != position) {
            FragmentTransaction trx = getFragmentManager()
                    .beginTransaction();
            trx.hide(mFragments[currentTabIndex]);
            if (!mFragments[position].isAdded()) {
                trx.add(R.id.fragment_container, mFragments[position]);
            }
            trx.show(mFragments[position]).commit();
            imagebuttons[currentTabIndex].setSelected(false);
            textviews[currentTabIndex].setTextColor(txtColor);
            currentTabIndex = position;
        }
        imagebuttons[position].setSelected(true);
        textviews[position].setTextColor(redColor);
    }

    private void requestSomePermission() {
        if (!PermissionHelper.hasSelfPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE)) {
            PermissionHelper.requestPermissions(this, 100, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE}, new PermissionHelper.OnPermissionListener() {
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
                switchTo(index);
                break;
            case R.id.re_member:
                index = 1;
                txt_title.setText("会员中心");
                switchTo(index);
                break;
            case R.id.re_personal:
                if (Config.isLogin()){
                    index = 2;
                    txt_title.setText("个人中心");
                    switchTo(index);
                }else {
                    startActivity(LoginAty.class);
                }
                break;
        }

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

    /**
     * 首页公告栏点击事件
     */
    public void onAdvClick(View view) {
        startActivity(NoticeAty.class);
    }
}
