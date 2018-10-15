package com.weibangbang.api.body;

/**
 * 创建者：voodoo_jie
 * <br>创建时间：2018/10/15 015下午 02:32
 * <br>功能描述：投放广告
 */
public class LaunchCommitBody {

    private String token;
    private String user_launch_content; // 广告内容
    private String user_launch_compellation; // 姓名
    private String user_launch_phone; // 手机

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_launch_content() {
        return user_launch_content;
    }

    public void setUser_launch_content(String user_launch_content) {
        this.user_launch_content = user_launch_content;
    }

    public String getUser_launch_compellation() {
        return user_launch_compellation;
    }

    public void setUser_launch_compellation(String user_launch_compellation) {
        this.user_launch_compellation = user_launch_compellation;
    }

    public String getUser_launch_phone() {
        return user_launch_phone;
    }

    public void setUser_launch_phone(String user_launch_phone) {
        this.user_launch_phone = user_launch_phone;
    }
}
