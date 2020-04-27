package cn.lwb.json.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//序列化时处理一些字段
//NON_NULL      属性为NULL 不序列化
//NON_DEFAULT   属性为默认值不序列化
//NON_EMPTY     属性为 空（''） 或者为 NULL 都不序列化
@JsonInclude(value = Include.NON_NULL)

//在反序列化的时候忽略那些无法被设置的属性，或者序列化的时候忽略掉不能设置值的属性
@JsonIgnoreProperties(ignoreUnknown = true)

//序列化进行排序
@JsonPropertyOrder(value = { "sssssssss", "name", "age", "password", "md5Password",
                             "secretKey", })
public class UserSuper {

    private String name;

    private String age;

    private String jsonInclude;

    /**
     * 序列化为另外一个名称
     */
    @JsonProperty(value = "userSuper")
    private String sssssssss;

    /**
     * 序列化的时候嵌入我们自己的代码
     */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private String password;

    /**
     * 反序列化的时候嵌入我们自己的代码
     */
    @JsonDeserialize(using = CustomMD5StringDeserialize.class)
    private String md5Password;

    /**
     * 被该注解修饰的属性或者get/set方法在反序列或者序列化的时候都会处理掉
     */
    @JsonIgnore
    private String secretKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getJsonInclude() {
        return jsonInclude;
    }

    public void setJsonInclude(String jsonInclude) {
        this.jsonInclude = jsonInclude;
    }

    public String getMd5Password() {
        return md5Password;
    }

    public void setMd5Password(String md5Password) {
        this.md5Password = md5Password;
    }

    public String getSssssssss() {
        return sssssssss;
    }

    public void setSssssssss(String sssssssss) {
        this.sssssssss = sssssssss;
    }
    
    

}
