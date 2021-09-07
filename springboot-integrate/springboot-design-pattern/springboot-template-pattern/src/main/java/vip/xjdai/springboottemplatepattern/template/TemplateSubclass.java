package vip.xjdai.springboottemplatepattern.template;

public class TemplateSubclass extends TemplateSuper {

    public static void main(String[] args) {
        TemplateSubclass value = new TemplateSubclass();
        value.supserTemplateMethod();
    }

    /**
     * 定义钩子方法，让子类去实现
     *
     * @return
     */
    @Override
    public String templateMethod() {
        return "子类实现";
    }
}
