package vip.xjdai.springbootdesignpattern.responsibility;

import com.google.common.collect.Lists;

public class ChainClient {


    public static void main(String[] args) {

        Chain chain = new Chain(Lists.newArrayList(
                new ChainHandelerA(),
                new ChainHandelerB(),
                new ChainHandelerC(),
                new ChainHandelerD(),
                new ChainHandelerD()));
        chain.execute();

    }

    public static class ChainHandelerA extends ChainHandler {


        @Override
        protected void handlerProcess() {
            System.out.println("执行调用链A");

        }
    }

    public static class ChainHandelerB extends ChainHandler {


        @Override
        protected void handlerProcess() {
            System.out.println("执行调用链B");

        }
    }

    public static class ChainHandelerC extends ChainHandler {


        @Override
        protected void handlerProcess() {
            System.out.println("执行调用链C");

        }
    }

    public static class ChainHandelerD extends ChainHandler {


        @Override
        protected void handlerProcess() {
            System.out.println("执行调用链D");
        }
    }
}
