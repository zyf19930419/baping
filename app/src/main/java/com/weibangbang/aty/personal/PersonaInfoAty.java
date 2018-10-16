package com.weibangbang.aty.personal;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.weibangbang.R;
import com.weibangbang.base.BaseActivity;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:34
 * 功能描述：个人资料
 */
public class PersonaInfoAty extends BaseActivity {
    private TextView commit_tv,img_hint_tv,man_tv,woman_tv;
    private EditText name_edit,age_edit,address_edit;
    private int sex=1;
    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.personal_info,true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenxiugai);
        img_hint_tv=findViewById(R.id.img_hint_tv);
        man_tv=findViewById(R.id.man_tv);
        woman_tv=findViewById(R.id.woman_tv);
        name_edit=findViewById(R.id.name_edit);
        age_edit=findViewById(R.id.age_edit);
        address_edit=findViewById(R.id.address_edit);
        setChoose(sex);
    }

    private void setChoose(int position){
        man_tv.setTextColor(ContextCompat.getColor(this,R.color.txt_color));
        man_tv.setBackgroundResource(R.drawable.edit_shape);
        woman_tv.setTextColor(ContextCompat.getColor(this,R.color.txt_color));
        woman_tv.setBackgroundResource(R.drawable.edit_shape);
        if (position==1){
            man_tv.setTextColor(ContextCompat.getColor(this,R.color.bar_color));
            man_tv.setBackgroundResource(R.drawable.yellow_shape);
        }else if (position==2){
            woman_tv.setTextColor(ContextCompat.getColor(this,R.color.bar_color));
            woman_tv.setBackgroundResource(R.drawable.yellow_shape);
        }
    }

    @Override
    public void initData() {

    }

    public void onMan(View view) {
        sex=1;
        setChoose(sex);
    }

    public void onWoman(View view) {
        sex=2;
        setChoose(sex);
    }

    /**
     * 头像选择
     */
    public void onChooseHead(View view) {
    }

    public void onCommit(View view) {
    }
}
