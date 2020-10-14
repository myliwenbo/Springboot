package vip.xjdai.clazz;

//在实例化泛型类时，必须指定T的具体类型
public class Generic<T> {
    //key这个成员变量的类型为T
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public static void main(String[] args) {
        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<>("123");
        String key = genericString.getKey();
    }
}
