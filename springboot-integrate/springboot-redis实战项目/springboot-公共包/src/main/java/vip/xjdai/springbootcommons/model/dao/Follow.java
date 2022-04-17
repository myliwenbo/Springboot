package vip.xjdai.springbootcommons.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_follow")
public class Follow {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "diner_id")
    private Integer dinerId;

    @TableField(value = "follow_diner_id")
    private Integer followDinerId;

    @TableField(value = "is_valid")
    private Boolean isValid;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "update_date")
    private Date updateDate;

    public static final String COL_ID = "id";

    public static final String COL_DINER_ID = "diner_id";

    public static final String COL_FOLLOW_DINER_ID = "follow_diner_id";

    public static final String COL_IS_VALID = "is_valid";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_UPDATE_DATE = "update_date";
}