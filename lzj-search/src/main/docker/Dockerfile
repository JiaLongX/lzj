# 基础镜像
FROM openjdk:latest
# 作者信息
LABEL maintainer="xxxx.com"
# 容器开放端口
EXPOSE 7010
# 将 maven 目录的 jar 包拷贝到 docker 中，并命名为 for_docker.jar
ADD maven/lzj-search-0.0.1-SNAPSHOT.jar lzj-search.jar
# 容器启动执行命令
ENTRYPOINT ["java", "-jar", "lzj-search.jar"]