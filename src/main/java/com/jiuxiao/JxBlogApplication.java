package com.jiuxiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jiuxiao.mapper")
public class JxBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxBlogApplication.class, args);
    }
}
