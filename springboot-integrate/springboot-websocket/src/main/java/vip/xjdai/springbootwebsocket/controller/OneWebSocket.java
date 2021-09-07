package vip.xjdai.springbootwebsocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootwebsocket.config.CustomSpringConfigurator;
import vip.xjdai.springbootwebsocket.mapper.MessageMapper;
import vip.xjdai.springbootwebsocket.model.Message;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * websocket服务端,多例的，一次websocket连接对应一个实例
 *
 * @ServerEndpoint(value = "/test/one") 前端通过此URI和后端交互，建立连接
 */
@Slf4j
@ServerEndpoint(value = "/test/one", configurator = CustomSpringConfigurator.class)
@Component
public class OneWebSocket {

    private static MessageMapper messageMapper;

    @Autowired
    public OneWebSocket(MessageMapper messageMapper) {
        OneWebSocket.messageMapper = messageMapper;
    }


    /**
     * 记录当前在线连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        // 1. 获取用户信息
        // 2. 通过用户ID 获取历史消息
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Message::getUserId, "user1");
        List<Message> messages = messageMapper.selectList(queryWrapper);
        sendMessage(JSONObject.toJSONString(messages), session);
        // onlineCount.incrementAndGet(); // 在线数加1
        // log.info("有新连接加入：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        onlineCount.decrementAndGet(); // 在线数减1
        log.info("有一连接关闭：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        // 1. 假定这是一个提交审批的功能，首先创建一条消息，状态是未审批
        Message messag = new Message();
        messag.setMessageStatus((long) 1); // 未审批
        messag.setUserId("user1"); // 审批人ID
        messag.setMessage("审批消息");
        messageMapper.insert(messag);
        // 3. 推送消息给审批人
        sendMessage(JSONObject.toJSONString(messag), session);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 服务端发送消息给客户端
     */
    private void sendMessage(String message, Session toSession) {
        try {
            log.info("服务端给客户端[{}]发送消息{}", toSession.getId(), message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败：", e);
        }
    }
}