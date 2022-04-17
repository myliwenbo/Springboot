package vip.xjdai.springbootcommons.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_diners")
public class Diners {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "username")
    private String username;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "`password`")
    private String password;

    /**
     * 头像
     */
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * 角色
     */
    @TableField(value = "roles")
    private String roles;

    @TableField(value = "is_valid")
    private Boolean isValid;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "update_date")
    private Date updateDate;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_PHONE = "phone";

    public static final String COL_EMAIL = "email";

    public static final String COL_PASSWORD = "password";

    public static final String COL_AVATAR_URL = "avatar_url";

    public static final String COL_ROLES = "roles";

    public static final String COL_IS_VALID = "is_valid";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_UPDATE_DATE = "update_date";
}