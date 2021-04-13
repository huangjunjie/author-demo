## author-demo

`this project is simple test  system  about authorization and authenzation.`

------

### 1.INTRODUCTION


### 2.FRAMEWORK


### 3.DESIGNTHINK


### 4.UML

### 5.相关知识树

#### 5.1 ribbon负载均衡算法

RoundRobinRule 默认轮询的方式
RandomRule 随机方式
WeightedResponseTimeRule 响应时间加权策略 根据响应时间来分配权重的方式，响应的越快，分配的值越大。
BestAvailableRule 最低并发策略 选择并发量最小的方式
ZoneAvoidanceRule 根据性能和可用性来选择
RetryRule 重试策略 在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server 
AvailabilityFilteringRule 可用过滤策略 过滤掉那些因为一直连接失败的被标记为circuit tripped的后端server，并过滤掉那些高并发的的后端server（active connections 超过配置的阈值）`


##### 5.2 config
启动项目后，访问http://localhost:8020/config/dev/main 即可以看到配置信息 这个地址要注意的是 http://localhost:9090/{配置文件名前缀}/{环境类型}/{仓库分支标签}
http://localhost:8020/main/consumer-dev.properties 这个地址要注意的是 http://localhost:9090/{仓库分支标签}/{文件名称}


