package cn.lwb.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 监听器，主要用于项目启动后加载初始化内容等
 * @author lwb
 *
 */
public class InstantiationTracingBeanPostProcessor implements
                                                   ApplicationListener<ContextRefreshedEvent> {

    private static Map<String, List<String>> map = new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //root application context 没有parent，他就是老大.
        if (event.getApplicationContext().getParent() == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("1");
            arrayList.add("2");
            arrayList.add("3");
            map.put("1", arrayList);
        }
        System.out.println(this.getClass().getName());
    }
}