package vip.xjdai.common.utils;

import java.lang.reflect.Field;

import vip.xjdai.common.domain.BaseModel;

/**
 * 反射工具类
 *
 * @author lwb
 */
public class ReflectionUtil {

    public static Class<? extends Object> getSupperClass(Class<? extends Object> clazz, Class<?> supperClass) {
        Class<? extends Object> clazz1 = clazz;
        while (true) {
            Class<?> superclass = clazz1.getSuperclass();
            if (ifObject(superclass)) {
                return clazz;
            } else if (superclass == supperClass) {
                return superclass;
            } else {
                clazz1 = clazz1.getSuperclass();
            }

        }
    }

    public static Class<? extends Object> getBaseModelClass(Class<? extends Object> clazz) {
        return getSupperClass(clazz, BaseModel.class);

    }

    public static <T> T getSuperclass(T object, Object user) {
        if (object == null) {
            return null;
        }
        Class<? extends Object> superclass = getBaseModelClass(object.getClass());
        if (ifObject(superclass)) {
            return object;
        }
        //获取父类的所有属性
        Field[] fields = superclass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == user.getClass()) {
                try {
                    field.setAccessible(true);
                    field.set(object, user);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }

    private static Boolean ifObject(Class<? extends Object> superclass) {
        if (superclass == Object.class) {
            return true;
        }
        return false;
    }

}
