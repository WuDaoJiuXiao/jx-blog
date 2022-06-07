package com.jiuxiao.controller.admin;

import com.jiuxiao.annotation.MyLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客管理控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月01日 14:40
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    /**
     * @return: java.lang.String
     * @decription 跳转博客管理页面
     * @date 2022/6/5 9:55
     */
    @MyLogAnnotation("跳转页面")
    @RequestMapping("/blog")
    public String blog() {
        return "backend/control/blogControl";
    }
}