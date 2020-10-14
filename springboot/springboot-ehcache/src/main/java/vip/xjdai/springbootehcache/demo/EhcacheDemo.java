package vip.xjdai.springbootehcache.demo;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheDemo {

    public static void main(String[] args) throws Exception {

        // 创建配置文件读取器会自动加载classpath根目录下名为ehcache.xml的文件
        final CacheManager cacheManager = new CacheManager();

        // 表示使用的是heeloworld的这份配置
        final Cache cache = cacheManager.getCache("helloworld");

        // create a key to map the data to
        final String key = "greeting";

        // 创建一个元素...
        final Element putGreeting = new Element(key, "Hello, World!");

        // 添加到缓存...
        cache.put(putGreeting);

        // 获取...
        final Element getGreeting = cache.get(key);

        // 打印..
        System.out.println(getGreeting.getObjectValue());
    }
}