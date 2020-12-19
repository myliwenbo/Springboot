package vip.xjdai.springbootdesignpattern.Filter.two;

public class SensitiveFilter implements Filter {
    @Override
    public String doFilter(String msg) {
        String r = msg;
        //过滤敏感词
        r = r.replace("敏感", "").replace("被就业", "就业");
        return r;

    }

}