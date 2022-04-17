package vip.xjdai.springbootreentrantlock.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
    * 产品
    */
@TableName(value = "prodect")
public class Prodect {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 库存
     */
    @TableField(value = "stock")
    private Long stock;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_STOCK = "stock";

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Long getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Long stock) {
        this.stock = stock;
    }
}