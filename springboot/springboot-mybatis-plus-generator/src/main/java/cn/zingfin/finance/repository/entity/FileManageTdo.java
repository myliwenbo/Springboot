package cn.zingfin.finance.repository.vo;


import cn.zingfin.finance.repository.entity.FileManage;
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
public class FileManageTdo extends FileManage {

}
