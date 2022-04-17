package vip.xjdai.annotation.RestController;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("requestScope")
@RequestScope
public class ServiceScorp implements DisposableBean {

    public ServiceScorp() {
        System.out.println(this);
    }

    @RequestMapping("test")
    public void test() {
        System.out.println("1");
    }

    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     *
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("我被销毁啦");
    }
}
