package vip.xjdai.demo;

import org.junit.Test;
import vip.xjdai.demo.Three.DemoThreeService;
import vip.xjdai.demo.one.DemoOneService;
import vip.xjdai.demo.pojo.ShareItem;
import vip.xjdai.demo.pojo.ShareItemImpl;
import vip.xjdai.demo.two.DemoTwoService;
import vip.xjdai.demo.two.Link;

public class DemoOneController {
    @Test
    public void one() throws Exception {
        //初始化案例
        DemoOneService service = new DemoOneService();
        ShareItem shareItem = new ShareItemImpl();
        service.share(shareItem, null);
    }

    @Test
    public void three() throws Exception {
        //减少了大量的  null值判断
        //将if 语句抽离到最上层判断
        DemoThreeService service = new DemoThreeService();
        ShareItem shareItem = new ShareItemImpl();
        service.share(shareItem, null);
    }

    public void two() throws Exception {
        DemoTwoService service = new DemoTwoService();
        //利用多态的方式处理这个问题，将具体的业务由具体的类来实现，彻底的
        vip.xjdai.demo.two.ShareItem link = new Link("", "", "");
        service.share(link, null);

    }


}
