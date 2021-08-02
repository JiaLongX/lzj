# 基础镜像
FROM openjdk:latest
# 作者信息
LABEL maintainer="xxxx.com"
# 容器开放端口
EXPOSE 4006
# 将 maven 目录的 jar 包拷贝到 docker 中，并命名为 for_docker.jar
ADD maven/lzj-gateway-0.0.1-SNAPSHOT.jar lzj-gateway.jar
# 容器启动执行命令
ENTRYPOINT ["java", "-jar", "lzj-gateway.jar"]