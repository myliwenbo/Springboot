package vip.xjdai.common;

import cn.vihost.farmplatform.core.util.BeanCopyUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class PageInfo<T> {
    /**
     * 总数
     */
    private long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;
    /**
     * 当前页
     */
    private long current = 1;
    private long start = 0;
    /**
     * SQL 排序 ASC 数组
     */
    private String[] ascs;
    /**
     * SQL 排序 DESC 数组
     */
    private String[] descs;
    @JsonIgnore
    private List<T> records;

    public PageInfo(IPage page) {
        this(page.getCurrent(), page.getSize());
        Type superClass = getClass().getGenericSuperclass();
        this.setTotal(page.getTotal());
        Type actualTypeArgument = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        BeanCopyUtil.copyList(page.getRecords(), actualTypeArgument.getClass());
        this.setRecords(page.getRecords());
    }

    /**
     * 分页构造函数
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public PageInfo(long current, long size) {
        this(current, size, 0);
    }

    public PageInfo(long current, long size, long total) {
        this(current, size, total, true);
    }

    public PageInfo(long current, long size, boolean isSearchCount) {
        this(current, size, 0, isSearchCount);
    }

    public PageInfo(long current, long size, long total, boolean isSearchCount) {
        if (current > 1) {
            this.current = current;
        }
        this.size = size;
        this.total = total;
    }


    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public long getStart() {
        this.start = (current - 1) * size;
        return start;
    }


    /**
     * 是否存在上一页
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }
}
