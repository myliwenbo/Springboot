package vip.xjdai.ioc.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vip.xjdai.ioc.xml.set_.SpringActionSet;
import vip.xjdai.ioc.xml.static_factory_.SpringActionFactory;
import vip.xjdai.ioc.xml.statoc_.MongoFileOperationUtil;

@Controller
@RequestMapping("/statcitest")
public class StaticBeanInjectXML {

    @Autowired
    private MongoFileOperationUtil mongoFileOperationUtil;

    @Autowired
    private SpringActionSet        springAction;

    @Autowired
    private SpringActionFactory    springActionFactory;

    @RequestMapping(value = "/staticTest.json", method = RequestMethod.GET)
    @ResponseBody
    public void test() {
        System.out.println(mongoFileOperationUtil.getDsForRW());

    }

    @RequestMapping(value = "/setTest.json", method = RequestMethod.GET)
    @ResponseBody
    public void test2() {
        springAction.ok();
    }

    @RequestMapping(value = "/staticFactoryTest.json", method = RequestMethod.GET)
    @ResponseBody
    public void test3() {
        springActionFactory.staticFactoryOk();

    }
}
