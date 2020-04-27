package cn.zingfin.finance.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import vip.xjdai.common.BaseDo;


import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 良田美地天下第一牛逼
 * @since 2020-04-27
 */
@Data
    @EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class FileManage extends BaseDo<FileManage> {

private static final long serialVersionUID=1L;

        /**
         * 扩充字段
         */
        private String ext;

        /**
         * 是否是图片
         */
    @TableField("is_img")
        private Boolean img;

        /**
         * 文件URL
         */
        private String fileUrl;

        /**
         * 文件大小
         */
        private Long fileSize;

        /**
         * 用户ID
         */
        private Long createId;

        /**
         * 组织ID
         */
        private Long orgId;


    public static final String EXT ="ext";

    public static final String IS_IMG ="is_img";

    public static final String FILE_URL ="file_url";

    public static final String FILE_SIZE ="file_size";

    public static final String CREATE_ID ="create_id";

    public static final String ORG_ID ="org_id";

@Override
protected Serializable pkVal(){
            return null;
        }

        }
