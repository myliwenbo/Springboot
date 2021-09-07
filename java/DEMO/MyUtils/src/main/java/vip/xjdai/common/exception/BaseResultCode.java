package vip.xjdai.common.exception;

import org.apache.commons.lang.StringUtils;

public enum BaseResultCode {
    /**
     * 系统相关
     */
    SUCCESS("200", "成功"),
    FAILED("FAILED", "失败"),
    NOT_WHITE_LIST("4000", "系统内测中，即将开放"),
    SYSTEM_ERROR("4001", "系统异常，请稍后重试"),
    CONNECT_TIMED_OUT("4002", "开了会小差,请稍后再试！"), //超时
    FALSE("4003", "系统繁忙，请稍后重试"),

    /**
     * 参数相关
     */
    VERIFY_SIGN_FAIL("VERIFY_SIGN_FAIL", "验签失败"),
    PARAM_INVALID("PARAM_INVALID", "参数不合法，请检查"),
    NO_INSURED_MEDICALPRESEMTATION("7000", "输入信息不正确"),
    PARAM_EMPTY("7001", "参数为空，请检查"),
    PATIENT_INFO_IMPERFECT("7002", "很抱歉，信息不完善无法继续"),
    /**
     * 账号相关
     */
    NOT_AUTH("NOT_AUTH", "未授权"),
    INVALID_OPERATE("INVALID_OPERATE", "非法操作"),
    MEMBER_NOT_LOGIN("MEMBER_NOT_LOGIN", "会员未登录"),
    MEMBER_NOT_EXIST("MEMBER_NOT_EXIST", "会员不存在"),
    NOT_LOGIN("NOT_LOGIN", "登录失效，请重新登录！"),
    MEMBER_ACCOUNT_EXIST("MEMBER_ACCOUNT_EXIST", "账号已存在"),
    PASSWORD_ERROR("PASSWORD_ERROR", "帐号不存在或密码错误，请核对后输入"),
    PHONE_EXIST("PHONE_EXIST", "手机号已存在"),
    ACK_ERROR("ACK_ERROR", "验证码错误"),
    PASSWORD_TIWICE_ERROE("PASSWORD_TIWICE_ERROE", "两次密码输入不一致"),
    MEMBER_LOGIN_LOCKED("MEMBER_LOGIN_LOCKED", "账号已被锁定"),
    /**
     *
     */
    RECORD_EXIST("RECORD_EXIST", "记录已存在"),
    RECORD_NOT_EXIST("RECORD_NOT_EXIST", "记录不存在"),
    NOT_FIND_INFORMATION("NOT_FIND_INFORMATION", "抱歉，未查到相关信息！"), //005,抱歉，未查到相关信息！
    PLEASE_WAIT_PATIENTLY_DURING_OPERATION("002", "执行中，请耐心等待"),
    FORM_REPEAT_COMMITED("FORM_REPEAT_COMMITED", "不要重复提交表单"),
    CARD_INVALID("CARD_INVALID", "卡号不合法，请检查");
    /**
     * code
     */
    private String code;
    /**
     * 信息
     */
    private String msg;

    private BaseResultCode(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BaseResultCode getEnum(final String code) {
        final BaseResultCode[] list = values();
        for (final BaseResultCode emun : list) {
            if (null != emun) {
                if (StringUtils.equals(code, emun.getCode())) {
                    return emun;
                }
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}