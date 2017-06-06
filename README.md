# springbootdemo
spring boot 示例项目
整合Mybatis，shiro，log4j2框架，目前只做整合使用，初学springboot
spring boot集成spring boot devtools做热部署，当改动类文件时，只要编译改动文件，系统自动启动（很快）
spring boot devtools插件：
  base启动器：该启动器用来加载第三方基本不会改变的jar包，支持自己定制（适用spring boot多模块项目）
  restart启动器：该启动器用来加载用户自己编写的class文件，所以当用户自己修改class文件时，devtools只会废弃restart启动器，创建一个新的restart启动器，而Base启动器ClassLoader却没有变化，所以会很快。
#### devtools配置application.yml
#include添加那个目录的文件需要restart
#exclude排除那个目录的文件不需要restart
spring:
  devtools:
    restart:
      additional-paths: src/main/java
      exclude: static/**,public/**
