package vip.xjdai.springbootdesignpattern.Filter.three;

import vip.xjdai.springbootdesignpattern.Filter.two.Filter;

public class MsgProcessor {

    private final String msg;

    private FilterChain chain = new FilterChain();

    public MsgProcessor(String msg, Filter Chain) {

        this.msg = msg;

        this.chain = chain;

    }

    public String process() {

        return chain.doFilter(msg);

    }

}
      