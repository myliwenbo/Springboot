# 前言

*  该文章主要针对的是springboot
*  IDEA 是2020.1.X
*  jdk 为 1.8
*  服务器需要配置 JAVA 环境..（要是不知道，不建议看本文）

# 配置启动命令

执行命令，各位需要注意的是下列命令是我项目中所需要使用的各位根据调整

```shell
nohup java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8202 \
dbugTest.jar >> dbugTest.log 2>&1 &
```

# 新增启动项

右上角的启动项里面

![](//img.xjdai.vip/202007281219_48.png)

# 配置IDEA

![](//img.xjdai.vip/202007281217_248.png)

## 解析命令

```shell
nohup java -jar
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8202 \
```

`${}`：是需要填充的信息，当然，如果你都懂，那其实你应该也会知道哪些参数你知道或者不知道，

# 注意

注意，本文章都是已**我**的项目配置的，参考：解析命令