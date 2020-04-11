package cn.lwb.dao.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException,
            IOException {
        HttpServletRequest srequest = (HttpServletRequest) request;
        System.out.println("this is MyFilter,url :" + request.getRequestURI());
        filterChain.doFilter(srequest, response);

    }

}