package vip.xjdai.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
 
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    /* 
     * 更新数据库表，把账户余额减去amountd
     */
    public void updateAmount(int amount, String userId) {
        //1、农业银行转账3000，也就说农业银行jack账户要减3000
        String sql = "update account set amount = amount + ?,update_time=now() where user_id = ?";
        int count = jdbcTemplate.update(sql, amount, userId);
        
        if (count != 1) {
            throw new RuntimeException("订单创建失败，农业银行转账失败！");
        }
    }
 
    public RestTemplate createRestTemplate() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(3000);
        simpleClientHttpRequestFactory.setReadTimeout(2000);
        return new RestTemplate(simpleClientHttpRequestFactory);
    }
 
    public int queryMessageCountByUserId(String messageId) {
        String sql = "select count(*) from message where message_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
 
    public int insertMessage(String userId, String message_id,int amount, String status) {
        String sql = "insert into message(user_id,message_id,amount,status) values(?,?,?)";
        int count = jdbcTemplate.update(sql, userId, message_id,amount, status);
 
        if(count == 1) {
            logger.info("Ok");
        }
        return count;
    }
}