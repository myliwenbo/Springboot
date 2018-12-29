package vip.xjdai.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class TestController {

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(BlogAction.class);

    @RequestMapping(value = "/log",method = RequestMethod.POST)
    public void countOrder()
    {
      for (int i = 0 ; i <10000 ; i++) {
        logger.info("初始化-_-");
        logger.error("错误!!!!!");
        logger.debug ("debug 成了");
        logger.warn ("警告!!!");
      }
    }

}
