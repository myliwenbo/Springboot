package cn.zingfin.finance.repository.vo;


import cn.zingfin.finance.repository.entity.TestCategory;
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
public class TestCategoryTdo extends TestCategory {

}
