package vip.xjdai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void get() throws Exception {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        System.out.println(stringStringValueOperations.get("test"));
    }

    @Test
    public void delete() throws Exception {
        Set<String> keysd = stringRedisTemplate.keys("*");
        keysd.forEach(key -> {
            stringRedisTemplate.delete(key);
        });
    }

    @Test
    public void query() throws Exception {
        Set<String> keysd = stringRedisTemplate.keys("*");
        keysd.forEach(System.out::println);

    }

    @Test
    public void add() throws Exception {
        stringRedisTemplate.opsForValue().set("kkk", "张三");
    }

    Integer threadCoutn = 5;
    private CountDownLatch latch = new CountDownLatch(threadCoutn);
    String img = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAcAAAAFcCAYAAABfgW5LAAAgAElEQVR4nOy92bvlxnUv9qsBwN5n6u7TI9mkJJIm2ZRI2r6+8SB/unlJnpKnPOT/zXffEue71rUsO7YVyZFFUhTZ0zlnDwCqVh6qVqFQuwDsfWZSvcjTwMZQKBSq1jyI//l/+t9JKQUpZfgDAEFwWyHCHwC8evESJycnODs7AxFBKQUhBIjcDbwFAGstiAjW2rBfSAUQgSBDu0QU/rRUIBjAtICwkBAQoPB8AkBCoLWAsYAqK9RNC0Nw/dcaUkooQQAIwhKsbSHIAAAMCcA/myHe5/fPnWPIvWvuen6n+FohZG9ckYxvaFPmn6tE953i8ePxVUpt3MPniAggCs9VSkEVGkVRQOoytNu2Leq6Rtu2gOm3JRUuBMY/n0c5/vZEBAnRG7d4rIQQ0Fpv3NO/VoV70nG4DLDWhnGy1sIYN0BSSiilYGHQtjWstSjLAn/z07/CX/7lf0ZtWkgJzMoCgL2UvtwE5NbDZYJSqjemRARjTPj2q9UKWmtI6eaBhfBzXsIYg9OTBV69OsE3z7/F2ekCxhgYQ6jrGut1g6IoAJK9dcH";

    /**
     * 淘汰策略测试
     *
     * @throws Exception
     */
    @Test
    public void addThreadTest() throws Exception {
        for (int i = 0; i < threadCoutn; i++) {
            Thread thread = new Thread(() -> {

            });
            thread.setName("Thread-" + i);
            thread.start();
        }
        latch.await(); // 主线程等待

    }

    @Test
    public void addTest() throws Exception {
        for (int ti = 0; ti < 10000; ti++) {
            //maxmemory
            stringRedisTemplate.opsForValue().set(Thread.currentThread().getName() + "-" + ti, img);
        }
    }


}
