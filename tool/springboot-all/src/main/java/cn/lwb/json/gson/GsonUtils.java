package cn.lwb.json.gson;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonUtils {

    private static final Gson gson  = new Gson();

    //注意这里的Gson的构建方式为GsonBuilder,区别于test1中的Gson gson = new Gson();
    private static final Gson gsonB = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()                                                                //不导出实体中没有用@Expose注解的属性
        .enableComplexMapKeySerialization()                                                                    //支持Map的key为复杂对象的形式
        .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")                                             //时间转化为特定格式  
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)                                              //会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
        .setPrettyPrinting()                                                                                   //对json结果格式化.
        .setVersion(1.0)                                                                                       //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
        .create();                                                                                             //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.

    public static String pojo2Json(Object pojo) {
        String json = gson.toJson(pojo);
        System.out.println(json);
        return json;

    }

    public static void getGsonB() {
        gsonB.toString();
    }

    public static <T> T pojo2Json(String text, Class<T> classT) {
        return gson.fromJson(text, classT);
    }

    /**
     * json转List
     * @param <clazz>
     * @param <T>
     * @param text
     * @param t
     * @return
     */
    public static <clazz> List<clazz> json2List(String text, Class<?> clazz) {
        Type type = new TypeToken<List<clazz>>() {
        }.getType();
        return gson.fromJson(text, type);
    }

    /**
     * 返回特定的对象
     * @param json
     * @param clazz
     * @return
     */
    public static <clazz> CommonJson4List<clazz> fromJson(String json, Class<?> clazz) {
        Type type = new TypeToken<CommonJson4List<clazz>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
