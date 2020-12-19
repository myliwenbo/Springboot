package vip.xjdai.springbootmybatisgenerator.plus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 自定义注释，如果要配置生效则需要配置 `generatorConfig.xml` 文件的 <commentGenerator></commentGenerator>  标签
 * 参考：https://blog.csdn.net/u011781521/article/details/78164098
 *
 * @author lwb
 */
@SuppressWarnings("unused")
public class CustomCommentGenerator extends DefaultCommentGenerator {

    /**
     * DefaultCommentGenerator.class API说明
     * DefaultCommentGenerator 就是POJO类的主要类
     */
    //    addJavadocTag(JavaElement javaElement,boolean markAsDoNotDelete) 添加自定义javadoc标签
    //    addClassComment(InnerClass innerClass,IntrospectedTable introspectedTable) 类
    //    addModelClassComment(TopLevelClass topLevelClass,IntrospectedTable introspectedTable) 模型类添加
    //    addEnumComment(InnerEnum innerEnum,IntrospectedTable introspectedTable) 枚举注释
    //    addFieldComment(Field field,IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn)  字段
    //    addFieldComment(Field field, IntrospectedTable introspectedTable) 字段
    //    addGeneralMethodComment(Method method,IntrospectedTable introspectedTable) 普通方法注释,mapper接口中方法
    //    addGetterComment(Method method,IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn) Getter方法
    //    addSetterComment(Method method,IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn) Setter方法
    //    addClassComment(InnerClass innerClass,IntrospectedTable introspectedTable, boolean markAsDoNotDelete) 类信息
    //    addJavaFileComment(CompilationUnit compilationUnit)  Java文件加
    //    addComment(XmlElement xmlElement)  Mybatis的Mapper.xml文件里面的注释
    //    addRootComment(XmlElement rootElement) 为根元素的第一个子节点添加注释

    /**
     * 配置文件
     */
    private Properties properties;
    private Properties systemPro;
    /**
     * 父类的时间
     */
    private boolean suppressDate;
    /**
     * 父类的所有注释
     */
    private boolean suppressAllComments;
    private String currentDateStr;

    public CustomCommentGenerator() {
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    /**
     * 自定义get方法的注释
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        method.addJavaDocLine("/**  ");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());
        sb.setLength(0);
        sb.append(" * @return ");
        sb.append(introspectedColumn.getActualColumnName());
        sb.append(" ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */");
        //添加注解
        method.addAnnotation("@Testsss");

    }

    /**
     * set注释
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        method.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder();
        sb.append(" * 设置 ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());
        Parameter parm = method.getParameters().get(0);
        sb.setLength(0);
        sb.append(" * @param ");
        sb.append(parm.getName());
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */");
    }

    /**
     * 自定义属性的注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {

        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        field.addJavaDocLine(" */");

    }

    @Override
    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**  ");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append(" ");
        sb.append(getDateString());
        innerClass.addJavaDocLine(sb.toString());
        innerClass.addJavaDocLine(" */");

    }

}
