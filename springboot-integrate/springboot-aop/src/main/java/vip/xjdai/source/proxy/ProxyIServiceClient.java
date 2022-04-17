package vip.xjdai.source.proxy;

public class ProxyIServiceClient {

    public static void main(String[] args) {
        ProxyIService proxy = (ProxyIService) MyProxyFactory.getProxy(new ProxyIServiceImpl());
        proxy.sing();
    }
}
