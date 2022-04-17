package vip.xjdai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetnxTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    String img = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAcAAAAFcCAYAAABfgW5LAAAgAElEQVR4nOy92bvlxnUv9qsBwN5n6u7TI9mkJJIm2ZRI2r6+8SB/unlJnpKnPOT/zXffEue71rUsO7YVyZFFUhTZ0zlnDwCqVh6qVqFQuwDsfWZSvcjTwMZQKBSq1jyI//l/+t9JKQUpZfgDAEFwWyHCHwC8evESJycnODs7AxFBKQUhBIjcDbwFAGstiAjW2rBfSAUQgSBDu0QU/rRUIBjAtICwkBAQoPB8AkBCoLWAsYAqK9RNC0Nw/dcaUkooQQAIwhKsbSHIAAAMCcA/myHe5/fPnWPIvWvuen6n+FohZG9ckYxvaFPmn6tE953i8ePxVUpt3MPniAggCs9VSkEVGkVRQOoytNu2Leq6Rtu2gOm3JRUuBMY/n0c5/vZEBAnRG7d4rIQQ0Fpv3NO/VoV70nG4DLDWhnGy1sIYN0BSSiilYGHQtjWstSjLAn/z07/CX/7lf0ZtWkgJzMoCgL2UvtwE5NbDZYJSqjemRARjTPj2q9UKWmtI6eaBhfBzXsIYg9OTBV69OsE3z7/F2ekCxhgYQ6jrGut1g6IoAJK9dcH";

    @Test
    public void setnx() throws Exception {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        // stringStringValueOperations.setIfAbsent("")

    }
}
