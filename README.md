#### 项目概述

本项目是一个简单的个人博客系统，系统集成了文章、标签、分类、日志、友链五大模块的增删改查功能

是刚学完 SpringBoot 框架后练手的不二之选

#### 项目技术栈

此项目的所有技术栈如下：

|       分类       |     技术栈      |  版本  |
| :--------------: | :-------------: | :----: |
|     开发语言     |      Java       |   8    |
|     开发工具     |      IDEA       | 2020.1 |
|   项目管理工具   |      Maven      | 3.6.1  |
|   **后端框架**   |   SpringBoot    | 2.3.7  |
|   **模板引擎**   |    Thymeleaf    | 3.0.11 |
|    **持久层**    |     MyBatis     | 3.5.9  |
|      数据库      |      MySql      | 5.7.20 |
|   数据库连接池   |      Druid      | 1.1.9  |
|     日志管理     |      slf4j      | 1.7.30 |
|   **前端组件**   |   SemanticUI    | 2.4.0  |
|      js框架      |     jQuery      | 3.5.1  |
|   Markdown插件   |    Editor.md    | 1.5.0  |
| 博客代码高亮插件 |      prism      | 1.28.0 |
|   文章排版插件   |    typo.css     | 2.1.2  |
|     动画插件     |   animate.js    | 4.1.1  |
|   滚动侦测插件   | jquery.scrollTo | 2.1.3  |

该项目所有的技术栈官网如下：

+ 开发语言：[Java](https://www.java.com/en/)

+ 开发工具：[IDEA](https://www.jetbrains.com/idea/)

+ 项目管理工具：[Maven](https://maven.apache.org/index.html)

+ 后端框架：[SpringBoot](https://spring.io/projects/spring-boot)

+ 模板引擎：[Thymeleaf](https://www.thymeleaf.org/)

+ 持久层：[MyBatis](https://mybatis.net.cn/)

+ 数据库：[MySql](https://www.mysql.com/cn/)

+ 数据库连接池：[Druid](https://github.com/alibaba/druid)

+ 日志管理：[slf4j](https://www.slf4j.org/)

+ 前端组件：[SemanticUI](https://semantic-ui.com/)

+ js框架：[jQuery](https://jquery.com/)

+ MarkDow插件：[Editor.md](http://editor.md.ipandao.com/)

+ 代码高亮插件：[prism](https://github.com/PrismJS/prism)

+ 文章排版插件：[typo.css](https://github.com/sofish/typo.css)

+ 动画插件：[animate.js](https://animate.style/)

+ 滚动侦测插件：[jQuery.scrollTo](https://github.com/flesler/jquery.scrollTo)

#### 项目预览

前端首页

![image-20220613133054482](https://my-pic-1309513254.cos.ap-shanghai.myqcloud.com//image-20220613133054482.png)

后台管理

![image-20220613133524381](https://my-pic-1309513254.cos.ap-shanghai.myqcloud.com//image-20220613133524381.png)

#### 快速运行

1. 使用 git 下载项目到本地

```shell
git clone git@github.com:WuDaoJiuXiao/jx-blog.git
```

2. 创建数据库

+ 使用命令 `net start mysql` 启动数据库

+ 运行本项目的 sql 文件（目录为：`jx-blog/sql/createTable.sql`）

3. 打开项目的依赖管理文件 `pom.xml` ，安装项目所需的依赖

4. 修改配置文件 `application-dev.yaml` 中的数据库配置信息为自己的数据库相关信息

5. 测试数据库连接是否成功

6. 数据库连接成功后，即可启动本项目（默认端口为 `8080`）

> 本项目为练手用，因此存在部分 bug（比如数据库表中无信息时，会出现分页工具类的数组下表越界问题）
>
> 但是本人较懒。。。不准备修复了，所以增加了新的 sql 初始化数据，这样运行就不会报错（hhhhh）
