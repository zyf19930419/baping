package com.weibangbang.base;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.view.CropImageView;
import com.weibangbang.R;
import com.weibangbang.broadcast.NetBroadcastReceiver;
import com.weibangbang.broadcast.NetEvent;
import com.weibangbang.common.ActivityStack;
import com.weibangbang.loader.ImagePickerLoader;
import com.weibangbang.utils.DenisityUtils;
import com.weibangbang.utils.LogUtils;
import com.weibangbang.utils.NetWorkUtils;
import com.weibangbang.utils.PermissionHelper;
import com.weibangbang.utils.StatusBarHelper;
import com.weibangbang.utils.ToastUtils;
import com.weibangbang.view.CommonDialog;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/18 14:10
 * 功能描述：
 */
public abstract class BaseActivity extends AppCompatActivity implements NetEvent, com.weibangbang.base.BaseView {

    private FrameLayout content;
    public TextView rootText;
    protected Context mContext;

    /**
     * 网络类型
     */
    private int netMobile;
    private NetBroadcastReceiver mNetBroadcastReceiver;
    public static NetEvent mEvent;

    private BaseApplication mApplication;

    /**
     * 是否使用沉浸式,如果不使用，需在
     * super.onCreate(savedInstanceState)之前设置为flase
     * 默认设置
     */
    public boolean changeStatusBar = true;
    private boolean isConfigChange = false;
    private CommonDialog mDialog;

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        mApplication = BaseApplication.getApplication();
        DenisityUtils.setCustomDensity(this, mApplication);
        inspectNet();
        mEvent = this;
        isConfigChange = false;
        ActivityStack.getInstance().addActivity(this);
        if (changeStatusBar) {
            StatusBarHelper.translucent(this);
            StatusBarHelper.setStatusBarLightMode(this);
        }
        setContentView(R.layout.activity_base);
        //初始化控件
        initControls();
        initView();
    }


    private void initControls() {
        content = findViewById(R.id.content);
        rootText = new TextView(this);
        rootText.setTextSize(20);
        rootText.setTextColor(ContextCompat.getColor( this,R.color.txt_black));
        View view = View.inflate(this, getLayoutId(), null);
        content.addView(view);
        content.addView(rootText);
        if (LogUtils.isDebug) {
            rootText.setText(getClass().getName());
        } else {
            rootText.setVisibility(View.GONE);
        }
    }

    protected void showNetErrorTip() {
        ToastUtils.showToastWithImg(getText(R.string.no_net).toString(), R.mipmap.ic_wifi_off);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isNetConnect()) {
            initData();
        } else {
            showNetErrorTip();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNetBroadcastReceiver = new NetBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mNetBroadcastReceiver);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange = true;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!isConfigChange) {
            ActivityStack.getInstance().finishActivity();
        }
    }

    /**
     * 初始化时判断有没有网络
     */

    public boolean inspectNet() {
        this.netMobile = NetWorkUtils.getNetWorkState(BaseActivity.this);
        return isNetConnect();

        // if (netMobile == 1) {
        // System.out.println("inspectNet：连接wifi");
        // } else if (netMobile == 0) {
        // System.out.println("inspectNet:连接移动数据");
        // } else if (netMobile == -1) {
        // System.out.println("inspectNet:当前没有网络");
        //
        // }
    }

    /**
     * 判断有无网络 。
     *
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        } else if (netMobile == 0) {
            return true;
        } else if (netMobile == -1) {
            return false;

        }
        return false;
    }

    @Override
    public void onNetChange(int netMobile) {
        this.netMobile = netMobile;
    }


    @Override
    public void showLoading(String title) {
    }

    @Override
    public void stopLoading() {
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {

    }

    @Override
    public void onFailure(String msg) {

    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showShortToast(String text, int gravity) {
        ToastUtils.showShort(text, gravity);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showShortToast(int resId, int gravity) {
        ToastUtils.showShort(resId, gravity);
    }

    public void showToastWithImg(String text, int res) {
        ToastUtils.showToastWithImg(text, res);
    }


    public void onBeBack(View view) {
        finish();
    }

    public void setTitleBar(String title, boolean isShowBack) {
        TextView txt_title = findViewById(R.id.txt_title);
        txt_title.setText(title);
        if (isShowBack) {
            ImageView back_img = findViewById(R.id.back_img);
            back_img.setVisibility(View.VISIBLE);
        }
    }

    public void setTitleBar(int resourceId, boolean isShowBack) {
        TextView txt_title = findViewById(R.id.txt_title);
        txt_title.setText(getResources().getString(resourceId));
        if (isShowBack) {
            ImageView back_img = findViewById(R.id.back_img);
            back_img.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 复制字符串内容
     *
     * @param contentStr
     */
    public void copyText(String contentStr) {
        if (!contentStr.isEmpty()) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("simple text", contentStr);
            clipboardManager.setPrimaryClip(clipData);
            ToastUtils.showToast("复制成功");
        } else {
            ToastUtils.showToast("复制失败，内容为空");
        }
    }


    public void setImagePicker(){
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setMultiMode(false);
        imagePicker.setImageLoader(new ImagePickerLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(false);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(9);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }
}
