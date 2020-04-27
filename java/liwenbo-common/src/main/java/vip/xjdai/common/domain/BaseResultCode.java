package vip.xjdai.common.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * 自定义错误信息
 * @author lwb
 *
 */
public enum BaseResultCode {
                            SUCCESS("SUCCESS", "成功"),
                            FAILED("FAILED", "失败"),
                            NOT_AUTH("NOT_AUTH", "未授权"),
                            INVALID_OPERATE("INVALID_OPERATE", "非法操作"),
                            VERIFY_SIGN_FAIL("VERIFY_SIGN_FAIL", "验签失败"),
                            PARAM_INVALID("PARAM_INVALID", "参数不合法，请检查"),
                            PARAM_EMPTY("PARAM_EMPTY", "参数为空，请检查"),
                            MEMBER_NOT_LOGIN("MEMBER_NOT_LOGIN", "会员未登录"),
                            MEMBER_NOT_EXIST("MEMBER_NOT_EXIST", "会员不存在"),
                            MEMBER_ACCOUNT_EXIST("MEMBER_ACCOUNT_EXIST", "账号已存在"),
                            PASSWORD_ERROR("PASSWORD_ERROR", "帐号不存在或密码错误，请核对后输入"),
                            PHONE_EXIST("PHONE_EXIST", "手机号已存在"),
                            ACK_ERROR("ACK_ERROR", "验证码错误"),
                            PASSWORD_TIWICE_ERROE("PASSWORD_TIWICE_ERROE", "两次密码输入不一致"),
                            MEMBER_LOGIN_LOCKED("MEMBER_LOGIN_LOCKED", "账号已被锁定"),
                            RECORD_EXIST("RECORD_EXIST", "记录已存在"),
                            RECORD_NOT_EXIST("RECORD_NOT_EXIST", "记录不存在"),
                            FORM_REPEAT_COMMITED("FORM_REPEAT_COMMITED", "不要重复提交表单"),
                            SYSTEM_ERROR("SYSTEM_ERROR", "系统异常，请稍后重试"),
                            ACCOUNT_NOT_EXIST("ACCOUNT_NOT_EXIST", "资金账户不存在"),
                            ACCOUNT_IS_RISK("ACCOUNT_IS_RISK", "风险资金账户"),
                            CARD_INVALID("CARD_INVALID", "卡号不合法，请检查"),
                            BALANCE_NOT_ENOUGH("BALANCE_NOT_ENOUGH", "账户余额不足"),
                            POINTS_NOT_ENOUGH("POINTS_NOT_ENOUGH", "积分余额不足"),
                            REFUND_AMOUNT_INVALID("REFUND_AMOUNT_INVALID", "退款金额不合法，请检查"),
                            TRADE_IS_EXIST("TRADE_IS_EXIST", "交易已存在"),
                            TRADE_NOT_EXIST("TRADE_NOT_EXIST", "交易不存在"),
                            REFUND_NOT_EXIST("REFUND_NOT_EXIST", "退款记录不存在"),
                            COUPON_NOT_EXIST("COUPON_NOT_EXIST", "红包不存在");

    private String code;
    private String msg;

    private BaseResultCode(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BaseResultCode getEnum(final String code)
    {
        final BaseResultCode[] arr$ = values();
        for (final BaseResultCode emun : arr$) {
            if (null != emun) {
                if (StringUtils.equals(code, emun.getCode())) {
                    return emun;
                }
            }
        }
        return null;
    }

    public String getCode()
    {
        return this.code;
    }

    public String getMsg()
    {
        return this.msg;
    }
}