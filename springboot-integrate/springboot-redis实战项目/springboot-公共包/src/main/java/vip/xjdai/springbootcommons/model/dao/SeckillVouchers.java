package vip.xjdai.springbootcommons.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_seckill_vouchers")
public class SeckillVouchers {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "fk_voucher_id")
    private Integer fkVoucherId;

    @TableField(value = "amount")
    private Integer amount;

    @TableField(value = "start_time")
    private Date startTime;

    @TableField(value = "end_time")
    private Date endTime;

    @TableField(value = "is_valid")
    private Integer isValid;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "update_date")
    private Date updateDate;

    public static final String COL_ID = "id";

    public static final String COL_FK_VOUCHER_ID = "fk_voucher_id";

    public static final String COL_AMOUNT = "amount";

    public static final String COL_START_TIME = "start_time";

    public static final String COL_END_TIME = "end_time";

    public static final String COL_IS_VALID = "is_valid";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_UPDATE_DATE = "update_date";
}