package com.weibangbang.api;

import com.weibangbang.api.body.ChangePasswordBody;
import com.weibangbang.api.body.ForgetBody;
import com.weibangbang.api.body.InformationBody;
import com.weibangbang.api.body.LaunchCommitBody;
import com.weibangbang.api.body.LobbyBody;
import com.weibangbang.api.body.LoginBody;
import com.weibangbang.api.body.NoticeDetailsBody;
import com.weibangbang.api.body.ReceiveCommitBody;
import com.weibangbang.api.body.RegisterBody;
import com.weibangbang.api.body.SendmessageBody;
import com.weibangbang.api.body.TaskInfoBody;
import com.weibangbang.api.body.TokenBody;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 14:35
 * 功能描述：
 */
public interface ApiService {
    String BASE_IMAGE="http://weibangbang.dazhu-ltd.cn/public/static/upload/";

    String OFFICIAL_WEB = "http://weibangbang.dazhu-ltd.cn/";

    String BASE_URL = OFFICIAL_WEB + "index.php/index/";

    @POST("index/banner.html")
    Call<ResponseBody> postBanners();

    @POST("index/notice.html")
    Call<ResponseBody> postNotice();


    @POST("Work/ranking_day.html")
    Call<ResponseBody> postDailyRankings(@Body TokenBody tokenBody);

    @POST("Work/ranking_list.html")
    Call<ResponseBody> postUniversalLeaderboard(@Body TokenBody tokenBody);

    @POST("Index/notice_details.html")
    Call<ResponseBody> postNoticeDetails(@Body NoticeDetailsBody noticeDetailsBody);

    @POST("Work/lobby.html")
    Call<ResponseBody> postMakeMoney(@Body TokenBody tokenBody);

    @POST("Service/service_list.html")
    Call<ResponseBody> postContactCustomerService(@Body TokenBody tokenBody);

    @POST("Work/task_rules.html")
    Call<ResponseBody> postTaskRules(@Body TokenBody tokenBody);


    @POST("Account/send_message.html")
    Call<ResponseBody> postSendmessage(@Body SendmessageBody sendmessageBody);


    @POST("Account/register.html")
    Call<ResponseBody> postRegister(@Body RegisterBody registerBody);

    @POST("Account/forget.html")
    Call<ResponseBody> postForget(@Body ForgetBody forgetBody);

    @POST("Account/login.html")
    Call<ResponseBody> postLogin(@Body LoginBody loginBody);

    @POST("User/Personal_page.html")
    Call<ResponseBody> postPersonalPage(@Body TokenBody tokenBody);

    @POST("Launch/launch_commit.html")
    Call<ResponseBody> postLaunchCommit(@Body LaunchCommitBody launchCommitBody);

    @POST("User/login_out.html")
    Call<ResponseBody> postLoginOut(@Body TokenBody tokenBody);

    @POST("Work/lobby.html")
    Call<ResponseBody> postlobby(@Body LobbyBody lobbyBody);

    @POST("Receive/receive_commit.html")
    Call<ResponseBody> postReceiveCommit(@Body ReceiveCommitBody receiveCommitBody);

    @POST("User/team11J.html")
    Call<ResponseBody> postTeam11J(@Body TokenBody tokenBody);

    @POST("User/team22J.html")
    Call<ResponseBody> postTeam22J(@Body TokenBody tokenBody);


    @POST("User/change_password.html")
    Call<ResponseBody> postChangePassword(@Body ChangePasswordBody changePasswordBody);


    @POST("Work/receive.html")
    Call<ResponseBody> postReceivie(@Body TokenBody tokenBody);

    @POST("Work/task_accomplish.html")
    Call<ResponseBody> postTaskAccomplish(@Body TokenBody tokenBody);

    @POST("User/information.html")
    Call<ResponseBody> postInformation(@Body InformationBody informationBody);

    @POST("User/my_wallet.html")
    Call<ResponseBody> postMyWallet(@Body TokenBody tokenBody);

    @POST("Work/task_info.html")
    Call<ResponseBody> posTaskInfo(@Body TaskInfoBody taskInfoBody);

    @POST("Vip/vip_list.html")
    Call<ResponseBody> postVipList(@Body TokenBody tokenBody);

}
