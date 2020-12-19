package vip.xjdai.springbootdesignpattern.Filter.three;

import vip.xjdai.springbootdesignpattern.Filter.two.HtmlFilter;
import vip.xjdai.springbootdesignpattern.Filter.two.SensitiveFilter;x

/**
 * 第三个版本是将过滤器键和处理器进行了分离
 */
public class MainClass {

    public static void main(String[] args) {

        //需要被过滤的语句

        String msg = "被就业了：），敏感信息，<script>";
        //搞一个过过滤链
        FilterChain chain = new FilterChain();
        chain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
        //实例化处理类
        MsgProcessor mp = new MsgProcessor(msg, chain);
        String r = mp.process();
        System.out.println(r);

    }

}
 