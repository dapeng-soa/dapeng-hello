# Dapeng-hello
以 [dapeng-soa](https://github.com/dapeng-soa/dapeng-soa) 构建的hello服务(Java实现)

## 项目目录树
```
|--dapeng-hello
|  |--hello-api                 dapeng服务api，插件生成代码
|  |  |--src
|  |  |  |--main
|  |  |  |  |--java
|  |  |  |  |--resources
|  |  |  |  |  |--thrifts       IDL文件存放
|  |  |--pom.xml
|  |--hello-service             dapeng服务实现
|  |  |--src
|  |  |  |--main
|  |  |  |  |--java
|  |  |  |  |--resources
|  |  |  |  |  |--META-INF
|  |  |  |  |  |  |--spring
|  |  |  |  |  |  |  |--services.xml
|  |  |  |  |  |  |--services
|  |  |  |  |  |  |  |--com.github.dapeng.core.ApplicationContext   SpringBoot启动类
|  |  |--pom.xml
|  |  |--logs
|  |  |--docker
|  |  |  |--Dockerfile          
|  |--.gitignore
|  |--pom.xml
|  |--hello-test-clinet         客户端测试
------------------------------------
```

## 本地启动
本地启动需要本地启动 zookeeper ,可使用 docker 启动一个 zookeeper 容器
```bash
docker pull zookeeper
docker run --name zookeeper -p 2181:2181 --restart always -d zookeeper
```
## Dapeng 插件启动服务

```bash
cd hello-service
mvn compile dapeng:run
或者
cd hello-service
mvn compile com.github.dapeng-soa:dapeng-maven-plugin:2.2.3:run -Dsoa.freq.limit.enable=false -Dsoa.apidoc.port=8192
```
> 注意:这里指定`-Dsoa.apidoc.port=8192`，为文档站点端口,浏览器打开 http://localhost:8192 即可访问

## 以SpringBoot形式进行开发
Dapeng 2.2.3 支持SpringBoot形式。具体案例请参考：com.dapeng.example.HelloServiceApp 类，
并将其注册到 META-INF/services/com.github.dapeng.core.ApplicationContext 文件

## 以Spring XML形式进行开发
Dapeng 支持以传统的 Spring XML 方式进行开发，此时，需要定义 META-INF/spring/services.xml 文件。

如果同时存在services/com.github.dapeng.core.ApplicationContext 定义和 META-INF/spring/services.xml，则优先使用前者。

## 本地测试
- 客户端测试代码在hello-test-client，测试前确保服务已启动服务，运行HelloClientTest即可
- 单元测试代码在hello-service，运行HelloTestCase即可
>服务默认注册端口:9090
>默认在线测试文档端口:8080,可使用`-Dsoa.apidoc.port=8192`指定站点端口

打开浏览器 http://localhost:8080 访问在线文档进行测试

## 打包docker镜像

```bash
cd hello-service
mvn clean package
```

## 使用docker-compose编排服务
使用docker-compose启动服务容器
```bash
docker-compose up -d helloZk
docker-compose up -d helloService
```
以上命令会一并启动一个依赖的 zookeeper 容器 helloZk ,无需单独启动 zookeeper

> 容器模式下启动服务没有在线测试站点,如果需要测试可以编写客户端服务来进行测试






