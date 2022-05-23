package com.jiuxiao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新建项目后测试环境
 *
 * @Author: 悟道九霄
 * @Date: 2022年05月23日 17:37
 * @Version: 1.0.0
 */
@RestController
public class DemoController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}