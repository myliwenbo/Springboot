package vip.xjdai.springbootpropertysource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vip.xjdai.springbootpropertysource.config.PropertySourceDemo;
import vip.xjdai.springbootpropertysource.config.PropertySourceDemo2;

@ComponentScan("vip.xjdai")
public class SpringbootPropertySourceApplication {


    public static void main(String[] args) {
//        SpringbootPropertySourceApplication.noBeanPropertySource();
        SpringbootPropertySourceApplication.existBeanPropertySource();
    }

    public static void noBeanPropertySource() {
        //初始化入口
        AnnotationConfigApplicationContext ax = new AnnotationConfigApplicationContext(SpringbootPropertySourceApplication.class);
        //由于该Bean并没有被纳入到 spring 容器中去 所以也不用谈对应的属性了..
        PropertySourceDemo bean = ax.getBean(PropertySourceDemo.class);
        System.out.println(bean);
    }

    public static void existBeanPropertySource() {
        //初始化入口
        AnnotationConfigApplicationContext ax = new AnnotationConfigApplicationContext(SpringbootPropertySourceApplication.class);
        //由于该Bean并没有被纳入到 spring 容器中去 所以也不用谈对应的属性了..
        PropertySourceDemo2 bean = ax.getBean(PropertySourceDemo2.class);
        System.out.println(ax.getEnvironment().getProperty("zhangsan"));
        // 存在输出乱码问题，看了一下内存中的数据，好像是存进去就乱码了..干
        // 修复一下 IDEA --> 参考：https://blog.csdn.net/zhangjianming2018/article/details/103209132
    }

}
