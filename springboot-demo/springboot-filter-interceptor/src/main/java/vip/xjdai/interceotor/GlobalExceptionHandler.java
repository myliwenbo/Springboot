package vip.xjdai.interceotor;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import vip.xjdai.common.domain.ResponseBean;
import vip.xjdai.common.exceotion.BizException;

/**
 * 全局异常拦截器
 *
 * @author lwb
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory
            .getLogger(GlobalExceptionHandler.class);

    /**
     * 可以自己在下面定义返回的参数
     *
     * @param ex
     * @param response
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public ResponseBean exceptionHandler(Throwable ex, HttpServletResponse response) {
        ex.printStackTrace();
        log.debug("业务处理结束,发生异常{}", ex.getMessage());
        if (!StringUtils.isEmpty(ex.getMessage())) {
            log.debug("业务处理结束,发生异常{}", ex.getMessage());
        }
        /**
         * 自定义业务异常
         */
        if (ex instanceof BizException) {
            return new ResponseBean("错误");
        } else if (ex instanceof NullPointerException) {
            log.debug("业务处理结束,发生异常{}", "空指针异常");
            return new ResponseBean("错误");
        }
        return new ResponseBean("错误");
    }

}