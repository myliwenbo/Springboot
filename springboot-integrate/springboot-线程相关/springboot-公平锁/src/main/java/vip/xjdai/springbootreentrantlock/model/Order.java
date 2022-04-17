package vip.xjdai.springbootreentrantlock.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "`order`")
public class Order {
    public static final String COL_STOCK = "stock";
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 商品名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 订单数量
     */
    @TableField(value = "`number`")
    private Long number;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_NUMBER = "number";

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
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取订单数量
     *
     * @return number - 订单数量
     */
    public Long getNumber() {
        return number;
    }

    /**
     * 设置订单数量
     *
     * @param number 订单数量
     */
    public void setNumber(Long number) {
        this.number = number;
    }
}