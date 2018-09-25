package com.bapingtianxia.baping.aty;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bapingtianxia.baping.R;
import com.bapingtianxia.baping.base.BaseActivity;
import com.bapingtianxia.baping.common.ActivityStack;
import com.bapingtianxia.baping.fgt.HomeMainFgt;
import com.bapingtianxia.baping.fgt.MemberMainFgt;
import com.bapingtianxia.baping.fgt.PersonalMainFgt;
import com.bapingtianxia.baping.utils.LogUtils;

public class MainActivity extends BaseActivity {
    private long firstTime=0;
    private TextView txt_title;
    private Fragment[] mFragments;
    private HomeMainFgt mHomeMainFgt;
    private MemberMainFgt mMemberMainFgt;
    private PersonalMainFgt mPersonalMainFgt;
    private ImageView[] imagebuttons;
    private TextView[] textviews;
    private int index;
    private int currentTabIndex;// 当前fragment的index
    private int redColor,txtColor;

    /**
     * 入口
     * @param activity
     */
    public static void startAction(Activity activity){
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
    public void initView() {
        redColor= ContextCompat.getColor(this,R.color.bar_color);
        txtColor=ContextCompat.getColor(this,R.color.txt_color);
        txt_title = findViewById(R.id.txt_title);
        mHomeMainFgt=new HomeMainFgt();
        mMemberMainFgt=new MemberMainFgt();
        mPersonalMainFgt=new PersonalMainFgt();
        mFragments=new Fragment[]{mHomeMainFgt,mMemberMainFgt,mPersonalMainFgt};
        imagebuttons=new ImageView[3];
        imagebuttons[0]=findViewById(R.id.ib_home);
        imagebuttons[1]=findViewById(R.id.ib_member);
        imagebuttons[2]=findViewById(R.id.ib_personal);
        imagebuttons[0].setSelected(true);
        textviews=new TextView[3];
        textviews[0]=findViewById(R.id.tv_home);
        textviews[1]=findViewById(R.id.tv_member);
        textviews[2]=findViewById(R.id.tv_personal);
        textviews[0].setTextColor(redColor);

        // 添加显示第一个fragment
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mHomeMainFgt)
                .add(R.id.fragment_container, mMemberMainFgt)
                .add(R.id.fragment_container, mPersonalMainFgt)
                .hide(mMemberMainFgt)
                .hide(mPersonalMainFgt).show(mHomeMainFgt).commit();

    }

    @Override
    public void initData() {

    }

    public void onTabClicked(View view) {
        int viewId = view.getId();
        switch (viewId){
            case R.id.re_home:
                index=0;
                txt_title.setText(getResources().getString(R.string.app_name));
                break;
            case R.id.re_member:
                index=1;
                txt_title.setText("会员中心");
                break;
            case R.id.re_personal:
                index=2;
                txt_title.setText("个人中心");
                break;
        }

        if (currentTabIndex != index) {
            FragmentTransaction trx = getFragmentManager()
                    .beginTransaction();
            trx.hide(mFragments[currentTabIndex]);
            if (!mFragments[index].isAdded()) {
                trx.add(R.id.fragment_container, mFragments[index]);
            }
            trx.show(mFragments[index]).commit();
        }
        imagebuttons[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        imagebuttons[index].setSelected(true);
        textviews[currentTabIndex].setTextColor(txtColor);
        textviews[index].setTextColor(redColor);
        currentTabIndex = index;

    }








    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
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
