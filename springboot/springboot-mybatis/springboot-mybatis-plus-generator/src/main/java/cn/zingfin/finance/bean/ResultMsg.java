package cn.zingfin.finance.bean;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ResultMsg<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String msg;
    private boolean success;
    private int errorCode;
    private T result;

}