package com.liuhui.xlceremony.app.constant;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.constant
 * user  Pinocchio
 * Date 2015/8/17
 * Email:liu594545591@126.com
 */
public interface RequestParam {
    /**
     * 手机号
     * 所用场景：登录、注册、手机验证、安全设置
     */
    String MOBILE = "mobile";

    /**
     * 密码
     * 所用场景：登录、注册、安全设置
     */
    String PASSWORD = "password";

    /**
     * 短信验证码
     * 所用场景：注册
     */
    String AUTH_CODE = "pincode";

    /**
     * 短信内容
     */
    String SMS_CONTENT = "您的验证码：2356";
}
