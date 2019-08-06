云平台 spring cloud
------

使用组件：

| 服务名称 | 说明 |
|--------|--------|
| nacos| 服务发现与注册和配置中心 |
| sentinel | 服务熔断与限流 |
| feign | 服务之间的调用与负载均衡 |
| gateway | 服务网关 |

## 启动步骤
* 启动nacos（运行bin/startup.cmd），访问地址：localhost:8848 账号密码：nacos/nacos
* 启动sentinel（运行run.bat），访问地址：localhost:8849 账号密码：sentinel/sentinel
* 启动admin-service（提供服务），访问地址：localhost:911
* 启动admin-api（提供接口），访问地址：localhost:950
* 启动admin-gateway（服务网关），访问地址：localhost:10000


