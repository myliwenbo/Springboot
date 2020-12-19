package vip.xjdai.springbootdesignpattern.Filter.three;

import vip.xjdai.springbootdesignpattern.Filter.two.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    public List<Filter> filters = new ArrayList<Filter>();

    public FilterChain addFilter(Filter f) {

        filters.add(f);

        return this;

    }

    @Override
    public String doFilter(String msg) {
        //执行filters中的doFilter方法即可
        String r = msg;
        for (Filter f : filters) {
            r = f.doFilter(r);
        }
        return r;
    }

}

