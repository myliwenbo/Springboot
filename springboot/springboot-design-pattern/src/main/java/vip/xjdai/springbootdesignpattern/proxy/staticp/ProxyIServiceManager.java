package vip.xjdai.springbootdesignpattern.proxy.staticp;

/**
 * 静态代理类管理类
 */
public class ProxyIServiceManager implements ProxyIService {


    private ProxyIService proxyIService;

    public ProxyIServiceManager(ProxyIService proxyIService) {
        this.proxyIService = proxyIService;
    }

    //增强方法
    @Override
    public void sing() {
        System.out.println("慈善演唱");
        proxyIService.sing();
        System.out.println("谢幕");
    }


}
