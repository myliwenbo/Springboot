package vip.xjdai.springbootcommons.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_dictionary")
public class Dictionary {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "`type`")
    private String type;

    @TableField(value = "`data`")
    private String data;

    @TableField(value = "display_order")
    private Integer displayOrder;

    public static final String COL_ID = "id";

    public static final String COL_TYPE = "type";

    public static final String COL_DATA = "data";

    public static final String COL_DISPLAY_ORDER = "display_order";
}