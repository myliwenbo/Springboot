package vip.xjdai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liwenbo
 * @since 2019-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value="UserEntity对象", description="")
public class UserEntity extends Model<UserEntity> {

    private static final long serialVersionUID=1L;

    @TableId(value = "tb_user_id", type = IdType.AUTO)
    private Integer userId;

    @TableField("tb_user_name")
    private String userName;

    @TableField("tb_password")
    private String password;

    @TableField("tb_phone")
    private String phone;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
