package vip.xjdai.springbootinitializr.jsonmodel;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonModelMain {


    public static void main(String[] args) throws IOException {
        ClassLoader loader = FileUtil.class.getClassLoader();
        InputStream stream = loader.getResourceAsStream("model.json");
        String text = IOUtils.toString(stream, "utf8");
        List<Demo> demos = JSON.parseArray(text, Demo.class);
        Map<String, InvSku> objectObjectHashMap = Maps.newHashMap();
        demos.forEach(item -> {
            objectObjectHashMap.put(item.getOutID(), item.getInvSku());
        });

        Map<String, InvSku> collect = demos.stream().collect(Collectors.toMap(Demo::getOutID, Demo::getInvSku));
//        Map<String, String> collect = demos.stream().collect(Collectors.toMap(Demo::getOutID, Demo::getInvSku));
        System.out.println(collect);

    }
}
