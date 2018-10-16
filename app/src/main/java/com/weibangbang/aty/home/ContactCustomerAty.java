package com.weibangbang.aty.home;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.weibangbang.R;
import com.weibangbang.api.Config;
import com.weibangbang.base.BaseActivity;
import com.weibangbang.bean.home.CustomerBean;
import com.weibangbang.presenter.HomePresenter;

import java.util.List;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:51
 * 功能描述：
 */
public class ContactCustomerAty extends BaseActivity{
    private TextView contacts1_tv,contacts2_tv,phone1_tv,phone2_tv,service_am_tv,service_pm_tv,hot_line_tv;
    private HomePresenter mHomePresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_contact_customer;
    }

    @Override
    public void initView() {
        setTitleBar(getResources().getString(R.string.lianxikefu),true);
        contacts1_tv=findViewById(R.id.contacts1_tv);
        contacts2_tv=findViewById(R.id.contacts2_tv);
        phone1_tv=findViewById(R.id.phone1_tv);
        phone2_tv=findViewById(R.id.phone2_tv);
        service_am_tv=findViewById(R.id.service_am_tv);
        service_pm_tv=findViewById(R.id.service_pm_tv);
        hot_line_tv=findViewById(R.id.hot_line_tv);
    }

    @Override
    public void initData() {
        mHomePresenter=new HomePresenter(this);
        mHomePresenter.postContactCustomerService(Config.getToken());
    }

    public void onKefu1(View view) {
        ClipboardManager cm= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("kefu1",phone1_tv.getText());
        cm.setPrimaryClip(clipData);
        Toast.makeText(this, "复制成功", Toast.LENGTH_LONG).show();
    }

    public void onKefu2(View view) {
        ClipboardManager cm= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("kefu2",phone2_tv.getText());
        cm.setPrimaryClip(clipData);
        Toast.makeText(this, "复制成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComplete(String requestUrl, String jsonStr) {
        super.onComplete(requestUrl, jsonStr);
        if (requestUrl.endsWith("Service/service_list.html")){
            CustomerBean customerBean = JSON.parseObject(jsonStr, CustomerBean.class);
            CustomerBean.DataBean data = customerBean.getData();
            List<CustomerBean.DataBean.ServiceBean> service = data.getService();
            if (service!=null && service.size()>=2){
                contacts1_tv.setText("客服服务"+service.get(0).getService_name()+"1");
                phone1_tv.setText(service.get(0).getService_contact());
                contacts2_tv.setText("客服服务"+service.get(1).getService_name()+"1");
                phone2_tv.setText(service.get(1).getService_contact());
            }
            CustomerBean.DataBean.InformationBean information = data.getInformation();
            hot_line_tv.setText("客户服务热线\u3000:\u3000"+information.getService_phone());
        }
    }
}
