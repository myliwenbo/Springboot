package vip.xjdai;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private ListOperations<String, String> stringStringListOperations;
    String img = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAcAAAAFcCAYAAABfgW5LAAAgAElEQVR4nOy92bvlxnUv9qsBwN5n6u7TI9mkJJIm2ZRI2r6+8SB/unlJnpKnPOT/zXffEue71rUsO7YVyZFFUhTZ0zlnDwCqVh6qVqFQuwDsfWZSvcjTwMZQKBSq1jyI//l/+t9JKQUpZfgDAEFwWyHCHwC8evESJycnODs7AxFBKQUhBIjcDbwFAGstiAjW2rBfSAUQgSBDu0QU/rRUIBjAtICwkBAQoPB8AkBCoLWAsYAqK9RNC0Nw/dcaUkooQQAIwhKsbSHIAAAMCcA/myHe5/fPnWPIvWvuen6n+FohZG9ckYxvaFPmn6tE953i8ePxVUpt3MPniAggCs9VSkEVGkVRQOoytNu2Leq6Rtu2gOm3JRUuBMY/n0c5/vZEBAnRG7d4rIQQ0Fpv3NO/VoV70nG4DLDWhnGy1sIYN0BSSiilYGHQtjWstSjLAn/z07/CX/7lf0ZtWkgJzMoCgL2UvtwE5NbDZYJSqjemRARjTPj2q9UKWmtI6eaBhfBzXsIYg9OTBV69OsE3z7/F2ekCxhgYQ6jrGut1g6IoAJK9dcH";

    @Before
    public void getopsList() throws Exception {
        stringStringListOperations = stringRedisTemplate.opsForList();


    }

    @Test
    public void add() throws Exception {
        for (int i = 0; i < 500; i++) {
            stringStringListOperations.leftPush("list", i + "");
        }
    }

    @Test
    public void deleteAll() throws Exception {
        Set<String> keys = stringRedisTemplate.keys("*");
        stringRedisTemplate.delete(keys);
    }

    @Test
    public void leftPop() throws Exception {
        // 先进后出
        String list = stringStringListOperations.leftPop("list");
        System.out.println(list);
    }

    @Test
    public void rpop() throws Exception {
        // 先进先出
        String list = stringStringListOperations.rightPop("list");
        System.out.println(list);
    }

    /**
     * 队列演示，当读取完成后，可以通过判断来关闭循环，假设这个线程不能关闭呢，或者说我们要实时的去监听呢？
     *
     * @throws Exception
     */
    @Test
    public void queue() throws Exception {
        // 先进先出
        boolean offBoolean = true;
        while (offBoolean) {
            String list = stringStringListOperations.rightPop("list");
            if (Objects.isNull(list)) {
                offBoolean = false;
            }
            System.out.println(list);
        }
    }

    /**
     * 队列演示，当读取完成后，可以通过判断来关闭循环，假设这个线程不能关闭呢，或者说我们要实时的去监听呢？
     * 解决实时监听的问题
     *
     * @throws Exception
     */
    @Test
    public void queue1() throws Exception {
        // 先进先出
        while (true) {
            String list = stringStringListOperations.rightPop("list");
            if (Objects.isNull(list)) {
                // 可以通过暂停当前线程来处理这个问题
                Thread.sleep(5000);
            }
            System.out.println(list);
        }
    }

    /**
     * 如果不使用 sleen 如何处理呢？
     *
     * @throws Exception
     */
    @Test
    public void queue2() throws Exception {
        while (true) {
            // 配置 如果超过 5 秒就断开连接，所以这里有一个问题是如果消费者下线，生成的消息会丢失...
            String list = stringStringListOperations.leftPop("list", 5, TimeUnit.MINUTES);
            System.out.println(list);
        }
    }

    /**
     * 发布与订阅
     *
     * @throws Exception
     */
    @Test
    public void subscribe() throws Exception {
        // 消息生产者
        stringRedisTemplate.convertAndSend("testkafka", "123");
    }
}
