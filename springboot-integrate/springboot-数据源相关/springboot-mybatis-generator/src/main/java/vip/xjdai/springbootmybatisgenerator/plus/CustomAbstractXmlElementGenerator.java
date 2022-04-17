package vip.xjdai.springbootmybatisgenerator.plus;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

public class CustomAbstractXmlElementGenerator extends AbstractXmlElementGenerator {

    /**
     * 添加自定义标签
     */
    @Override
    public void addElements(XmlElement root) {
        XmlElement addSql = addBaseQuerySql();
        XmlElement addList = addList();
        XmlElement addPageList = addPageList();
        XmlElement addFild = addFild();
        //把sql标签添加到总标签下
        root.addElement(addSql);
        root.addElement(addList);
        root.addElement(addPageList);
        root.addElement(addFild);
    }

    /**
     * 添加一个SQL 
     * @return
     */
    private XmlElement addBaseQuerySql() {
        XmlElement sql = addMyBatisTag("sql", getAttribute("id", "base_query")); //设置一个SQL的标签
        XmlElement trim = addMyBatisTag("trim", getAttribute("prefix", "WHERE"),
            getAttribute("prefixOverrides", "AND | OR"));//设置一个trim的标签
        StringBuilder sb = new StringBuilder();
        //循环所有列
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            //获取属性名称
            String javaProperty = introspectedColumn.getJavaProperty();
            //获取到列明
            String escapedColumnName = MyBatis3FormattingUtilities
                .getEscapedColumnName(introspectedColumn);
            //获取列明，数据库类型  #{cronExpression,jdbcType=VARCHAR}
            String parameterClause = MyBatis3FormattingUtilities
                .getParameterClause(introspectedColumn);
            XmlElement ifTag = addMyBatisTag("if",
                getAttribute("test", "null !=" + javaProperty)); //设置一个if的标签
            // 添加and
            sb.append(" and t." + escapedColumnName + "=" + parameterClause);
            //把当前拼接好的SQL 添加到if标签中
            ifTag.addElement(new TextElement(sb.toString()));
            //把if标签添加到 trim标签下
            trim.addElement(ifTag);
            sb.setLength(0);
        }
        //吧trim添加到sql下
        sql.addElement(trim);
        return sql;
    }

    private XmlElement addInclude() {
        // 公用include
        XmlElement include = addMyBatisTag("include",
            getAttribute("refid", "base_query"));
        return include;
    }

    private TextElement sql() {
        StringBuilder sb = new StringBuilder();
        // 获取当前表名称
        String fullyQualifiedTableNameAtRuntime = introspectedTable
            .getFullyQualifiedTableNameAtRuntime();
        sb.append("SELECT t.* FROM " + fullyQualifiedTableNameAtRuntime + " t");
        TextElement selectText = new TextElement(sb.toString());
        return selectText;
    }

    public XmlElement addFild() {
        // 增加find方法 
        XmlElement find = addMyBatisTag("select");
        find.addAttribute(getAttribute("id", "find"));
        find.addAttribute(getAttribute("resultMap", "BaseResultMap"));
        find.addAttribute(getAttribute("parameterType", getObjectByTable()));
        //把SQL 添加到 find 方法下
        find.addElement(this.sql());
        //把include 添加到 find 方法下
        find.addElement(this.addInclude());
        return find;
    }

    /**
     * 获取和表对应的实体类名称
     */
    public String getObjectByTable() {
        return introspectedTable.getBaseRecordType();
    }

    public XmlElement addPageList() {
        // 增加pageList
        XmlElement pageList = new XmlElement("select");
        pageList.addAttribute(getAttribute("id", "pageList"));
        pageList.addAttribute(getAttribute("resultMap", "BaseResultMap"));
        pageList.addAttribute(getAttribute("parameterType", getObjectByTable()));
        pageList.addElement(this.sql());
        pageList.addElement(this.addInclude());
        return pageList;
    }

    public XmlElement addList() {
        // 增加list
        XmlElement list = new XmlElement("select");
        list.addAttribute(getAttribute("id", "list"));
        list.addAttribute(getAttribute("resultMap", "BaseResultMap"));
        list.addAttribute(getAttribute("parameterType", getObjectByTable()));
        list.addElement(this.sql());
        list.addElement(this.addInclude());
        return list;
    }

    /**
     *  新增生成的XML配置文件的标签
     * @param tag 为标签名称
     * @param value  为属性和值
     * <pre>例如
     *   &lt sql id="base_query" > 
     *   其中 sql         为 tag 
     *   Attribute      存的是属性(ID)和值(base_query)
     * </pre>
     * @return
     */
    private XmlElement addMyBatisTag(String tag, Attribute... value) {
        XmlElement sql = new XmlElement(tag);
        for (int i = 0; i < value.length; i++) {
            Attribute attribute = value[i];
            sql.addAttribute(attribute);
        }
        return sql;
    }

    /**
     * 添加属性和值
     * @param key   属性
     * @param value 值
     * @return
     */
    private Attribute getAttribute(String key, String value) {
        return new Attribute(key, value);
    }

}