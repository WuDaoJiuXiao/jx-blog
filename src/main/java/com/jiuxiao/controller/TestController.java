package com.jiuxiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 无后端时测试前端页面用
 *
 * @Author: 悟道九霄
 * @Date: 2022年05月23日 17:37
 * @Version: 1.0.0
 */
@Controller
public class TestController {

    //博客首页
    @RequestMapping("/")
    public String test01(){
        return "mainPage/index";
    }

    //博文内容页面
    @RequestMapping("/cont")
    public String test02(){
        return "mainPage/blogContents";
    }

    //标签页面
    @RequestMapping("/tag")
    public String test03(){
        return "mainPage/tagsPage";
    }

    //归档页面
    @RequestMapping("/file")
    public String test04(){
        return "mainPage/filePage";
    }

    //关于我页面
    @RequestMapping("/info")
    public String test05(){
        return "mainPage/aboutMePage";
    }

    //友链页面
    @RequestMapping("/link")
    public String test06(){
        return "mainPage/linkPage";
    }

    //------------ 后台页面 ---------------

    //管理员登录页面
    @RequestMapping("/admin/login")
    public String test07(){
        return "backend/adminLogin";
    }

    //后台博客管理
    @RequestMapping("/admin/blog")
    public String test08(){
        return "backend/blogControl";
    }

    //发布博客
    @RequestMapping("/admin/publish")
    public String test09(){
        return "backend/publish";
    }

    //后台标签管理
    @RequestMapping("/admin/tags")
    public String test10(){
        return "backend/tagsControl";
    }

    //后台友链管理
    @RequestMapping("/admin/link")
    public String test11(){
        return "backend/linkControl";
    }
}