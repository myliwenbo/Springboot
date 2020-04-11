package vip.xjdai.demo.thread.demo;

import java.util.concurrent.CountDownLatch;

public class TestBingfa
{
    //发送请求的url地址
    private final        String url    = "http://localhost:8085/bda-search";
    //模拟的并发量
    private static final int    BINGFA = 199;

    private static CountDownLatch cdl = new CountDownLatch(BINGFA);

    public static void main(String[] args)
    {
        for (int i = 0; i < BINGFA; i++) {
            new Thread(new UserRequest()).start();
            cdl.countDown();
        }
    }

    public static class UserRequest implements Runnable
    {
        @Override
        public void run()
        {
            try {
                cdl.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //使用工具类发送http请求
//            String json2 = HttpClientUtil.sendHttpPostJson(url, getJson());
//            System.out.println(new Date().getTime() + "::" + json2);
        }

    }

    //发送的请求参数
    public static String getJson()
    {
        return null;
    }
}