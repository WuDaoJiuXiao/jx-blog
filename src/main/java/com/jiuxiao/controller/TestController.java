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

    //分类页面
    @RequestMapping("/class")
    public String test03(){
        return "mainPage/classPage";
    }

    //标签页面
    @RequestMapping("/tag")
    public String test04(){
        return "mainPage/tagsPage";
    }

    //杂谈页面
    @RequestMapping("/game")
    public String test05(){
        return "mainPage/gamePage";
    }

    //归档页面
    @RequestMapping("/file")
    public String test06(){
        return "mainPage/filePage";
    }

    //关于我页面
    @RequestMapping("/info")
    public String test07(){
        return "mainPage/aboutMePage";
    }

    //友链页面
    @RequestMapping("/link")
    public String test08(){
        return "mainPage/linkPage";
    }
}