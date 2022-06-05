package com.jiuxiao.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 友链控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 15:34
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class LinkController {

    /**
     * @return: java.lang.String
     * @decription 跳转友链管理页面
     * @date 2022/6/5 9:56
     */
    @RequestMapping("/link")
    public String link() {
        return "backend/control/linkControl";
    }
}