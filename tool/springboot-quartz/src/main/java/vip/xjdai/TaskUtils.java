package vip.xjdai;

import java.lang.reflect.Method;

import vip.xjdai.web.QuartzUtils;
import vip.xjdai.web.domain.ScheduleJob;

public class TaskUtils {

    /**
     * 通过反射调用scheduleJob中定义的方法
     * 
     * @param scheduleJob
     */
    public static void invokMethod(ScheduleJob scheduleJob) {
        //校验class是否存在
        Object object = QuartzUtils.verifClass(scheduleJob.getSpringId());
        //校验spring类是否存在
        Method method = QuartzUtils.verifyClassAndMethod(object,
            scheduleJob.getMethodName());
        try {
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]----------启动成功");
    }
}
