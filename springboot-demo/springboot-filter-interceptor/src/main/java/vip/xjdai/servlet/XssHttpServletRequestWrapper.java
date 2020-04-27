package vip.xjdai.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.web.util.HtmlUtils;

/**
 * 描述 : 跨站请求防范
 *
 * @author lwb
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    /**
     * 描述 : 构造函数
     *
     * @param request 请求对象
     */
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 增强父类方法
     */
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return HtmlUtils.htmlEscape(value);
    }

    /**
     * 增强父类方法
     */
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        return HtmlUtils.htmlEscape(value);
    }

    /**
     * 增强父类方法
     */
    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            int length = values.length;
            String[] escapseValues = new String[length];
            for (int i = 0; i < length; i++) {
                escapseValues[i] = HtmlUtils.htmlEscape(values[i]);
            }
            return escapseValues;
        }
        return super.getParameterValues(name);
    }

}