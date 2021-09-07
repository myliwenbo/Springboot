package vip.xjdai.common.domain;

import java.io.Serializable;

/**
 * 所有的POJO类需要都需要继承该类
 *
 * @author lwb
 */
public class BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5291965727241829343L;

    /**
     * isOK 判断是否分页
     */
    private String isPage;

    /**
     * 需要查询的页
     */
    private int pageSize;
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * token
     */
    private String token;
    /**
     * 排序类型（DESC / ASC）
     */
    protected String sortOrder;

    /**
     * 列排序字段名称
     */
    protected String sortField;

    public String getIsPage() {
        return isPage;
    }

    public void setIsPage(String isPage) {
        this.isPage = isPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

}
