package cn.zingfin.finance.bean;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BeanCopyUtil {
    public BeanCopyUtil() {
    }

    public static Object conver(Object source, Class clazz) {
        if (source == null) {
            return null;
        } else {
            try {
                Object o = clazz.newInstance();
                BeanUtils.copyProperties(source, o);
                return o;
            } catch (InstantiationException var3) {
                var3.printStackTrace();
            } catch (IllegalAccessException var4) {
                var4.printStackTrace();
            } catch (BeansException var5) {
                var5.printStackTrace();
            }

            return null;
        }
    }

    public static <T> List<T> copyList(List list, Class<T> targetClz) {
        if (!CollectionUtils.isEmpty(list) && targetClz != null) {
            List<T> result = new ArrayList(list.size());
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                Object pojo = var3.next();
                result.add(copy(pojo, targetClz));
            }

            return result;
        } else {
            return null;
        }
    }

    public static <T> List<T> copyListNotNull(List list, Class<T> targetClz) {
        if (!CollectionUtils.isEmpty(list) && targetClz != null) {
            List<T> result = new ArrayList(list.size());
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                Object pojo = var3.next();
                result.add(copy(pojo, targetClz));
            }

            return result;
        } else {
            return new ArrayList();
        }
    }

    public static <T> List<T> copyList(Collection collection, Class<T> targetClz) {
        if (!CollectionUtils.isEmpty(collection) && targetClz != null) {
            Iterator iterator = collection.iterator();
            ArrayList result = new ArrayList(collection.size());

            while(iterator.hasNext()) {
                Object next = iterator.next();
                result.add(copy(next, targetClz));
            }

            return result;
        } else {
            return null;
        }
    }

    public static <T> T copy(Object source, Class<T> targetClz) {
        if (source != null && targetClz != null) {
            Object target = newInstance(targetClz);
            BeanCopier copier = BeanCopier.create(source.getClass(), targetClz, false);
            copier.copy(source, target, (Converter)null);
            return (T) target;
        } else {
            return null;
        }
    }

    private static Object newInstance(Class clz) {
        try {
            Object obj = clz.newInstance();
            return obj;
        } catch (Exception var3) {
            return null;
        }
    }
}
