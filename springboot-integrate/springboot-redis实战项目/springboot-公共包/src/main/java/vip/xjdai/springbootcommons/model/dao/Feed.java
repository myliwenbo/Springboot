package vip.xjdai.springbootcommons.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_feed")
public class Feed {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    @TableField(value = "fk_diner_id")
    private Integer fkDinerId;

    /**
     * 点赞数量
     */
    @TableField(value = "praise_amount")
    private Integer praiseAmount;

    /**
     * 评论数量
     */
    @TableField(value = "comment_amount")
    private Integer commentAmount;

    @TableField(value = "fk_restaurant_id")
    private Integer fkRestaurantId;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "update_date")
    private Date updateDate;

    @TableField(value = "is_valid")
    private Boolean isValid;

    public static final String COL_ID = "id";

    public static final String COL_CONTENT = "content";

    public static final String COL_FK_DINER_ID = "fk_diner_id";

    public static final String COL_PRAISE_AMOUNT = "praise_amount";

    public static final String COL_COMMENT_AMOUNT = "comment_amount";

    public static final String COL_FK_RESTAURANT_ID = "fk_restaurant_id";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_UPDATE_DATE = "update_date";

    public static final String COL_IS_VALID = "is_valid";
}