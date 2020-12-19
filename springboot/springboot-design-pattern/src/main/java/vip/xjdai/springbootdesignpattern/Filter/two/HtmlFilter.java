package vip.xjdai.springbootdesignpattern.Filter.two;

public class HtmlFilter implements Filter {

    @Override
    public String doFilter(String msg) {
        String r = msg;
        r = r.replace("<", "&lt;").replace(">", "&gt;");
        return r;
    }

}
