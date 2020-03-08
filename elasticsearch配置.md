# elasticsearch 配置

>本项目基于 elasticsearch-5.6.16，主要是spring-boot-2.0.3.RELEASE 默认的elasticsearch的版本，其他elasticsearch的版本可能不兼容。
 若想使用其他版本的elasticsearch，请注意版本问题。

## 下载elasticsearch

 [点击此处](https://www.elastic.co/cn/downloads/past-releases#elasticsearch)跳转至elasticsearch下载页面
 
##  elasticsearch 配置文件修改

配置文件在 `${elasticsearch目录}/conf/elasticsearch.yml`

主要修改一下配置，完整的配置文件，请参考本项目下的 /es示例配置/elasticsearch.yml

```
## 集群名字，默认是 elasticsearch，也可改为其他
cluster.name: elasticsearch

## 节点名称，可以任意修改
node.name: node-1

## 节点地址（机器的IP）
network.host: 192.168.43.205

## 节点地址，至少写入自己的IP，若有多个节点，则需要列出其他节点的地址
discovery.zen.ping.unicast.hosts: ["192.168.43.205"]

```

## head 插件安装（可选，建议安装）

> 亲测 head 插件安装启动后无法连接 elasticsearch，具体原因未知。

[点击此处](https://github.com/mobz/elasticsearch-head)以查看具体说明（https://github.com/mobz/elasticsearch-head）

[点击此处](https://www.elastic.co/guide/en/elasticsearch/plugins/5.6/index.html)查看 elasticsearch-5.6.16插件相关的官方文档（https://www.elastic.co/guide/en/elasticsearch/plugins/5.6/index.html）

```

git clone git://github.com/mobz/elasticsearch-head.git
cd elasticsearch-head
npm install
npm run start

open http://localhost:9100/
```

## 常用URL

 - 查看索引信息:     http://192.168.43.205:9200/_cat/indices?v
 
 - 查看Mapping,Mapping用于搜索，没有Mapping将无法搜索: http://192.168.43.205:9200/索引/_mapping

