package com.weibangbang.aty.personal;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.weibangbang.R;
import com.weibangbang.api.ApiService;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.personal.InformationDisplayBean;
import com.weibangbang.bean.personal.UpLoadBean;
import com.weibangbang.presenter.PersonalPresenter;
import com.weibangbang.utils.GlideApp;
import com.weibangbang.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/29 9:34
 * 功能描述：个人资料
 */
public class PersonaInfoAty extends BaseActivity {
    private TextView commit_tv,img_hint_tv,man_tv,woman_tv;
    private ImageView head_img;
    private EditText name_edit,age_edit,address_edit;
    private int sex=1;
    private PersonalPresenter mPersonalPresenter;
    public static  final int IMAGE_PICKER=100;
    private InformationDisplayBean.DataBean mData;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info;
    }

    @Override
    public void initView() {
        setTitleBar(R.string.personal_info,true);
        commit_tv=findViewById(R.id.commit_tv);
        commit_tv.setText(R.string.querenxiugai);
        head_img=findViewById(R.id.head_img);
        img_hint_tv=findViewById(R.id.img_hint_tv);
        man_tv=findViewById(R.id.man_tv);
        woman_tv=findViewById(R.id.woman_tv);
        name_edit=findViewById(R.id.name_edit);
        age_edit=findViewById(R.id.age_edit);
        address_edit=findViewById(R.id.address_edit);
        mData= (InformationDisplayBean.DataBean) getIntent().getSerializableExtra("personalInfo");
        if (null!=mData){
            String img_url= ApiService.BASE_IMAGE+ mData.getUser_portrait();
            GlideApp.with(mContext).load(img_url).circleCrop().into(head_img);
            setChoose(mData.getUser_sex());
            name_edit.setText(mData.getUser_name());
            age_edit.setText(String.valueOf(mData.getUser_age()));
            address_edit.setText(mData.getUser_site());
        }

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
        mPersonalPresenter=new PersonalPresenter(this);
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
        setImagePicker();
        Intent intent = new Intent(this, ImageGridActivity.class);
        startActivityForResult(intent, IMAGE_PICKER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                ImagePicker.getInstance().getImageLoader().displayImage((Activity) mContext, images.get(0).path, head_img, 0, 0);
                img_hint_tv.setVisibility(View.GONE);
                List<File> fileList=new ArrayList<>();
                for (int i = 0; i < images.size(); i++) {
                    fileList.add(new File(images.get(i).path));
                }
                if (fileList.size()>0){
                    mPersonalPresenter.postUpLoad(fileList);
                }

            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onCommit(View view) {
        String name = name_edit.getText().toString();
        String age = age_edit.getText().toString();
        String address = address_edit.getText().toString();
        mPersonalPresenter.postInformation(Config.getToken(),name,String.valueOf(sex),age,address);
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("User/information.html")){
            try {
                JSONObject jsonObject=new JSONObject(jsonStr);
                String msg = jsonObject.getString("msg");
                ToastUtils.showToast(msg);
                finish();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (requestUrl.endsWith("Base/upload_img.html")){
            UpLoadBean upLoadBean = JSON.parseObject(jsonStr, UpLoadBean.class);
            ToastUtils.showToast(upLoadBean.getMsg());
            if (upLoadBean.getCode()==1){
                GlideApp.with(mContext).load(ApiService.BASE_IMAGE+upLoadBean.getData().getPath()).circleCrop().into(head_img);
                img_hint_tv.setVisibility(View.GONE);
            }

        }
    }
}
