

# Author Demo   
[![build-passing](https://img.shields.io/badge/build-passing-green)](https://github.com/huangjunjie/author-demo)    [![spring-boot-version](https://img.shields.io/badge/spring--boot--version-2.2.10.RELEASE-green)](https://github.com/spring-projects/spring-boot)   [![spring-cloud-version](https://img.shields.io/badge/spring--cloud--version-Hoxton.SR9-green)](https://spring.io/projects/spring-cloud#overview)

>
  This projects is a demo about  authorization and authencation. the projects uesd  spring boot , spring cloud , redis , mysql , jwt , docker , filebeat , elk .




## 介绍 (Introduction)

  本项目实质是认证授权模型。主要使用`spring-boot-starter-security` 与 `spring-cloud-starter-security`两个spring安全模块。
  其中项目架构为

  **author-demo**
  |---  ***auth-mango***                   spring-boot授权认证模块
  |---  ***auth-backup***                   sql数据备份模块
  |---  ***author-common***            认证授权项目通用模块
  |---  ***author-db***                       认证授权项目使用SQL集合模块
  |---  ***auth-monitor***                 spring-boot-admin 服务监控模块
  |---  ***auth-consumer***              服务消费者
  |---  ***auth-producer***                服务提供者
  |---  ***auth-producer2***              服务提供者
  |---  ***auth-hystrix***                    hystrix服务监控者
  |---  ***auth-zuul***                          服务网关
  |---  ***auth-config***                      服务配置
  |---  ***auth-authorization***         spring-cloud授权认证模块
  |---  ***auth-oauth2-jwt-client***   SSO客户端
  |---  ***auth-oauth2-jwt-server***  SSO服务端


>  本项目鸣谢徐丽件老师的[《Spring Boot + Spring Cloud + Vue + Element项目实战手把手教你开发权限管理系统》](https://gitee.com/liuge1988/mango-platform/tree/master) 以及 ThinkWo老师的  [Spring Cloud入门系列汇总 ](https://blog.csdn.net/ThinkWon/article/details/103766368)



## 环境说明(Enviroment)

+ 项目使用`IDEA`开发环境
+ `java`  版本为  `1.8.0_281`
+ `maven` 作为项目管理，版本为 `3.8.1`
+ `git` 作为代码管理，对应仓库为 `github` , `gitee`
+ `docker` 作为容器，版本为 `19.03.8`
+ `filebeat` 作为日志收集工具，版本为 `7.10.0-oss`
+ docker中相关版本如下 `表1`
+ 项目中具体代码框架版本如下 `表2`


> 表1

| docker名称 | 框架版本 | 备注 |
| --- | --- | --- |
| consul | latest | |
| rabbitmq | management | |
| docker.io/sebp/elk | latest | |
| docker.io/mysql | latest | |
| docker.io/redis | latest | |


> 表2

| 框架英文标识 | 框架版本 | 备注 |
| --- | --- | --- |
| spring.boot.version | 2.2.10.RELEASE | |
| spring.cloud.version | Hoxton.SR9 | |
| mybatis.version | 2.1.1 | |
| druid.version | 1.1.17 | |
| log4j.version | 1.2.17 | |
| mysql.version | 8.0.21 | |
| fastjson.version | 1.2.70 | |
| swagger2.version | 2.6.1 | |
| pagehelper.version | 1.2.10 | |
| poi.version | 3.9 | |
| kaptcha.version | 2.3.2 | |
| jwt.version | 0.9.1 | |




## 使用方法(Use Method)



## 知识树(Struct Knowledge)

### Ribbon相关知识

#### ribbon负载均衡算法

* RoundRobinRule.class：默认轮询的方式。
* RandomRuleclass：随机方式。
* WeightedResponseTimeRule.class：响应时间加权策略。根据响应时间来分配权重的方式，响应的越快，分配的值越大。
* BestAvailableRule.class：最低并发策略。选择并发量最小的方式。
* ZoneAvoidanceRule.class：根据性能和可用性来选择。
* RetryRule.class：重试策略。在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server 。
* AvailabilityFilteringRule.class：可用过滤策略。过滤掉那些因为一直连接失败的被标记为circuit tripped的后端server，并过滤掉那些高并发的的后端server（active connections 超过配置的阈值）


### Config相关知识

#### config使用方法

启动项目后，浏览配置服务器上相关项目配置信息，可以访问
```html 
http://localhost:8020/config/dev/main 
```
其中地址格式为 ` http://localhost:9090/{配置文件名前缀}/{环境类型}/{仓库分支标签}`
还能通过以下路径访问

```html
http://localhost:8020/main/consumer-dev.properties 
```
对应格式为 ` http://localhost:9090/{仓库分支标签}/{文件名称}`


