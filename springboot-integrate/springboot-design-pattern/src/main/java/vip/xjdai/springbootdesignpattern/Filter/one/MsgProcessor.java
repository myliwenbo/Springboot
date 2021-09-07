package vip.xjdai.springbootdesignpattern.Filter.one;

class MsgProcessor {

    private final String msg;

    public MsgProcessor(String msg) {
        this.msg = msg;
    }

    public String process() {
        String r = msg;
        //过滤msg中的HTML标记
        r = r.replace("<", "&lt;").replace(">", "&gt;");
        //过滤敏感词
        r = r.replace("敏感", "").replace("被就业", "就业");
        return r;
    }
}
