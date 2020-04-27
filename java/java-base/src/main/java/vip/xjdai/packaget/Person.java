package vip.xjdai.packaget;

/**
 * 封装演示
 */
public class Person
{
    private Integer age;

        public Integer getAge()
        {
            return age;
        }

        public void setAge(Integer age)
        {
        if (age == null || age > 199 || age < 0) {
            System.out.println("请输入正确的年龄");
            return ;
        }
        this.age = age;
    }

    public static void main(String[] args)
    {
        Person p = new Person();
        p.setAge(-1);
    }
}
