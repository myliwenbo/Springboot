/**
 * 
 */
package vip.xjdai.pojo;

/**
 * @author lwb
 *
 */
public class User {
    private String name;
    private String age;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the age
     */
    public String getAge()
    {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age)
    {
        this.age = age;
    }

    /**
     * @param name
     * @param age
     */
    public User(String name, String age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * 
     */
    public User() {
        // TODO Auto-generated constructor stub
    }

}
