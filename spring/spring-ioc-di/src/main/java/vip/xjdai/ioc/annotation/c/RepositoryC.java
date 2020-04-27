/**
 * 
 */
package vip.xjdai.ioc.annotation.c;

import org.springframework.stereotype.Repository;

/**
 * @author lwb
 *
 */

@Repository
public class RepositoryC {

    public RepositoryC() {
        System.out.println("初始化：" + this.getClass().getName());
    }

    public void test() {
        System.out.println("我是:" + this.getClass().getPackage() + "下的方法");
    }

}
