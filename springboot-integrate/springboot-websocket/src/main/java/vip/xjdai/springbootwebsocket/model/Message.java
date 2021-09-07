package vip.xjdai.springbootwebsocket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "message")
public class Message {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 消息
     */
    @TableField(value = "message")
    private String message;

    /**
     * 审批人
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 消息状态 1. 未审批 2.已审批
     */
    @TableField(value = "message_status")
    private Long messageStatus;

    public static final String COL_ID = "id";

    public static final String COL_MESSAGE = "message";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_MESSAGE_STATUS = "message_status";
}