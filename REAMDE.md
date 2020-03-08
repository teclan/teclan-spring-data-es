# 基于spring-data-elasticsearch的简单项目

>本项目基于 elasticsearch-5.6.16，主要是spring-boot-2.0.3.RELEASE 默认的elasticsearch的版本，其他elasticsearch的版本可能不兼容。
 若想使用其他版本的elasticsearch，请注意版本问题。
 
__启动本项目之前,请先阅读`elasticsearch配置.md`中的相关说明__

如果有其他使用疑问，请[点击此处](https://blog.csdn.net/chen_2890/article/details/83895646)参考他人案例。


##  application.properties 配置文件

```
## es 的集群名字，与es配置文件一直，否则将无法连接ES，报节点不可用的异常
spring.data.elasticsearch.cluster-name=elasticsearch

## 节点IP和端口，此处使用的是ES的tcp端口，默认是 9300，可修改es的配置文件以修改此端口
spring.data.elasticsearch.cluster-nodes=192.168.43.205:9300

``` 


## 异常记录

```
org.springframework.data.elasticsearch.ElasticsearchException: failed to map source [ {}] to class Item
	at org.springframework.data.elasticsearch.core.AbstractResultMapper.mapEntity(AbstractResultMapper.java:42)
	at org.springframework.data.elasticsearch.core.DefaultResultMapper.mapResults(DefaultResultMapper.java:88)
	at org.springframework.data.elasticsearch.core.ElasticsearchTemplate.queryForPage(ElasticsearchTemplate.java:288)
	at org.springframework.data.elasticsearch.core.ElasticsearchTemplate.queryForPage(ElasticsearchTemplate.java:282)
	at org.springframework.data.elasticsearch.core.ElasticsearchTemplate.queryForPage(ElasticsearchTemplate.java:115)
	at org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository.findAll(AbstractElasticsearchRepository.java:137)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:377)
	at org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:200)
	at org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:629)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)
	at org.springframework.data.repository.core.support.RepositoryFactorySupport$QueryExecutorMethodInterceptor.doInvoke(RepositoryFactorySupport.java:593)
	at org.springframework.data.repository.core.support.RepositoryFactorySupport$QueryExecutorMethodInterceptor.invoke(RepositoryFactorySupport.java:578)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)
	at org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor.invoke(DefaultMethodInvokingMethodInterceptor.java:59)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:92)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)
	at org.springframework.data.repository.core.support.SurroundingTransactionDetectorMethodInterceptor.invoke(SurroundingTransactionDetectorMethodInterceptor.java:61)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212)
	at com.sun.proxy.$Proxy58.findAll(Unknown Source)
```

经查，Item 类需要无参构造函数，否则会抛此异常。


	