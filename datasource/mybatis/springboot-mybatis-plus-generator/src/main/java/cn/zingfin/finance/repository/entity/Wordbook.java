package cn.zingfin.finance.repository.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import vip.xjdai.common.BaseDo;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author quyl
 * @since 2020-02-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Wordbook extends BaseDo<Wordbook> {

    private static final long serialVersionUID=1L;

    private String ext;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String twordbookType;

    /**
     * 字典名称
     */
    private String twordbookName;

    /**
     * 字典值
     */
    private String twordbookValue;


    public static final String EXT = "ext";

    public static final String NAME = "name";

    public static final String TWORDBOOK_TYPE = "twordbook_type";

    public static final String TWORDBOOK_NAME = "twordbook_name";

    public static final String TWORDBOOK_VALUE = "twordbook_value";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
