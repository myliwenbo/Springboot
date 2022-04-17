package vip.xjdai.springbootcommons.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_voucher_order")
public class VoucherOrder {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "order_no")
    private Integer orderNo;

    @TableField(value = "fk_voucher_id")
    private Integer fkVoucherId;

    @TableField(value = "fk_diner_id")
    private Integer fkDinerId;

    /**
     * 图片地址
     */
    @TableField(value = "qrcode")
    private String qrcode;

    /**
     * 0=微信支付 1=支付宝支付
     */
    @TableField(value = "payment")
    private Byte payment;

    /**
     * 订单状态：-1=已取消 0=未支付 1=已支付 2=已消费 3=已过期
     */
    @TableField(value = "`status`")
    private Boolean status;

    /**
     * 如果是抢购订单时，抢购订单的id
     */
    @TableField(value = "fk_seckill_id")
    private Integer fkSeckillId;

    /**
     * 订单类型：0=正常订单 1=抢购订单
     */
    @TableField(value = "order_type")
    private Integer orderType;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "update_date")
    private Date updateDate;

    @TableField(value = "is_valid")
    private Integer isValid;

    public static final String COL_ID = "id";

    public static final String COL_ORDER_NO = "order_no";

    public static final String COL_FK_VOUCHER_ID = "fk_voucher_id";

    public static final String COL_FK_DINER_ID = "fk_diner_id";

    public static final String COL_QRCODE = "qrcode";

    public static final String COL_PAYMENT = "payment";

    public static final String COL_STATUS = "status";

    public static final String COL_FK_SECKILL_ID = "fk_seckill_id";

    public static final String COL_ORDER_TYPE = "order_type";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_UPDATE_DATE = "update_date";

    public static final String COL_IS_VALID = "is_valid";
}