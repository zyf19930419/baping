package com.bapingtianxia.baping.wxapi;

import android.content.Intent;
import android.util.Log;

import com.bapingtianxia.baping.R;
import com.bapingtianxia.baping.base.BaseActivity;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {
	
	private static final String TAG = "WXPayEntryActivity";
	
    private IWXAPI api;


	@Override
	public int getLayoutId() {
		return R.layout.activity_base;
	}

	@Override
	public void initView() {
		//TODO  需要微信appId
		api = WXAPIFactory.createWXAPI(this, "");
		api.handleIntent(getIntent(), this);
	}

	@Override
	public void initData() {

	}


	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
        api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	public void onResp(BaseResp resp) {
		Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);
		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            Intent intent = new Intent("weibangbang.wxPay");
            intent.putExtra("errCode", resp.errCode);
            sendBroadcast(intent);
            finish();
		}
	}
}