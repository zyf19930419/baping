package com.weibangbang.fgt;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.api.Config;
import com.weibangbang.aty.MainActivity;
import com.weibangbang.aty.personal.ChangePasswordAty;
import com.weibangbang.aty.personal.MineTeamAty;
import com.weibangbang.aty.personal.MineWalletAty;
import com.weibangbang.aty.personal.PersonaInfoAty;
import com.weibangbang.aty.personal.WithdrawMoneyAty;
import com.weibangbang.base.BaseFragment;
import com.weibangbang.bean.personal.InformationDisplayBean;
import com.weibangbang.bean.personal.PersonalPageBean;
import com.weibangbang.common.ActivityStack;
import com.weibangbang.presenter.PersonalPresenter;
import com.weibangbang.utils.BitmapUtils;
import com.weibangbang.utils.GlideApp;
import com.weibangbang.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 11:16
 * 功能描述：个人中心
 */
public class PersonalMainFgt extends BaseFragment implements View.OnClickListener {
    private ImageView head_img;
    private TextView personal_info_tv, mine_team_tv, wallet_tv, put_forward_tv, change_password_tv, commit_tv;
    private TextView personal_totalRevenue_tv, personal_todayRevenue_tv, personal_withdraw_tv; // 总收入，今日收入，已提现
    private PersonalPresenter mPersonalPresenter;
    private InformationDisplayBean.DataBean mData;

    @Override
    protected int getLayoutResId() {
        return R.layout.fgt_personal;
    }


    @Override
    protected void initialized(View view) {
        head_img = view.findViewById(R.id.head_img);
        personal_totalRevenue_tv = view.findViewById(R.id.personal_totalRevenue_tv); // 总收入
        personal_todayRevenue_tv = view.findViewById(R.id.personal_todayRevenue_tv); // 今日收入
        personal_withdraw_tv = view.findViewById(R.id.personal_withdraw_tv); // 已提现
        personal_info_tv = view.findViewById(R.id.personal_info_tv);
        personal_info_tv.setOnClickListener(this);
        mine_team_tv = view.findViewById(R.id.mine_team_tv);
        mine_team_tv.setOnClickListener(this);
        wallet_tv = view.findViewById(R.id.mine_wallet_tv);
        wallet_tv.setOnClickListener(this);
        put_forward_tv = view.findViewById(R.id.put_forward_tv);
        put_forward_tv.setOnClickListener(this);
        change_password_tv = view.findViewById(R.id.change_password_tv);
        change_password_tv.setOnClickListener(this);
        commit_tv = view.findViewById(R.id.commit_tv);
        commit_tv.setOnClickListener(this);
        commit_tv.setText(R.string.login_out);
    }

    @Override
    protected void requestData() {
        mPersonalPresenter=new PersonalPresenter(this);
        mPersonalPresenter.postPersonalPage(Config.getToken());
        mPersonalPresenter.postInformationDisplay(Config.getToken());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personal_info_tv:
                if (null!=mData){
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("personalInfo",mData);
                    startActivity(PersonaInfoAty.class,bundle);
                }

                break;
            case R.id.mine_team_tv:
                startActivity(MineTeamAty.class);
                break;
            case R.id.mine_wallet_tv:
                startActivity(MineWalletAty.class);
                break;
            case R.id.put_forward_tv:
                startActivity(WithdrawMoneyAty.class);
                break;
            case R.id.change_password_tv:
                startActivity(ChangePasswordAty.class);
                break;
            case R.id.commit_tv:
                mPersonalPresenter.postLoginOut(Config.getToken());
                break;
            default:
                break;
        }
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("User/Personal_page.html")){
            PersonalPageBean personalPageBean = JSON.parseObject(jsonStr, PersonalPageBean.class);
            PersonalPageBean.DataBean data = personalPageBean.getData();
            personal_totalRevenue_tv.setText(data.getSum_brokerage()); // 总收入
            personal_todayRevenue_tv.setText(data.getToday_brokerage()); // 今日收入
            personal_withdraw_tv.setText(data.getSum_extract()); // 已提现
        }

        if (requestUrl.endsWith("User/information_display.html")){
            InformationDisplayBean informationDisplayBean = JSON.parseObject(jsonStr, InformationDisplayBean.class);
            mData = informationDisplayBean.getData();
            final String img_url=ApiService.BASE_IMAGE+ mData.getUser_portrait();
            GlideApp.with(getContext()).load(img_url).circleCrop().into(head_img);
            head_img.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    BitmapUtils.gainInstance().savePic(getContext(), img_url, System.currentTimeMillis() + "", new BitmapUtils.Listener() {
                        @Override
                        public void saveSuccess() {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getContext(), "图片保存成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    return false;
                }
            });
        }

        if (requestUrl.endsWith("User/login_out.html")){
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                if (jsonObject.has("msg")) {
                    String requestMsg = jsonObject.getString("msg");
                    Toast.makeText(getActivity(), requestMsg, Toast.LENGTH_SHORT).show();
                    Config.setToken("");
                    startActivity(MainActivity.class);
                    ActivityStack.getInstance().finishAllActivity();
                }
            } catch (JSONException e) {
                ToastUtils.showToast("回传数据异常");
            }
        }
    }

}
