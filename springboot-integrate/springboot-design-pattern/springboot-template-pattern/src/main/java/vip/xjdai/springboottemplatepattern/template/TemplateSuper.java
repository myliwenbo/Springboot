package vip.xjdai.springboottemplatepattern.template;

/**
 * 定义一个抽象类
 */
public abstract class TemplateSuper {


    /**
     * 定义一个模板的公共方法
     */
    public void supserTemplateMethod() {
        System.out.println("公共方法逻辑内容");
        // 钩子方法，子类去实现
        String s = templateMethod();
        System.out.println("公共方法逻辑内容：" + s);
    }

    /**
     * 定义钩子方法，让子类去实现
     *
     * @return
     */
    public abstract String templateMethod();
}
