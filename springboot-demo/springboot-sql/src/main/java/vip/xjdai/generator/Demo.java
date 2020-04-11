/**
 *
 */
package vip.xjdai.generator;

import vip.xjdai.dao.StudentMapper;
import vip.xjdai.domain.Student;

/**
 * @author lwb
 *
 */
public class Demo {

    /**
     * 不同的Session相同的执行语句也是获取缓存中的数据
     * @throws Exception
     */
    public static void main(String[] args) {

        try {
            StudentMapper getsqlSession = MybatisUtisl.getsqlSession(StudentMapper.class);
            Student sc = new Student();
            for (int i = 0; i <= 70000; i++) {
                sc.setId(i);
                sc.setName("小明：" + i);
                getsqlSession.insert(sc);
                MybatisUtisl.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
