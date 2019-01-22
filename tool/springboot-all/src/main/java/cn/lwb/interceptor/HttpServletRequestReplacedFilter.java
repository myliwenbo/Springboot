package cn.lwb.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author lwb
 *
 */
@WebFilter(filterName = "myFilter", urlPatterns = { "/*" })
public class HttpServletRequestReplacedFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.setHeader("Access-Control-Allow-Origin", "*");
            res.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
            res.setHeader("Access-Control-Max-Age", "3600");
            res.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept");
            res.setHeader("", "");
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String contentType = this
                .defaultIfNull((String) httpServletRequest.getContentType())
                .toLowerCase();
            String methodType = httpServletRequest.getMethod().toUpperCase();
            if ("POST".equals(methodType) && contentType.startsWith("application/json")) {
                BodyReaderHttpServletRequestWrapper requestWrapper = new BodyReaderHttpServletRequestWrapper(
                    (HttpServletRequest) request);
                chain.doFilter((ServletRequest) requestWrapper, (ServletResponse) res);
            } else if ("GET".equals(methodType)) {
                BodyReaderHttpServletRequestWrapper requestWrapper = new BodyReaderHttpServletRequestWrapper(
                    (HttpServletRequest) request);
                chain.doFilter((ServletRequest) requestWrapper, (ServletResponse) res);
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

    private String defaultIfNull(String str) {
        return str == null ? "" : str;
    }

}