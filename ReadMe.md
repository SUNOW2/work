### 简介
本文主要是想实现Spring Cloud架构中系统间调用的事务一致性
### 技术点
eureka-server、eureka-client、feign、hystrix、mybatis、mysql
### 架构
eur：eureka的服务端  
order：订单模块  
inventory：库存模块  
core：公共模块
### 解决的问题
1、@Transactional和@HystrixCommand注解共用的时候，会出现事务失效的情况，解决办法是将这两个注解写在不同的service实现类中。  
2、处理feign超时后重复请求的问题

联系方式：1605611836@qq.com