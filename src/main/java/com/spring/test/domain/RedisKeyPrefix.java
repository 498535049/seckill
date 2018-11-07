package com.spring.test.domain;

/**
 * @author asheng
 * @since 2018/8/9
 */
public enum RedisKeyPrefix {

    /** 短信验证码限制的key */
    VERIFY_CODE_LIMIT("verify_code_limit_"),

    /** 手机验证码前缀 */
    VERIFY_CODE_PREFIX("verify_code:"),

    /** 银行卡签约申请 */
    BANK_CARD_SIGN_APPLY("bank_card_sign_apply_"),

    /** 老手机验证码或者人脸校验标识 */
    ORIGINAL_PHONE_OR_FACE_CHECK_FLAG("original_phone_or_face_check_flag_"),

    /** 登录有效期 */
    LOGIN_EXPIRY_DATE("login_expiry_date_"),

    /** 设备token前缀 */
    DEVICE_TOKEN("device_token_"),
    ;

    private String prefix;

    RedisKeyPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
