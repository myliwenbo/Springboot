# 自定义 initialize


参考指南：https://docs.spring.io/initializr/docs/current-SNAPSHOT/reference/html/#initializr-documentation
参考：`https://www.cnblogs.com/maxmaxmax/articles/8571780.html
参考：https://silloy.me/2020/06/18/%E5%BC%80%E5%90%AFSpring%20Initializr%E4%B8%AA%E6%80%A7%E5%8C%96%E4%B9%8B%E6%97%85/



# 步揍
1. 下载源码
https://gitee.com/guangzhou_lehu_ecommerce_2779338645/initializr?_from=gitee_search

2. 执行 mvn clean install -DskipTests

3. 添加POM
```xml
    <dependencies>
        <dependency>
            <groupId>io.spring.initializr</groupId>
            <artifactId>initializr-web</artifactId>
            <version>0.10.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>io.spring.initializr</groupId>
            <artifactId>initializr-generator-spring</artifactId>
            <version>0.10.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>io.spring.initializr</groupId>
                <artifactId>initializr-bom</artifactId>
                <version>0.10.0-SNAPSHOT</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

```
4. 参考 application.yml

5. 启动

6. 访问 127.0.0.1:7777

7. IDEA 配置
