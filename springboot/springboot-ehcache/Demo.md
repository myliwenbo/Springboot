# MAVEN -地址
```xml
<dependency>
    <groupId>net.sf.ehcache</groupId>
    <artifactId>ehcache</artifactId>
    <version>2.10.2</version>
</dependency>
```
# 配置IDEA 识别配置文件

https://www.cnblogs.com/liaojie970/p/8270570.html

# 单独配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd">

  <!-- 磁盘缓存位置 -->
  <diskStore path="java.io.tmpdir/ehcache"/>

  <!-- 默认缓存 -->
  <defaultCache
          maxEntriesLocalHeap="10000"
          eternal="false"
          timeToIdleSeconds="120"
          timeToLiveSeconds="120"
          maxEntriesLocalDisk="10000000"
          diskExpiryThreadIntervalSeconds="120"
          memoryStoreEvictionPolicy="LRU"/>

  <!-- helloworld缓存 -->
  <cache name="helloworld"
         maxElementsInMemory="1000"
         eternal="false"
         timeToIdleSeconds="5"
         timeToLiveSeconds="5"
         overflowToDisk="false"
         memoryStoreEvictionPolicy="LRU"/>
</ehcache>
```
配置说明
>  maxElementsInMemory    缓存最大个数
>  eternal                					对象是否永久有效，一但设置了，timeout将不起作用。
>  timeToIdleSeconds  			设置对象在失效前的允许闲置时间（单位：秒）。仅当eternal=false对象不是永久有效时使用，可选属性，默认值是0，也就是可闲置时间无穷大。 
>  overflowToDisk 					当内存中对象数量达到maxElementsInMemory时，Ehcache将会对象写到磁盘中。 
>  diskSpoolBufferSizeMB  	这个参数设置DiskStore（磁盘缓存）的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区。 
>  maxElementsOnDisk         这个参数设置DiskStore（磁盘缓存）的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区。 
>  maxElementsOnDisk  		硬盘最大缓存个数。 
>  diskPersistent 						是否缓存虚拟机重启期数据 默认值 false
>  diskExpiryThreadIntervalSeconds    	磁盘失效线程运行时间间隔，默认是120秒。
>  memoryStoreEvictionPolicy  				当达到maxElementsInMemory限制时，Ehcache将会根据指定的策略去清理内存。默认策略是LRU（最近最少使用）。
>  FIFO（先进先出）
>  LFU（较少使用）。 
>  clearOnFlush   											内存数量最大时是否清除。 
## 使用
1. 在EhcacheDemo中，我们引用ehcache.xml 
2. 声明的名为helloworld  的缓存来创建Cache对象；
3. 然后我们用一个键值对来实例化Element对象；
4. 将Element对象添加到Cache；
5. 然后用Cache的get方法获取Element对象。

```java
public class EhcacheDemo {
    public static void main(String[] args) throws Exception {
        // 创建配置文件读取器会自动加载classpath根目录下名为ehcache.xml的文件
        final CacheManager cacheManager = new CacheManager();

        // 表示使用的是heeloworld的这份配置
        final Cache cache = cacheManager.getCache("helloworld");

        // create a key to map the data to
        final String key = "greeting";

        // Create a data element
        final Element putGreeting = new Element(key, "Hello, World!");

        // Put the element into the data store
        cache.put(putGreeting);

        // Retrieve the data element
        final Element getGreeting = cache.get(key);

        // Print the value
        System.out.println(getGreeting.getObjectValue());
    }
}
```

# 学习文档
https://www.iteye.com/blog/raychase-1545906
https://www.cnblogs.com/jingmoxukong/p/5975994.html#%E5%AE%89%E8%A3%85