package cn.zingfin.finance.repository.vo;


import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author 良田美地天下第一牛逼
 * @since 2020-04-27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileManageVo extends BaseVo {

@NotNull(message = "ID不能传递为空", groups = {Update.class, Delete.class, Select.class})
private Long id;


    @ApiModelProperty(value = "扩充字段")
private String ext;

    @ApiModelProperty(value = "是否是图片")
private Boolean img;

    @ApiModelProperty(value = "文件URL")
private String fileUrl;

    @ApiModelProperty(value = "文件大小")
private Long fileSize;

    @ApiModelProperty(value = "用户ID")
private Long createId;

    @ApiModelProperty(value = "组织ID")
private Long orgId;

@ApiModelProperty(value = "修改日期")
private Long opTime;
@ApiModelProperty(value = "创建日期")
private Long createTime;
}
