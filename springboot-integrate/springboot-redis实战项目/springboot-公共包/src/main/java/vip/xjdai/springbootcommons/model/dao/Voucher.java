package vip.xjdai.springbootcommons.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "t_voucher")
public class Voucher {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 代金券标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 缩略图
     */
    @TableField(value = "thumbnail")
    private String thumbnail;

    /**
     * 抵扣金额
     */
    @TableField(value = "amount")
    private Integer amount;

    /**
     * 售价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * -1=过期 0=下架 1=上架
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 过期时间
     */
    @TableField(value = "expire_time")
    private Date expireTime;

    /**
     * 验证餐厅
     */
    @TableField(value = "redeem_restaurant_id")
    private Integer redeemRestaurantId;

    /**
     * 库存
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 剩余数量
     */
    @TableField(value = "stock_left")
    private Integer stockLeft;

    /**
     * 描述信息
     */
    @TableField(value = "description")
    private String description;

    /**
     * 使用条款
     */
    @TableField(value = "clause")
    private String clause;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "update_date")
    private Date updateDate;

    @TableField(value = "is_valid")
    private Boolean isValid;

    public static final String COL_ID = "id";

    public static final String COL_TITLE = "title";

    public static final String COL_THUMBNAIL = "thumbnail";

    public static final String COL_AMOUNT = "amount";

    public static final String COL_PRICE = "price";

    public static final String COL_STATUS = "status";

    public static final String COL_EXPIRE_TIME = "expire_time";

    public static final String COL_REDEEM_RESTAURANT_ID = "redeem_restaurant_id";

    public static final String COL_STOCK = "stock";

    public static final String COL_STOCK_LEFT = "stock_left";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_CLAUSE = "clause";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_UPDATE_DATE = "update_date";

    public static final String COL_IS_VALID = "is_valid";
}