package com.jiuxiao.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客页面控制器
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月01日 14:40
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    /**
     * 跳转博客管理页面
     *
     * @return
     */
    @RequestMapping("/blog")
    public String blog() {
        return "backend/control/blogControl";
    }

    /**
     * 跳转博客发布页面
     *
     * @return
     */
    @RequestMapping("/publish")
    public String publish() {
        return "backend/control/publish";
    }
}