package vip.xjdai.javabase.Overload.Override;

/**
 * 重载
 */
public class OverloadDemo {

    public void test() throws Exception {
    }

    // 错误 ： 修饰符不能作为方法标签
    // private void test() throws Exception {
    //
    // }

    // 错误 ： 返回值不能 作为方法标签
    // public Map test() throws Exception {
    //     return null;
    // }

    // 正常 可以通过参数
    private Integer test(Integer integer) throws Exception {
        System.out.println("Integer");
        return 3;
    }

    public int test(int integer) throws Exception {
        System.out.println("int");
        return integer;

    }

    public static void main(String[] args) throws Exception {
        OverloadDemo overrideDemo = new OverloadDemo();
        System.out.println(overrideDemo.test(1));
    }

}
