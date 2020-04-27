package vip.xjdai.proxy.staticp;

//被代理的对象，
class ProxyIServiceImpl implements ProxyIService {

    @Override
    public void sing() {
        System.out.println("刘德华唱歌");
    }

}