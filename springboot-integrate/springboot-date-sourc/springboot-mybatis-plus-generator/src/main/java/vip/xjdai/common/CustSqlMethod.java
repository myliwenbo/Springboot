package vip.xjdai.common;

public enum CustSqlMethod {

    INSERT_BATCH("insertBatch", "插入多条数据", "<script> INSERT INTO %s (%s) %s</script>");


    private final String method;
    private final String desc;
    private final String sql;

    CustSqlMethod(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }

    public String getMethod() {
        return method;
    }

    public String getDesc() {
        return desc;
    }

    public String getSql() {
        return sql;
    }
}
