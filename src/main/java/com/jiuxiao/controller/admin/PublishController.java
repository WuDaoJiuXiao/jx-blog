package com.jiuxiao.controller.admin;

import com.jiuxiao.annotation.MyLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客发布控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月05日 17:46
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class PublishController {

    /**
     * @return: java.lang.String
     * @decription 跳转到博客发布页面
     * @date 2022/6/5 17:47
     */
    @MyLogAnnotation("跳转页面")
    @RequestMapping("/publish")
    public String publish() {
        return "backend/control/publish";
    }

}