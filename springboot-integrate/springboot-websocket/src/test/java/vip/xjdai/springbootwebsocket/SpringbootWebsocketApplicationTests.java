package vip.xjdai.springbootwebsocket;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.xjdai.springbootwebsocket.mapper.MessageMapper;
import vip.xjdai.springbootwebsocket.model.Message;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootWebsocketApplicationTests {

    @Autowired
    private MessageMapper messageMapper;

    @Test
    void contextLoads() {
        Message value = new Message();
        value.setMessage("消息1");
        value.setUserId("user_id_1");
        messageMapper.insert(value);
    }

}
