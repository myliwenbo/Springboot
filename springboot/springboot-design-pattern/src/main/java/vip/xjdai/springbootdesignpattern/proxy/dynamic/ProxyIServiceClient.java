package vip.xjdai.springbootdesignpattern.proxy.dynamic;


public class ProxyIServiceClient {

    public static void main(String[] args) {
        ProxyIService proxy = (ProxyIService) MyProxyFactory.getProxy(new ProxyIServiceImpl());
        proxy.sing();
    }
}
