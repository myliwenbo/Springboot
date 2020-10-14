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
 * 分类表
 * </p>
 *
 * @author 良田美地天下第一牛逼
 * @since 2020-04-28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TestCategoryVo extends BaseVo {

@NotNull(message = "ID不能传递为空", groups = {Update.class, Delete.class, Select.class})
private Long id;


    @ApiModelProperty(value = "扩充字段")
private String ext;

    @ApiModelProperty(value = "分类名称")
private String name;

    @ApiModelProperty(value = "父id")
private Long parentId;

    @ApiModelProperty(value = "跟节点id")
private Long rootId;

    @ApiModelProperty(value = "是否显示")
private Boolean show;

@ApiModelProperty(value = "修改日期")
private Long opTime;
@ApiModelProperty(value = "创建日期")
private Long createTime;
}
