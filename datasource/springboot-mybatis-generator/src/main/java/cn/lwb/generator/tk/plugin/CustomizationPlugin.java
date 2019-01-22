package cn.lwb.generator.tk.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import tk.mybatis.mapper.generator.MapperPlugin;

/**
 * 通过继承父类来增强或者重写父类方法
 * @author lwb
 *
 */
public class CustomizationPlugin extends MapperPlugin {

    /**
     * 生成基础实体类
     *
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {

        //添加lombak的import
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addImportedType("lombok.EqualsAndHashCode");
        //添加lombak的注解
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = false)");
        //调用父类方法增强
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    /**
     * 修改列数据，添加列注解
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass,
                                       IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable,
                                       ModelClassType modelClassType) {
        //添加导包
        topLevelClass.addImportedType("io.swagger.annotations.ApiModel");
        topLevelClass.addImportedType("io.swagger.annotations.ApiModelProperty");
        //添加Swagger2类注解
        String classAnnotation = "@ApiModel(value=\"" + topLevelClass.getType() + "\")";
        if (!topLevelClass.getAnnotations().contains(classAnnotation)) {
            topLevelClass.addAnnotation(classAnnotation);
        }
        //添加Swagger2类注解
        field.addAnnotation(
            "@ApiModelProperty(value=\"" + introspectedColumn.getJavaProperty()
                            + introspectedColumn.getRemarks() + "\")");
        //调用父类方法增强
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn,
            introspectedTable, modelClassType);
    }

}
