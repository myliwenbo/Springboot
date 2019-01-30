package cn.lwb.json.gson;

import java.io.Serializable;
import java.util.List;

public class CommonJson4List<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -369558847578246550L;

    /**
     * 是否成功
     */
    private Boolean           success;

    /**
     * 数据
     */
    private List<T>           data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}