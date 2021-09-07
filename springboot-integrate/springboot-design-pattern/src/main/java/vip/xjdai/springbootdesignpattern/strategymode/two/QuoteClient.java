package vip.xjdai.springbootdesignpattern.strategymode.two;

import java.math.BigDecimal;

//外部客户端
public class QuoteClient {

    public static void main(String[] args) {
        //1.创建具体测策略实现
        //2.在创建策略上下文的同时，将具体的策略实现对象注入到策略上下文当中
        QiuntContext ctx = new QiuntContext(new NewCustomer("123.9"));
        //3.调用上下文对象的方法来完成对具体策略实现的回调
        BigDecimal bigDecimal = ctx.algorithmMethod();
        System.out.println("折扣后金额："+bigDecimal.toString());
    }

}

