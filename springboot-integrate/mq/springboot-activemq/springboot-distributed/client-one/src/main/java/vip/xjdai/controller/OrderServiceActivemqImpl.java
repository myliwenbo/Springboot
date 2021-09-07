package vip.xjdai.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.xjdai.model.AcvivemqUser;

import javax.jms.Destination;
import javax.jms.Queue;
import java.util.HashMap;

@Service("activemq")
@Transactional(rollbackFor = Exception.class)
public class OrderServiceActivemqImpl {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private Queue queue;


    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    public void updateAmount(final int amount, final String messageId, final String userId) {
        String sql = "update account set amount = amount - ?,update_time=now() where user_id = ?";
        int count = jdbcTemplate.update(sql, amount, userId);
        if (count == 1) {
            //插入到消息记录表
            sql = "insert into message(user_id,message_id,amount,status) values (?,?,?,?)";
            int row = jdbcTemplate.update(sql, userId, messageId, amount, "unconfirm");
            if (row == 1) {
                // 发送消息。。。
                AcvivemqUser value = new AcvivemqUser();
                value.setAmount(amount);
                value.setStatus("unconfirm");
                value.setId(1);
                value.setMessageid(1);
                jmsMessagingTemplate.convertAndSend(queue, value);
            }
        }
    }

    public void updateMessage(String param) {
        JSONObject parse = JSONObject.parseObject(param);
        String messageId = parse.getString("messageId");

        String sql = "update message set status = ? where message_id = ?";
        int count = jdbcTemplate.update(sql, "confirm", messageId);
        if (count == 1) {
            logger.info(messageId + "  callback successfull");
        }
    }
}