# 基于SpringCloud的仿微博系统
[我的博客](https://www.cnblogs.com/lgjlife/)
## 设计思路
![](https://github.com/lgjlife/micro-blog/blob/master/micro-blog%20%E8%AE%BE%E8%AE%A1%E5%9B%BE.jpg)

# 模块说明
├─microblog 父工程

├─── config-repo 配置中心配置文件

├─── FrontEnd 前端项目文件,nginx 配置文件

├─── img  README.md文件所用图片

├─── microblog-blog 网关应用

     ├─── blog-dao
     
     ├─── blog-service
     
     ├─── blog-web
     
├─── microblog-common 公共实现类,配置为SpringBoot-starter

├─── microblog-chat 私信应用

├─── microblog-config 配置中心应用

├─── microblog-gateway 网关应用

     ├─── microblog-gateway-controller  网关控制层
     
     ├─── microblog-gateway-service     网关服务层
     
     ├─── microblog-gateway-dao         网关数据层
 
├─── microblog-log 日志模块

├─── microblog-msg 邮件和短信处理应用

├─── microblog-points 积分应用

    ├─── microblog-points-dao

    ├─── microblog-points-service

    ├─── microblog-points-web
     

├─── microblog-scheduler 任务调度应用

     ├─── microblog-scheduler-dao 
     
     ├─── microblog-scheduler-service
     
     ├─── microblog-scheduler-web

├─── microblog-search 搜索应用

├─── microblog-support  spring cloud 配套服务

     ├─── microblog-hystrix  hystrix 监控应用
     
     ├─── microblog-sleuth
     
     ├─── microblog-admin  监控
     
     ├─── microblog-center 注册中心应用 port: 8001
     
     ├─── zipkin-server  zipkin 监控

├─── mysql 数据库文件
      
      ├─── all 整个工程的sql文件
      
           ├───  microblog-sql-all-xxxx-xx-xx-xx:xx:xx.sql
           
      ├───　blog.sql 微博相关的sql
      
      ├───　job.sql　 定时任务
      
      ├───　points.sql  积分应用　
      
      ├───　quartz.sql  quartz本身的sql
      
      ├───　user.sql  用户相关

├─── 项目的一些启动脚本          

├─── github 上传脚本

├─── micro-blog 设计图.jpg

## 使用工具和技术
### 工具
* 开发环境： IDEA
* 项目构建：　Maven
* 前端开发工具： Brackets
* 版本管理： Git
* 思维导图软件： MindMaster
### 技术
* 核心框架： Spring ,Spring MVC, Spring Boot, Spring Cloud 
* 持久层： Mybatis
* 数据库： MySQL
* 数据库连接池： Druid
* 缓存： Redis
* 分布式锁：　Redisson
* 反向代理服务器： Nginx
* 认证方式:  JWT
* 网络通信： Netty
* 消息中间件： RocketMQ
* 搜索：elasticsearch
* 日志： Logback
* 日志聚合： Kafka + Logstash + elasticsearch + Kibana
* 前端:Html,Javascript,css,jquery

## 设计思路

### 登录拦截
　整个系统中，有些url是不需要用户登录就可以访问的，有些是需要登录之后才能访问，因此需要进行路径拦截校验是否需要登录。

### 如何启动项目
1. 安装Redis并启动
2. 安装Mysql并启动，导入sql文件
3. 安装RabbitMQ并启动
4. 安装elasticsearch并启动
5. 安装nginx，配置文件，并启动
6. 配置

    6.1  配置Mysql用户名和密码
    
    6.2  配置Redis用户名和密码
    
    6.3  配置RabbitMq 
    
    6.4  配置elasticsearch
    
    6.5  配置nginx
    
7. 启动项目
8. 访问路径

    8.1 [首页:http://localhost:7300/index.html](http://localhost:7300/index.html)
    
    8.2 [监控页面:http://localhost:7300/monitor/index.html](http://localhost:7300/monitor/index.html)


### 数据库文件
每次git提交时都会执行数据库备份操作，备份类位于[数据库备份类](https://github.com/lgjlife/micro-blog/blob/master/microblog-common%2Fsrc%2Fmain%2Fjava%2Fcom%2Fcloud%2Fmicroblog%2Fcommon%2Fbackup%2FMysqlBackupUtil.java)。
备份的文件存放于[数据库备份文件 目录：mysql/all](https://github.com/lgjlife/micro-blog/tree/master/mysql/all)，最新日期为最新的操作，文件名称(xxx/mysql/all/microblog-sql-all-2019-03-30-16:22:33.sql)。
[工程目录：mysql 存放各个模块的sql文件](https://github.com/lgjlife/micro-blog/tree/master/mysql)

请选择日期最新备份文件进行数据库导入操作。
```java
mysql -uroot -p
mysql> create database microblog
mysql> use microblog
//xxx/mysql/all/microblog-sql-all-2019-03-30-16:22:33.sql 为备份文件本身的目录
mysql> source xxx/mysql/all/microblog-sql-all-2019-03-30-16:22:33.sql
```
### Controller打印请求日志
* 使用AOP实现
* [切面类定义](https://github.com/lgjlife/micro-blog/blob/master/microblog-common/src/main/java/com/cloud/microblog/common/aop/syslog/aspect/PrintUrlAspect.java)
* 如何使用：

1.引入pom
```xml
<dependency>
    <groupId>com.microblog</groupId>
    <artifactId>microblog-common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```
2.application.yml配置
```yaml
microblog:
  common:
    # 使能打印访问Url，在Controller方法上添加注解@PrintUrlAnno
    printUrlEnable: true
    # 使能打印方法执行耗时，在方法上添加注解@PrintUseTimeAnno
    printUseTimeEnable: true
```

3.Controller方法上使用
```$xslt
@PrintUrlAnno
@PostMapping("/login")
public BaseResult login(@RequestBody Map<String, Object> requestMap){
}
```
4.输出
```
访问  com.microblog.chat.controller.UserController  method = login  路径 = /user/login  描述：
```
* 获取方法执行时间： @PrintUseTimeAspect   

## 前端页面
![首页](https://github.com/lgjlife/micro-blog/blob/master/img/index.png)
![登录页](https://github.com/lgjlife/micro-blog/blob/master/img/login.png)
![注册页](https://github.com/lgjlife/micro-blog/blob/master/img/register.png)