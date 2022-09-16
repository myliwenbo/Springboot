package vip.xjdai.springbootjaxb.demo3;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * null值标签输出器~~~
 * 使用：    @XmlJavaTypeAdapter(value = DataAdapter.class)在需要过滤的属性上加上该注解
 */
public class DataAdapter extends XmlAdapter< Object, Object >
{
    //java→xml时的处理，ob是Java生成xml时传入的属性值，ob可以数组、集合等其它复杂类型，
    //在这个方法中可以对其进行处理，return返回需要的结果类型
    @Override
    public String marshal(Object ob) throws Exception
    {
        System.out.println(ob.toString());
        return "";
    }

    //xml→java时的处理
    @Override
    public Object unmarshal(Object arg0) throws Exception
    {
        // TODO Auto-generated method stub
        return arg0;
    }
}