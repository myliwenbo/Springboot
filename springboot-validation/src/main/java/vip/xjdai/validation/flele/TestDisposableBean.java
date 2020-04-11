package vip.xjdai.validation.flele;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * 在销毁Bean的时候
 *
 * @author lwb
 */
@Component
public class TestDisposableBean implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("测试 Bean 已销毁 ...");

    }

}