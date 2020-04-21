# HomeworkManagement

## 简介

一个基于 MySQL+Tomcat+Servlet+JSP 的简单作业管理系统

---

## 来源

根据此项目重构：[HomeworkManagement](http://www.huaji.store:23333/summary/HomeworkManagement.git)

源项目说明请见 [博客](http://ry.huaji.store/2020/03/JavaEE-02/)

开源许可证采用 `Apache-2.0`

---

## 更新

### Ver 4.0

- 实现数据库操作的事务管理
- 添加 AOP 依赖
- 使用 AOP 为所有访问添加日志打印

### Ver 3.0

- 使用 Spring IoC 管理对象
- 添加 database-mvc module，派生自 database module
  - web-mvc-context.xml 中添加 component-scan
  - jdbc 包均使用 @Component 注册为 Bean
  - 使用 @Autowired 装配对象
- 重构 controller 包，使用 @Autowired 装配对象
- 更新依赖
  - web-mvc 对应 database-mvc
  - web 对应 database
- 添加数据库 SQL 转储文件

### Ver. 2.0

- 添加 web-mvc module
- 新 module 使用 spring-webmvc 重构 web module

### Ver. 1.0

在源项目的基础上更新如下：

- Maven 项目，用于构建和管理依赖
- Project/Module 模式，一共有三个 Module ：
  - core 用于存放核心代码与工具
  - database 用于存放数据库有关代码
  - web 用于存放 servlet 和 jsp 有关代码
- 数据库连接部分采用了 Hikari 连接池

---

## 开源许可证

Apache-2.0

