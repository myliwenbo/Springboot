package vip.xjdai.proxy.dynamic;

import vip.xjdai.proxy.staticp.ProxyIServiceManager;

public class ProxyIServiceClient {

    public static void main(String[] args) {
        ProxyIService proxy = (ProxyIService) MyProxyFactory.getProxy(new ProxyIServiceImpl());
        proxy.sing();
    }
}
