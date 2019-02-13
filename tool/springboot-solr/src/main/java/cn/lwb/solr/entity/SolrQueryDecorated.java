package cn.lwb.solr.entity;

import org.apache.solr.client.solrj.SolrQuery;

/**
 * 替代原有SolrQuery
 * @author lwb
 *
 */
public class SolrQueryDecorated {

    public static SolrQuery creatSolrQuery() {
        return new SolrQuery();
    }

    /**
     * <pre>
     * 1.构建搜索对象
     * 2.并且设置Q
     * 3.进行条件查询
     * </pre>
     * @param key 可以理解是field
     * @param value 是值
     * @return if `kv` 是null 就查询所有
     */
    public static SolrQuery setQ(String... kv) {
        SolrQuery creatSolrQuery = creatSolrQuery();
        if (kv.length % 2 == 0) {
            creatSolrQuery.setQuery(kv[0] + ":" + kv[1]);
            return creatSolrQuery;
        }
        creatSolrQuery.setQuery(kv[0]);
        return creatSolrQuery;
    }

    /**
     * filter query 过滤条件 和q是and的关系支持各种逻辑运算符
     * 参考 https://cwiki.apache.org/confluence/display/solr/The+Standard+Query+Parser
     * 设置过滤查询
     * @param fq
     * @return
     */
    public static SolrQuery setFQ(SolrQuery creatSolrQuery, String fq) {
        if (creatSolrQuery == null) {
            creatSolrQuery = creatSolrQuery();
        }
        creatSolrQuery.setFilterQueries(fq);
        return creatSolrQuery;
    }

    /**
     * 设置过滤条件
     * @param fq
     * @return
     */
    public static SolrQuery setFQ(String fq) {
        return setFQ(null, fq);
    }
}
