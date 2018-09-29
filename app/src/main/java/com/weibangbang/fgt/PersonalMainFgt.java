package com.weibangbang.fgt;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weibangbang.R;
import com.weibangbang.aty.personal.ChangePasswordAty;
import com.weibangbang.aty.personal.MineTeamAty;
import com.weibangbang.aty.personal.MineWalletAty;
import com.weibangbang.aty.personal.PersonaInfoAty;
import com.weibangbang.base.BaseFragment;
import com.weibangbang.utils.BitmapUtils;
import com.weibangbang.utils.GlideApp;

;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/25 11:16
 * 功能描述：个人中心
 */
public class PersonalMainFgt extends BaseFragment implements View.OnClickListener {
    private ImageView head_img;
    private TextView personal_info_tv, mine_team_tv, wallet_tv, put_forward_tv, change_password_tv, commit_tv;

    @Override
    protected int getLayoutResId() {
        return R.layout.fgt_personal;
    }

    @Override
    protected void initialized(View view) {
        head_img = view.findViewById(R.id.head_img);
        personal_info_tv = view.findViewById(R.id.personal_info_tv);
        personal_info_tv.setOnClickListener(this);
        mine_team_tv = view.findViewById(R.id.mine_team_tv);
        mine_team_tv.setOnClickListener(this);
        wallet_tv = view.findViewById(R.id.wallet_tv);
        wallet_tv.setOnClickListener(this);
        put_forward_tv = view.findViewById(R.id.put_forward_tv);
        put_forward_tv.setOnClickListener(this);
        change_password_tv = view.findViewById(R.id.change_password_tv);
        change_password_tv.setOnClickListener(this);
        commit_tv = view.findViewById(R.id.commit_tv);
        commit_tv.setOnClickListener(this);
        commit_tv.setText(R.string.login_out);
        final String url="https://i8.mifile.cn/b2c-mimall-media/2a6cffab13db95ec8f3204ca0bef5d2a.png";
        GlideApp.with(getContext()).load(url).circleCrop().into(head_img);

        head_img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                BitmapUtils.gainInstance().savePic(getContext(), url, System.currentTimeMillis() + "", new BitmapUtils.Listener() {
                    @Override
                    public void saveSuccess() {
                        Toast.makeText(getContext(), "onLongClick", Toast.LENGTH_SHORT).show();
                    }
                });
                return false;
            }
        });

    }

    @Override
    protected void requestData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personal_info_tv:
                startActivity(PersonaInfoAty.class);
                break;
            case R.id.mine_team_tv:
                startActivity(MineTeamAty.class);
                break;
            case R.id.wallet_tv:
                startActivity(MineWalletAty.class);
                break;
            case R.id.put_forward_tv:
                startActivity(MineWalletAty.class);
                break;
            case R.id.change_password_tv:
                startActivity(ChangePasswordAty.class);
                break;
            case R.id.commit_tv:
                break;
            default:
                break;
        }
    }
}
