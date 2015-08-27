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
    /**
     * 密码重置 POST
     */
    String RESET_PASSWORD = "http://xl.wx.21future.com/index.php?s=appapi&a=repassword";
    /**
     * 通讯录 POST
     */
    String CONTACTS = "http://xl.wx.21future.com/index.php?s=appapi&a=friends";

    /**
     * 导入通讯录
     */
    String LOAD_CONTACTS = "http://xl.wx.21future.com/index.php?s=appapi&a=addBatchFriends";
    /**
     * 打分-列表
     */
    String SCORE_LIST = "http://xl.wx.21future.com/index.php?s=appapi&a=grade";
    /**
     * 打分-添加
     */
    String SCORE_ADD = "http://xl.wx.21future.com/index.php?s=appapi&a=addgrade";
    /**
     * 打分-词条列表
     */
    String SCORE_ENTRY_LIST = "http://xl.wx.21future.com/index.php?s=appapi&a=entry";
    /**
     * 印象-列表
     */
    String IMPRESS_LIST = "http://xl.wx.21future.com/index.php?s=appapi&a=impress";
    /**
     * 印象-添加
     */
    String IMPRESS_ADD = "http://xl.wx.21future.com/index.php?s=appapi&a=addimpress";
    /**
     * 印象-批量添加
     */
    String IMPRESS_ADDS = "http://xl.wx.21future.com/index.php?s=appapi&a= addBatchImpress";
    /**
     * 点赞-列表
     */
    String PRISE_LIST = "http://xl.wx.21future.com/index.php?s=appapi&a=praise";
    /**
     * 点赞-添加
     */
    String PRISE_ADD = "http://xl.wx.21future.com/index.php?s=appapi&a=addpraise";
    /**
     * 评论-列表
     */
    String COMMENT_LIST = "http://xl.wx.21future.com/index.php?s=appapi&a=comment";
    /**
     * 评论-添加
     */
    String COMMENT_ADD = "http://xl.wx.21future.com/index.php?s=appapi&a=addcomment";
    /**
     * 送礼-推荐方案
     */
    String GIFT_RECOMMEND = "http://xl.wx.21future.com/index.php?s=appapi&a=recplan";
    /**
     * 送礼-祝福语
     */
    String GIFT_BLESS = "http://xl.wx.21future.com/index.php?s=appapi&a=bless";
    /**
     * 送礼-卡券
     */
    String GIFT_CARD = "http://xl.wx.21future.com/index.php?s=appapi&a=card";
    /**
     * 送礼-添加送礼
     */
    String GIFT_ADD = "http://xl.wx.21future.com/index.php?s=appapi&a=addgifts";
    /**
     * 情礼攻略
     */
    String EMOTION_STRATEGY = "http://xl.wx.21future.com/index.php?s=appapi&a=idea";
    /**
     * 攻略详情
     */
    String DETAIL_STRATEGY = "http://xl.wx.21future.com/index.php?s=appapi&a=showidea";
    /**
     * 个人详细信息
     */
    String DETAIL_PERSONAL = "http://xl.wx.21future.com/index.php?s=appapi&a=profile";
    /**
     * 编辑个人资料
     */
    String PERSONAL_DATA = "http://xl.wx.21future.com/index.php?s=appapi&a=editprofile";
    /**
     * 编辑个人昵称
     */
    String PERSONAL_NICKNAME = "http://xl.wx.21future.com/index.php?s=appapi&a=editnickname";
    /**
     * 相册列表
     */
    String ALBUM_LIST = "http://xl.wx.21future.com/index.php?s=appapi&a=album";
    /**
     * 排行榜
     */
    String RANK = "http://xl.wx.21future.com/index.php?s=appapi&a=ranking";
    /**
     * 情礼提醒-列表
     */
    String REMIND_LIST = "http://xl.wx.21future.com/index.php?s=appapi&a=remind";
    /**
     * 情礼提醒-添加
     */
    String REMIND_ADD = "http://xl.wx.21future.com/index.php?s=appapi&a=addremind";
    /**
     * 情礼提醒-删除
     */
    String REMIND_DELETE = "http://xl.wx.21future.com/index.php?s=appapi&a=delremind";

    //TODO 待添加
    /**
     *二十二、短信模版

     二十三、我的卡卷

     二十四、关怀话题

     二十五、我的故事

     二十六、我的收藏

     二十七、情礼记录

     二十八、更换手机号码

     二十九、修改密码

     三十、绑定邮箱

     三十一、绑定微博

     三十二、绑定微信

     三十三、相册添加

     三十四、群发助手

     三十五、个人头像上传

     三十六、关系网络

     三十七、通讯录分组
     */

}