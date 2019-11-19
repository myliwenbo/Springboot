package vip.xjdai.common.domain;

import vip.xjdai.common.util.BeanUtil;

public enum ResultType {
                        SYSTEM_BUSY(-1, "系统繁忙"),
                        SUCCESS(0, "请求成功"),
                        APP_SECRET_ERROR(40001, "获取access_token时AppSecret错误，或者access_token无效"),
                        ILLEGAL_TOKEN_TYPE(40002, "不合法的凭证类型"),
                        ILLEGAL_OPEN_ID(40003, "不合法的OpenID"),
                        ILLEGAL_MEDIA_TYPE(40004, "不合法的媒体文件类型"),
                        ILLEGAL_FILE_TYPE(40005, "不合法的文件类型"),
                        ILLEGAL_FILE_SIZE(40006, "不合法的文件大小"),
                        ILLEGAL_MEDIA_ID(40007, "不合法的媒体文件id"),
                        ILLEGAL_MESSAGE_TYPE(40008, "不合法的消息类型"),
                        ILLEGAL_PICTURE_SIZE(40009, "不合法的图片文件大小"),
                        ILLEGAL_VOICE_SIZE(40010, "不合法的语音文件大小"),
                        ILLEGAL_VIDEO_SIZE(40011, "不合法的视频文件大小"),
                        ILLEGAL_THUMBNAIL_SIZE(40012, "不合法的缩略图文件大小"),
                        ILLEGAL_APP_ID(40013, "不合法的APPID"),
                        ILLEGAL_ACCESS_TOKEN(40014, "不合法的access_token"),
                        ILLEGAL_MENU_TYPE(40015, "不合法的菜单类型"),
                        ILLEGAL_MENU_NUMBER(40016, "不合法的按钮个数"),
                        ILLEGAL_BUTTON_NAME_LENTH(40018, "不合法的按钮名字长度"),
                        ILLEGAL_BUTTON_KEY_LENTH(40019, "不合法的按钮KEY长度"),
                        ILLEGAL_BUTTON_URL_LENTH(40020, "不合法的按钮URL长度"),
                        ILLEGAL_MENU_VERSION(40021, "不合法的菜单版本号"),
                        ILLEGAL_SUB_MENU_LEVEL(40022, "不合法的子菜单级数"),
                        ILLEGAL_SUB_MENU_NUMBER(40023, "不合法的子菜单按钮个数"),
                        ILLEGAL_SUB_MENU_TYPE(40024, "不合法的子菜单按钮类型"),
                        ILLEGAL_SUB_MENU_LENTH(40025, "不合法的子菜单按钮名字长度"),
                        ILLEGAL_SUB_MENU_KEY_LENTH(40026, "不合法的子菜单按钮KEY长度"),
                        ILLEGAL_SUB_MENU_URL_LENTH(40027, "不合法的子菜单按钮URL长度"),
                        ILLEGAL_MENU_USER(40028, "不合法的自定义菜单使用用户"),
                        ILLEGAL_OAUTH_CODE(40029, "不合法的oauth_code"),
                        ILLEGAL_REFRESH_TOKEN(40030, "不合法的refresh_token"),
                        ILLEGAL_OPENID_LIST(40031, "不合法的openid列表"),
                        ILLEGAL_OPENID_LIST_LENTH(40032, "不合法的openid列表长度"),
                        ILLEGAL_REQUEST_STRING(40033, "不合法的请求字符"),
                        ILLEGAL_PARAM(40035, "不合法的参数"),
                        ILLEGAL_REQUEST_TYPE(40038, "不合法的请求格式"),
                        ILLEGAL_URL_LENTH(40039, "不合法的URL长度"),
                        ILLEGAL_GROUP_ID(40050, "不合法的分组id"),
                        ILLEGAL_GROUP_NAME(40051, "分组名字不合法"),
                        ILLEGAL_MEDIA_ID_SIZE(40118, "media_id大小不合法"),
                        BUTTON_TYPE_ERROR(40119, "button类型错误"),
                        ILLEGAL_MEDIA_ID_TYPE(40121, "不合法的media_id类型"),
                        NO_ACCESS_TOKEN(41001, "缺少access_token参数"),
                        NO_APPID(41002, "缺少appid参数"),
                        NO_REFRESH_TOKEN(41003, "缺少refresh_token参数"),
                        NO_SECRET(41004, "缺少secret参数"),
                        NO_MEDIA_DATA(41005, "缺少多媒体文件数据"),
                        NO_MEDIA_ID(41006, "缺少media_id参数"),
                        NO_SUB_MENU_DATA(41007, "缺少子菜单数据"),
                        NO_OAUTH_CODE(41008, "缺少oauth code"),
                        NO_OPEN_ID(41009, "缺少openid"),
                        ACCESS_TOKEN_TIMEOUT(42001, "access_token超时"),
                        REFRESH_TOKEN_TIMEOUT(42002, "refresh_token超时"),
                        OAUTH_CODE_TIMEOUT(42003, "oauth_code超时"),
                        NEED_REQUEST_GET(43001, "需要GET请求"),
                        NEED_REQUEST_POST(43002, "需要POST请求"),
                        NEED_REQUEST_HTTPS(43003, "需要HTTPS请求"),
                        NEED_USER_FOLLOW(43004, "需要接收者关注"),
                        NEED_FRIEND(43005, "需要好友关系"),
                        MEDIA_FILE_IS_NULL(44001, "多媒体文件为空"),
                        POST_DATA_IS_NULL(44002, "POST的数据包为空"),
                        NEWS_MESSAGE_IS_NULL(44003, "图文消息内容为空"),
                        TEXT_MESSAGE_IS_NULL(44004, "文本消息内容为空"),
                        MEDIA_DATA_OVER_LIMIT(45001, "多媒体文件大小超过限制"),
                        MESSAGE_CONTENT_OVER_LIMIT(45002, "消息内容超过限制"),
                        TITLE_OVER_LIMIT(45003, "标题字段超过限制"),
                        DESCRIPTION_OVER_LIMIT(45004, "描述字段超过限制"),
                        LINK_OVER_LIMIT(45005, "链接字段超过限制"),
                        PICTURE_LINK_OVER_LIMIT(45006, "图片链接字段超过限制"),
                        VOICE_TIME_OVER_LIMIT(45007, "语音播放时间超过限制"),
                        NEWS_MESSAGE_OVER_LIMIT(45008, "图文消息超过限制"),
                        INTERFACE_OVER_LIMIT(45009, "接口调用超过限制"),
                        MENU_OVER_LIMIT(45010, "创建菜单个数超过限制"),
                        REVIEW_TIME_OVER_LIMIT(45015, "回复时间超过限制"),
                        NO_MODIFY_SYSTEM_GROUP(45016, "系统分组，不允许修改"),
                        GROUP_NAME_TOO_LONG(45017, "分组名字过长"),
                        GROUP_COUNT_TOO_MANY(45018, "分组数量超过上限"),
                        TAG_NAME_TOO_MANY(45056, "创建的标签数过多，请注意不能超过100个"),
                        CAN_NOT_DELETE_TAG(45057, "该标签下粉丝数超过10w，不允许直接删除"),
                        CAN_NOT_MODIFY_TAG(45058, "不能修改0/1/2这三个系统默认保留的标签"),
                        FANS_TAGS_TOO_MANY(45059, "有粉丝身上的标签数已经超过限制"),
                        ILLEGAL_TAG_NAME(45157, "标签名非法，请注意不能和其他标签重名"),
                        TAG_NAME_TOO_LONG(45158, "标签名长度超过30个字节"),
                        ILLEGAL_TAG_ID(45159, "非法的tag_id"),
                        NOT_EXIST_MEDIA_DATA(46001, "不存在媒体数据"),
                        NOT_EXIST_MENU_VERSION(46002, "不存在的菜单版本"),
                        NOT_EXIST_MENU_DATA(46003, "不存在的菜单数据"),
                        NOT_EXIST_USER(46004, "不存在的用户"),
                        JSON_OR_XML_ERROR(47001, "解析JSON/XML内容错误"),
                        API_NOT_ALLOW_CALL(48001, "api功能未授权"),
                        OPENID_APPID_NOT_MATCH(49003, "传入的openid不属于此AppID"),
                        USER_NOT_ALLOW_API(50001, "用户未授权该api"),
                        USER_USE_LIMIT(50002, "用户受限，可能是违规后接口被封禁"),
                        INVALID_PARAM(61451, "参数错误(invalid parameter)"),
                        INVALID_ACCOUNT(61452, "无效客服账号(invalid kf_account)"),
                        ACCOUNT_EXISTS(61453, "客服帐号已存在(kf_account existed)"),
                        ACCOUNT_TOO_LONG(61454, "客服帐号名长度超过限制(仅允许10个英文字符，不包括@及@后的公众号的微信号)(invalid kf_acount length)"),
                        ILLEGAL_ACCOUNT_CHARACTER(61455, "客服帐号名包含非法字符(仅允许英文+数字)(illegal character in kf_account)"),
                        ACCOUNT_TOO_MANY(61456, "客服帐号个数超过限制(10个客服账号)(kf_account count exceeded)"),
                        INVALID_FILE_TYPE(61457, "无效头像文件类型(invalid file type)"),
                        SYSTEM_ERROR(61450, "系统错误(system error)"),
                        DATE_FORMAT_ERROR(61500, "日期格式错误"),
                        DATE_RANGE_ERROR(61501, "日期范围错误"),
                        ILLEGAL_POST_PARAM(9001001, "POST数据参数不合法"),
                        REMOTE_SERVER_ERROR(9001002, "远端服务不可用"),
                        ILLEGAL_TICKET(9001003, "Ticket不合法"),
                        OTHER_ERROR(99999, "其他错误");

    Integer code;
    String  description;

    private ResultType(final Integer code, final String description) {
        this.code = code;
        this.description = description;
    }

    public static ResultType get(final String code) {
        BeanUtil.requireNonNull((Object) code, "code is null");
        final ResultType[] arr$ = values();
        for (final ResultType resultType : arr$) {
            if (code.equals(resultType.getCode().toString())) {
                return resultType;
            }
        }
        return null;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "ResultType{code=" + this.code + ", description='" + this.description
               + '\'' + '}';
    }
}