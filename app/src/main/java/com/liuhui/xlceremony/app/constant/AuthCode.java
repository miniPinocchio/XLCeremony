package com.liuhui.xlceremony.app.constant;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.constant
 * user  Pinocchio
 * Date 2015/8/17
 * Email:liu594545591@126.com
 */
public class AuthCode {
    //短信验证码
    private String pincode;

    private String optime;

    public void setPincode(String pincode) { this.pincode = pincode;}

    public void setOptime(String optime) { this.optime = optime;}

    public String getPincode() { return pincode;}

    public String getOptime() { return optime;}
}
