package vip.xjdai.responsibility;

public class HandlerClient {


    public static class HanderA extends Handler {

        @Override
        protected void handlerProcess() {
            System.out.println("处理请求数据");
        }
    }

    public static class HanderB extends Handler {
        @Override
        protected void handlerProcess() {
            System.out.println("处理时间B");
        }
    }

    public static class HanderC extends Handler {
        @Override
        protected void handlerProcess() {
            System.out.println("处理时间C");
        }
    }

    public static void main(String[] args) {
        HanderA handerA = new HanderA();
        Handler handler = new HanderB().setSucessor(new HanderC().setSucessor(new HanderC().setSucessor(new HanderA())));
        handerA.setSucessor(handler);
        handerA.execute();// 执行函数

    }
}
