package vip.xjdai.proxy.staticp;

public class ProxyIServiceClient {

    public static void main(String[] args) {
        ProxyIServiceManager proxyIServiceManager = new ProxyIServiceManager(new ProxyIServiceImpl());
        proxyIServiceManager.sing();
    }
}
