# 注解缓存

```java

@Configuration
@EnableCaching//启用缓存
public class CachingConfig {
	/**
	 * 声明缓存管理器
	 */
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}
	
}
```
## 注解原理
会创建一个切面（AOP）并出发Spring缓存注解的切点（pointcut）