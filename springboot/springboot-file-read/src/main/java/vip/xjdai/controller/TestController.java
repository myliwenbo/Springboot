package vip.xjdai.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping
public class TestController {

    @RequestMapping("test")
    public void test() throws IOException {
        //读取的是 resources/test/test.text  文件
        // ClassPathResource classPathResource = new ClassPathResource("test/test.text");
        //读取的是 resources下的文件
        ClassPathResource classPathResource = new ClassPathResource("test.text");
        InputStream ipt = classPathResource.getInputStream();
        int readByte = 0; //代表了返回的角标位置，如果返回 -1 则表示读不到数据了
        byte[] bytes = new byte[1024]; //设置一次读取1024个字节
        while ((readByte = ipt.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readByte));
        }
    }
}
