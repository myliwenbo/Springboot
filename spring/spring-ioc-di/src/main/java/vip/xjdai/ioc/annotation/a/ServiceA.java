/**
 * 
 */
package vip.xjdai.ioc.annotation.a;

import org.springframework.stereotype.Service;

/**
 * @author lwb
 *
 */
@Service
public class ServiceA {

    public void test() {
        System.out.println("调用方法：" + this.getClass().getName() + ".test");
    }

    public ServiceA() {
        System.out.println("初始化：" + this.getClass().getName());
    }

}
