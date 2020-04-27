package vip.xjdai.model;

import lombok.Data;

@Data
public class BaseResult< T >
{
    private Object data;

    public static < T > BaseResult< T > NewBaseResult(T t)
    {
        BaseResult< T > br = new BaseResult< T >();
        br.setData(t);
        return br;
    }
}
