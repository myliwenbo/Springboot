package vip.xjdai.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 配置druid页面配置
 *
 * @author lwb
 *
 */
@WebServlet(urlPatterns = "/druid/*", // 配置访问路径
        initParams = { @WebInitParam(name = "allow", value = ""), // IP白名单 (没有配置或者为空，则允许所有访问)
                @WebInitParam(name = "deny", value = "192.168.16.111"), // IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name = "loginUsername", value = "admin"), // 用户名
                @WebInitParam(name = "loginPassword", value = "admin"), // 密码
                @WebInitParam(name = "resetEnable", value = "false")
        })
public class DruidStatViewServlet extends StatViewServlet
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
