package vip.xjdai.springbootshushionetest.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CodeDataResult<T> implements Serializable {
    Long scanId;
    T data;
    Integer size;
}
