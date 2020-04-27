package vip.xjdai.common;

import cn.vihost.farmplatform.core.constant.ErrorCode;

/**
 * Title: PhoenixWebErrorCodeEnums
 * <p>
 * Description:
 *
 * @author 瞿宇龙
 * @version V1.0
 * @since 2019/11/30
 */
public enum WebErrorCodeEnums implements ErrorCode {


    /**
     *
     */
    BAK_ALL_CODE(400, "信息自定义"),
    BAK_DELETE_ERROR(400, "删除失败"),
    BAK_UPDATE_ERROR(400, "修改失败"),
    BAK_IMG_NULL_ERROR(400, "图片不存在"),
    BAK_USER_EXISTED(400, "用户已存在"),
    BAK_ROLE_EXISTED(400, "角色名称冲突"),
    BAK_UPDATE_ROLE_ERROR(400, "默认角色不允许修改或者删除"),
    BAK_UPDATE_USER_ERROR(400, "默认用户不允许修改或者删除"),
    BAK_USER_ROLE_NOT_FOUNT(400, "用户角色不存在"),
    IS_DISABLE(400, "用户禁用中"),
    ORGANIZATION_IS_DISABLE(400, "企业禁用中"),
    ORGANIZATION_MESSAGE_INCOMPLETE(400, "机构信息不完整，审核失败"),
    ORGANIZATION_APPROVAL(400, "机构审核中"),
    ORGANIZATION_TYPE_IS_NOT_NULL(400, "传递type类型错误"),
    APP_ID_LACK(10001, "appid缺失"),
    APP_ID_TYPE_ERROR(10002, "appid类型错误"),
    SAVE_ERROR(10003, "保存失败"),
    DELETE_ERROR(10004, "删除失败"),
    UPDATE_ERROR(10005, "修改失败"),
    SELECT_ERROR(10006, "查询失败"),
    PARAM_ERROR(10007, "参数错误"),
    SIZE_ERROR(10008, "长度错误"),
    USER_NOT_FOUNT(10009, "用户不存在"),
    USER_OR_PWD_ERROR(10010, "用户名或密码错误"),
    USER_NOT_LOGIN(10000, "用户未登录"),
    JSON_DESERIALIZATION(10011, "JSON反序列化异常"),
    MATCH_TYPE_ERROR(10012, "智能匹配类型错误"),
    ARRAYS_IS_NOT_EMPTY(10013, "集合数据不能为空"),
    JSON_SERIALIZATION(10014, "JSON序列化异常"),
    USER_EXISTED(10015, "用户已存在"),
    ONLY_CODE_EXISTED(10016, "统一信用编码已存在"),
    USER_ORG_TYPE_ERROR(10017, "用户类型异常"),
    USER_TYPE_ERROR(10018, "用户登录类型异常"),
    DATA_ERROR(10019, "数据异常"),
    USER_DATA_ERROR(10020, "用户数据异常"),
    THIRD_DATA_ERROR(10021, "第三方接口数据异常"),
    THIRD_REQUEST_ERROR(10022, "第三方接口请求失败"),
    MOBILE_NOT_NULL(10023, "手机号不能为空"),
    MESSAGE_NOT_NULL(10024, "未找到消息"),
    MESSAGE_TYPE_ERROR(10025, "消息类型错误"),
    ITEM_NOT_FOUNT(11001, "未找到对应商品"),
    ITEM_NODE_INFO_NOT_FOUNT(11002, "未找到商品节点数据"),
    IDS_NOT_EMPTY(11003, "id列表不能为空"),


    FORM_PROPERTY_DATA_ERROR(12002, "表单数据异常"),
    TEMPLATE_NAME_EXISTED(13001, "审批模板名称已存在"),
    APPROVE_NODE_FIRST_EXISTED(13002, "首个审批节点已存在"),
    APPROVE_PRE_NODE_NOT_FOUNT(13003, "未找到前置审批节点"),
    APPROVE_NEXT_NODE_EXISTED(13004, "下一节点已存在"),
    APPROVE_NODE_DATA_ERROR(13005, "审批节点数据异常"),
    FORM_PROPERTY_EXISTED(13006, "该节点已配置表单"),
    APPROVE_TEMPLATE_VALUE_NOT_FOUNT(13007, "未找到对应订单"),
    APPROVE_FLOW_OVER(13008, "审批流程已结束"),
    APPROVE_NODE_IS_BIND(13009, "当前审批模板已绑定节点"),
    USER_INFO_ERROR(13010, "抄送或处理人数据异常"),
    USER_ROLE_INFO_ERROR(13011, "抄送或处理角色数据异常"),
    NODE_FLOW_STATUS_ERROR(13012, "审核状态异常"),
    APPROVE_TEMPLATE_NOT_FOUNT(13013, "未找到对应审批模板"),
    COMPONENT_NOT_FOUNT(13014, "未找到对应组件"),
    APPLY_FORM_NOT_BIND(13015, "商品申请表单未绑定"),
    ITEM_EXISTED_APPLY(13016, "该商品已经申请，请勿重复申请"),
    ILLEGAL_OPERATION(13017, "非法操作"),
    ORDER_DATA_ERROR(13018, "订单数据异常"),
    ORDER_STATUS_ERROR(13019, "订单状态异常"),
    SMS_SEND_ERROR(13020, "短信发送异常"),
    CHECK_SMS_CODE_ERROR(13021, "短信验证码错误"),
    USER_TYPE_NOT_NULL(13022, "用户类型不能为空"),
    ORDER_ALREADY_DISPATCH(13023, "订单已被派发，不能重复派发"),
    USER_INFO_MISS(13024, "用户信息缺失，请完善信息后再提交申请"),
    REPAY_INFO_EXISTED(13025, "还款信息已存在"),
    MOBILE_NOT_BING(13026, "手机号未绑定，请先绑定手机号"),
    FILE_INFO_NOT_FOUNT(13027, "文件信息不存在"),
    NOT_FILE_INFO(13028, "无审批文件可下载"),
    SMS_ALREADY_MAX(13029, "该手机号今日短信已达上限，请明日再试"),
    USER_REVIEW_NOT_BY(13030, "企业审核暂未通过，无法申请贷款"),
    PROCESS_USER_NOT_NULL(13031, "审核人员不能为空"),
    MOBILE_ALREADY_REGISTER(13032, "该手机号已注册"),
    SMS_CODE_EXPIRED(13033, "短信验证码已过期"),
    CATEGORY_CONFLICT(13034, "分类冲突"),
    ORG_CONFLICT(13035, "机构冲突"),
    USER_IS_NOT_DISABLE(13036, "不能禁用自己的账号"),
    ORDER_ALREADY_SUCCESS_NOT_DISPATCH(13037, "订单已完成，不可再派发"),
    ;


    private int code;
    private String message;

    WebErrorCodeEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
