FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8

MAINTAINER zhouping "zhouping19911013@163.com"
MAINTAINER version "online"

EXPOSE 8089

VOLUME /tmp
ADD springboot.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]