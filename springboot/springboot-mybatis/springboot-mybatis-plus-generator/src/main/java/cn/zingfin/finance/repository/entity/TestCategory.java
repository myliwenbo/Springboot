package cn.zingfin.finance.repository.entity;


import vip.xjdai.common.BaseDo;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author 良田美地天下第一牛逼
 * @since 2020-04-28
 */
@Data
    @EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TestCategory extends BaseDo<TestCategory> {

private static final long serialVersionUID=1L;

        /**
         * 扩充字段
         */
        private String ext;

        /**
         * 分类名称
         */
        private String name;

        /**
         * 父id
         */
        private Long parentId;

        /**
         * 跟节点id
         */
        private Long rootId;

        /**
         * 是否显示
         */
    @TableField("is_show")
        private Boolean show;


    public static final String EXT ="ext";

    public static final String NAME ="name";

    public static final String PARENT_ID ="parent_id";

    public static final String ROOT_ID ="root_id";

    public static final String IS_SHOW ="is_show";

@Override
protected Serializable pkVal(){
            return null;
        }

        }
