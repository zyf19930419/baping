package com.weibangbang.model;

import com.weibangbang.api.body.LaunchCommitBody;
import com.weibangbang.api.body.NoticeDetailsBody;
import com.weibangbang.api.body.ReceiveCommitBody;
import com.weibangbang.api.body.ReceiveInfoBody;
import com.weibangbang.api.body.TokenBody;
import com.weibangbang.api.body.VipUpgradeBody;
import com.weibangbang.base.BaseView;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/10/9 9:08
 * 功能描述：
 *
 * @author Administrator
 */
public class HomeModel extends BaseModel {

    /**
     * 首页轮播图接口
     *
     */
    public void postBanners(BaseView baseView) {
        mCall = mApiService.postBanners();
        request(baseView);
    }

    /**
     * 首页公告列表接口
     */
    public void postNotice(BaseView baseView) {
        mCall = mApiService.postNotice();
        request(baseView);
    }


    /**
     * 公告详情接口
     *
     * @param notice_id 任务id
     */
    public void postNoticeDetails(String notice_id, BaseView baseView) {
        NoticeDetailsBody noticeDetailsBody=new NoticeDetailsBody();
        noticeDetailsBody.setNotice_id(notice_id);
        mCall = mApiService.postNoticeDetails(noticeDetailsBody);
        request(baseView);
    }

    /**
     * 我要赚佣接口
     *
     */
    public void postMakeMoney( BaseView baseView) {
        mCall = mApiService.postMakeMoney();
        request(baseView);
    }

    /**
     *免费领用详情
     */
    public void postReceiveInfo(String token, BaseView baseView) {
        ReceiveInfoBody receiveInfoBody = new ReceiveInfoBody();
        receiveInfoBody.setToken(token);
        receiveInfoBody.setId("1");
        mCall = mApiService.postReceiveInfo(receiveInfoBody);
        request(baseView);
    }

    /**
     * 免费领取提交接口
     * @param token
     * @param name 领用姓名
     * @param phone 领用手机号
     * @param address 领用地址
     * @param createTime 领用时间
     */
    public void postReceiveCommit(String token,String name,String phone,String address, BaseView baseView) {
        ReceiveCommitBody receiveCommitBody = new ReceiveCommitBody();
        receiveCommitBody.setToken(token);
        receiveCommitBody.setCompellation(name);
        receiveCommitBody.setPhone(phone);
        receiveCommitBody.setAddress(address);
        receiveCommitBody.setCreatetime(String.valueOf(System.currentTimeMillis()));
        mCall = mApiService.postReceiveCommit(receiveCommitBody);
        request(baseView);
    }

    /**
     * 开通会员
     */
    public void postVipList(String token, BaseView baseView) {
        TokenBody tokenBody = new TokenBody();
        tokenBody.setToken(token);
        mCall = mApiService.postVipList(tokenBody);
        request(baseView);
    }

    /**
     *升级会员接口
     * @param token
     * @param upgrade  升级vip的id(级别)
     * @param pay_way  1微信  2支付宝
     */
    public void postVipUpgrade(String token,String upgrade,String pay_way, BaseView baseView) {
        VipUpgradeBody vipUpgradeBody = new VipUpgradeBody();
        vipUpgradeBody.setToken(token);
        vipUpgradeBody.setUpgrade(upgrade);
        vipUpgradeBody.setPay_way(pay_way);
        mCall = mApiService.postVipUpgrade(vipUpgradeBody);
        request(baseView);
    }

    /**
     * 联系客服接口
     */
    public void postContactCustomerService(BaseView baseView) {
        mCall = mApiService.postContactCustomerService();
        request(baseView);
    }

    /**
     * 投放广告接口
     */
    public void postLaunchCommit(String token, String user_launch_content, String user_launch_compellation, String user_launch_phone, BaseView baseView) {
        LaunchCommitBody launchCommitBody = new LaunchCommitBody();
        launchCommitBody.setToken(token);
        launchCommitBody.setUser_launch_content(user_launch_content);
        launchCommitBody.setUser_launch_compellation(user_launch_compellation);
        launchCommitBody.setUser_launch_phone(user_launch_phone);
        mCall = mApiService.postLaunchCommit(launchCommitBody);
        request(baseView);
    }


    /**
     *分享接口
     */
    public void postShare(BaseView baseView){
        mCall=mApiService.postShare();
        request(baseView);
    }

    /**
     *招商微信接口
     */
    public void postAttract(BaseView baseView){
        mCall=mApiService.postAttract();
        request(baseView);
    }
}
