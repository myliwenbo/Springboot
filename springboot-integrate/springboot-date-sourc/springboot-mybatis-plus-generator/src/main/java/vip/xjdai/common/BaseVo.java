package vip.xjdai.common;

import cn.vihost.farmplatform.core.util.BeanCopyUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Data
@ApiIgnore
public class BaseVo {
    public interface Add {
    }

    public interface Update {
    }

    public interface Delete {
    }

    public interface Select {
    }

    @ApiModelProperty(value = "当前页")
    private Long current = 1L;
    @ApiModelProperty(value = "条数")
    private Long size = 10L;
    @ApiModelProperty(value = "总条数")
    private Long total;
    @ApiModelProperty(value = "总页数")
    private Long pages;


    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class BasePage<T> extends BaseVo {

        @ApiModelProperty(value = "分页数据")
        private List<T> list = Lists.newArrayList();
    }

    public static <T, B> BaseVo.BasePage<T> bindPage(IPage<B> page, Class<T> clazz) {
        BaseVo.BasePage<T> basePage = new BaseVo.BasePage<>();
        basePage.setCurrent(page.getCurrent());
        basePage.setSize(page.getSize());
        basePage.setPages(page.getPages());
        basePage.setTotal(page.getTotal());
        List<B> records = page.getRecords();
        if (!CollectionUtils.isEmpty(records)) {
            basePage.setList(BeanCopyUtil.copyListNotNull(records, clazz));
        } else {
            basePage.setList(Lists.newArrayList());
        }
        return basePage;
    }



    @JsonIgnore
    public <T> Page<T> getPage() {
        return new Page<>(this.getCurrent(), this.getSize());
    }



}
