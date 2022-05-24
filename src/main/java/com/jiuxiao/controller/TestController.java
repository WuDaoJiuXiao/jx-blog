package com.jiuxiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 新建项目后测试环境
 *
 * @Author: 悟道九霄
 * @Date: 2022年05月23日 17:37
 * @Version: 1.0.0
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String test(){
        return "index";
    }
}