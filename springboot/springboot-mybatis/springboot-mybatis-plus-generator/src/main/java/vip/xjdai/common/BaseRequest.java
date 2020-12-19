package vip.xjdai.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 分页--
 *
 */
public class BaseRequest extends Page {

    @JsonIgnore
    public <T> Page<T> getPage() {
        return new Page<>(this.getCurrent(), this.getSize());
    }


}
