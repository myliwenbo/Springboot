package vip.xjdai.controller;

public class doLimit {

//    // 根据IP分不同的令牌桶, 每天自动清理缓存
//    private static LoadingCache<String, RateLimiter> caches = CacheBuilder.newBuilder()
//            .maximumSize(1000)
//            .expireAfterWrite(1, TimeUnit.DAYS)
//            .build(new CacheLoader<String, RateLimiter>() {
//                @Override
//                public RateLimiter load(String key) throws Exception {
//                    // 新的IP初始化 (限流每秒两个令牌响应)
//                    return RateLimiter.create(2);
//                }
//            });
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        for (int i = 0; i < 1000; i++) {
//            // 模拟实际业务请求
//            Thread.sleep(100);
//            login(i);
//        }
//    }
//
//    private static void login(int i) throws ExecutionException {
//        // 模拟IP的key
//        String ip = String.valueOf(i).charAt(0) + "";
//        RateLimiter limiter = caches.get(ip);
//
//        if (limiter.tryAcquire()) {
//            System.out.println(i + " success " + new SimpleDateFormat("HH:mm:ss.sss").format(new Date()));
//        } else {
//            System.out.println(i + " failed " + new SimpleDateFormat("HH:mm:ss.sss").format(new Date()));
//        }
//    }
}