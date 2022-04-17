package vip.xjdai.javatoxml.demo1;

public class Demo {

    public static void main(String[] args) {
        Req<EchoBody> req1 = new Req<>();
        req1.setHeader("header");
        req1.setValue(new EchoBody("key"));
        Req<ReqTwo> req2 = new Req<>();
        req2.setHeader("header");
        req2.setValue(new ReqTwo("j", "k"));
        XMLUtils.beanToXml(req1);
        XMLUtils.beanToXml(req2);

    }
}
