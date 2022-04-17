package vip.xjdai.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import lombok.Data;

@Data
@TableName(value = "stock")
public class Stock {
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "NAME")
    private String name;

    @TableField(value = "int_Value")
    private String intValue;

    /**
     * 乐观锁
     */
    @TableField(value = "REVISION", fill = FieldFill.INSERT_UPDATE)
    @Version
    private Integer revision;

    /**
     * 创建人
     */
    @TableField(value = "CREATED_BY", fill = FieldFill.INSERT_UPDATE)
    private String createdBy;

    /**
     * 逻辑删除
     */
    @TableField(value = "IS_del", fill = FieldFill.INSERT_UPDATE)
    @TableLogic
    private String isDel;

    /**
     * 创建时间
     */
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date createdTime;

    /**
     * 更新人
     */
    @TableField(value = "UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    public static final String COL_ID = "ID";

    public static final String COL_NAME = "NAME";

    public static final String COL_INT_VALUE = "int_Value";

    public static final String COL_REVISION = "REVISION";

    public static final String COL_CREATED_BY = "CREATED_BY";

    public static final String COL_IS_DEL = "IS_del";

    public static final String COL_CREATED_TIME = "CREATED_TIME";

    public static final String COL_UPDATED_BY = "UPDATED_BY";

    public static final String COL_UPDATED_TIME = "UPDATED_TIME";
}