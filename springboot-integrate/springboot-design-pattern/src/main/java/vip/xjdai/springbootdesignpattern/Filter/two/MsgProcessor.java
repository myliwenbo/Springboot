package vip.xjdai.springbootdesignpattern.Filter.two;

class MsgProcessor {

    private final String msg;

    private final Filter[] filters = {new HtmlFilter(), new SensitiveFilter()};

    public MsgProcessor(String msg) {
        this.msg = msg;
    }

    public String process() {
        String r = msg;
        for (Filter f : filters) {
            r = f.doFilter(r);

        }
        return r;

    }

}