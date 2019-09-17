package vip.xjdai.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * 自定义日志过滤器~<br/>
 * 使用<br/>
 * 在 logbak.xml配置文件中使用
 *              <filter class="vip.xjdai.filter.SampleFilter"/>
 */
public class SampleFilter extends Filter< ILoggingEvent >
{

    @Override
    public FilterReply decide(ILoggingEvent event)
    {
        if (getPackName(event.getLoggerName()).equals("com.example.bootstart.log") || getPackName(
                event.getLoggerName()).equals("com.example.bootstart.log2")) {
            return FilterReply.DENY;  //表示不打印这段日志
        } else {
            return FilterReply.ACCEPT; //则表示打印这段日志.
        }
    }

    private String getPackName(String className)
    {
        return className.substring(0, className.lastIndexOf("."));
    }

}