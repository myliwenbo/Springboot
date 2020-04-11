package cn.zingfin.finance.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import vip.xjdai.common.BaseDo;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author quyl
 * @since 2020-02-12
 */
@Data
public class WordbookVo  {


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


}
