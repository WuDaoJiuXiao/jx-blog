-- ------------------------------------
-- Create database and all table
-- ------------------------------------

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;


-- ------------------------------------
-- Table structure for `t_article`
-- ------------------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`
(
    `id`                 int(32)      NOT NULL COMMENT '文章id',
    `title`              varchar(200) NOT NULL DEFAULT '' COMMENT '文章标题',
    `head_image_address` varchar(200) NOT NULL DEFAULT '' COMMENT '文章配图地址',
    `content`            longtext     NOT NULL COMMENT '文章内容',
    `created_time`       timestamp    NOT NULL COMMENT '创建时间',
    `last_update_time`   timestamp    NOT NULL COMMENT '上次修改时间',
    `comment_count`      int(32)      NOT NULL DEFAULT '0' COMMENT '评论数',
    `read_count`         int(32)      NOT NULL DEFAULT '0' COMMENT '浏览量',
    `author_name`        varchar(200) NOT NULL COMMENT '文章作者姓名',
    `copyright`          varchar(200) NOT NULL DEFAULT '原创' COMMENT '文章版权',
    `tags`               varchar(200) NOT NULL COMMENT '文章标签',
    `sort`               varchar(200) NOT NULL COMMENT '文章分类',
    `open_comment`       int(1)       NOT NULL DEFAULT '1' COMMENT '是否开启评论',
    `open_copyright`     int(1)       NOT NULL DEFAULT '1' COMMENT '是否开启版权信息',
    `type`               varchar(200) NOT NULL COMMENT '文章类型',
    PRIMARY KEY (`id`)
) COMMENT = '文章表' ENGINE = InnoDB
                  AUTO_INCREMENT = 1
                  DEFAULT CHARSET = utf8;


-- ------------------------------------
-- Table structure for `t_user`
-- ------------------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`       int(32)      NOT NULL COMMENT '用户id',
    `username` varchar(200) NOT NULL COMMENT '用户名',
    `password` varchar(200) NOT NULL COMMENT '用户密码',
    `email`    varchar(200) NOT NULL COMMENT '用户邮箱',
    `admin`    int(1)       NOT NULL COMMENT '用户权限，1 为管理员',
    PRIMARY KEY (`id`)
) COMMENT = '用户表' ENGINE = InnoDB
                  AUTO_INCREMENT = 1
                  DEFAULT CHARSET = utf8;


-- ------------------------------------
-- Table structure for `t_tags`
-- ------------------------------------
DROP TABLE IF EXISTS `t_tags`;
CREATE TABLE `t_tags`
(
    `id`               int(32)      NOT NULL COMMENT '标签id',
    `name`             varchar(200) NOT NULL COMMENT '标签名称',
    `ref_count`        int(32)      NOT NULL DEFAULT '0' COMMENT '被引用次数',
    `created_time`     timestamp    NOT NULL COMMENT '创建时间',
    `last_update_time` timestamp    NOT NULL COMMENT '上次修改时间',
    PRIMARY KEY (`id`)
) COMMENT = '标签表' ENGINE = InnoDB
                  AUTO_INCREMENT = 1
                  DEFAULT CHARSET = utf8;


-- ------------------------------------
-- Table structure for `t_sort`
-- ------------------------------------
DROP TABLE IF EXISTS `t_sort`;
CREATE TABLE `t_sort`
(
    `id`               int(32)      NOT NULL COMMENT '分类id',
    `name`             varchar(200) NOT NULL COMMENT '分类名称',
    `ref_count`        int(32)      NOT NULL DEFAULT '0' COMMENT '被引用次数',
    `created_time`     timestamp    NOT NULL COMMENT '创建时间',
    `last_update_time` timestamp    NOT NULL COMMENT '上次修改时间',
    PRIMARY KEY (`id`)
) COMMENT = '分类表' ENGINE = InnoDB
                  AUTO_INCREMENT = 1
                  DEFAULT CHARSET = utf8;


-- ------------------------------------
-- Table structure for `t_comment`
-- ------------------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`
(
    `id`                int(32)      NOT NULL COMMENT '评论id',
    `nickname`          varchar(100) NOT NULL COMMENT '评论者昵称',
    `email`             varchar(200) NOT NULL COMMENT '评论者邮箱',
    `avatar`            varchar(400) NOT NULL COMMENT '评论者头像链接',
    `content`           varchar(400) NOT NULL COMMENT '评论内容',
    `created_time`      timestamp    NOT NULL COMMENT '发布评论时间',
    `blog_id`           int(32) COMMENT '评论所属的博客id',
    `parent_comment_id` int(32) COMMENT '父级评论的id',
    PRIMARY KEY (`id`)
) COMMENT = '评论表' ENGINE = InnoDB
                  AUTO_INCREMENT = 1
                  DEFAULT CHARSET = utf8;


-- ------------------------------------
-- Table structure for `t_link`
-- ------------------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link`
(
    `id`               int(32)      NOT NULL COMMENT '友链id',
    `name`             varchar(200) NOT NULL COMMENT '友链名称',
    `address`          varchar(200) NOT NULL COMMENT '友链地址',
    `image_address`    varchar(200) NOT NULL COMMENT '友链头像地址',
    `created_time`     timestamp    NOT NULL COMMENT '创建时间',
    `last_update_time` timestamp    NOT NULL COMMENT '上次修改时间',
    `is_check`         varchar(10)  NOT NULL COMMENT '是否审核',
    PRIMARY KEY (`id`)
) COMMENT = '友链表' ENGINE = InnoDB
                  AUTO_INCREMENT = 1
                  DEFAULT CHARSET = utf8;


-- ------------------------------------
-- Table structure for `t_archive`
-- ------------------------------------
DROP TABLE IF EXISTS `t_archive`;
CREATE TABLE `t_archive`
(
    `id`           int(32)   NOT NULL COMMENT '归档id',
    `created_time` timestamp NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) COMMENT = '归档表' ENGINE = InnoDB
                  AUTO_INCREMENT = 1
                  DEFAULT CHARSET = utf8;


-- ------------------------------------
-- Table structure for `t_journal`
-- ------------------------------------
DROP TABLE IF EXISTS `t_journal`;
CREATE TABLE `t_journal`
(
    `id`                  int(32)      NOT NULL COMMENT '日志id',
    `operate_name`        varchar(200) NOT NULL COMMENT '操作名称',
    `success`             varchar(50)  NOT NULL COMMENT '操作是否成功',
    `request_ip`          varchar(200) NOT NULL COMMENT '请求者的ip地址',
    `request_class_name`  varchar(200) NOT NULL COMMENT '请求的类名',
    `request_method_name` varchar(200) NOT NULL COMMENT '请求的方法名',
    `request_url`         varchar(300) NOT NULL COMMENT '请求的URL',
    `created_time`        timestamp    NOT NULL COMMENT '日志创建时间',
    PRIMARY KEY (`id`)
) COMMENT = '日志表' ENGINE = InnoDB
                  AUTO_INCREMENT = 1
                  DEFAULT CHARSET = utf8;


-- ----------------------------------------
-- Administrator default username : admin
-- Administrator default password : 123456
-- ----------------------------------------
INSERT INTO `t_user`(`id`, `username`, `password`, `email`, `admin`)
VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1667191252@qq.com', '1');


-- ----------------------------------------
-- Restore foreign key constraints
-- ----------------------------------------
SET FOREIGN_KEY_CHECKS = 1;