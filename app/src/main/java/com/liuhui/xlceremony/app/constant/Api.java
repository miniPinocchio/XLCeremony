package com.liuhui.xlceremony.app.constant;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.constant
 * user  Pinocchio
 * Date 2015/8/17
 * Email:liu594545591@126.com
 */
public interface Api {
    /**
     * 登录 POST
     */
    String LOGIN = "http://xl.wx.21future.com/index.php?s=appapi&a=login";

    /**
     * 获取短信验证码 POST
     */
    String GET_AUTH_CODE = "http://xl.wx.21future.com/index.php?s=appapi&a=pin";

    /**
     * 注册 POST
     */
    String REGISTER = "http://xl.wx.21future.com/index.php?s=appapi&a=reg";
}