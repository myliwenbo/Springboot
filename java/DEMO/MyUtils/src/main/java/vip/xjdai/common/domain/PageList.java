package vip.xjdai.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务分页统一反参
 *
 * @param <E> 具体的参数
 * @author lwb
 */
public class PageList<E> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1692574000432010424L;
    /**
     * 具体的分页参数
     */
    private List<E> datalist;
    /**
     * 当前页
     */
    private int page;
    /**
     * 总条数
     */
    private int items;
    /**
     *
     */
    private int itemsPerPage;

    public PageList() {
        this.datalist = new ArrayList<E>();
    }

    public int getPageCount() {
        if (this.itemsPerPage != 0) {
            return (int) Math.ceil(this.items / this.itemsPerPage);
        }
        return 0;
    }

    public PageList(final List<E> datalist) {
        this.datalist = new ArrayList<E>();
        this.datalist = datalist;
    }

    public PageList(final List<E> datalist, final int page, final int items, final int itemsPerPage) {
        this.datalist = new ArrayList<E>();
        this.datalist = datalist;
        this.page = page;
        this.items = items;
        this.itemsPerPage = itemsPerPage;
    }

    public List<E> getDatalist() {
        return this.datalist;
    }

    public void setDatalist(final List<E> datalist) {
        this.datalist = datalist;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(final int page) {
        this.page = page;
    }

    public int getItems() {
        return this.items;
    }

    public void setItems(final int items) {
        this.items = items;
    }

    public int getItemsPerPage() {
        return this.itemsPerPage;
    }

    public void setItemsPerPage(final int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
}