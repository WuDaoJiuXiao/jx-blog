package com.jiuxiao.controller.web;

import com.jiuxiao.annotation.MyLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 关于我页面控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月12日 21:54
 * @Version: 1.0.0
 */
@Controller
public class aboutMeController {

    /**
     * @return: java.lang.String
     * @decription 关于我页面展示
     * @date 2022/6/12 21:57
     */
    @MyLogAnnotation("页面跳转")
    @RequestMapping("/about")
    public String aboutMe() {
        return "mainPage/aboutMePage";
    }
}