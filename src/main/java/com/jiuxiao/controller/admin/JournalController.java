package com.jiuxiao.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 日志控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 15:29
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class JournalController {

    /**
     * @return: java.lang.String
     * @decription 跳转友链管理页面
     * @date 2022/6/5 9:57
     */
    @RequestMapping("/log")
    public String log() {
        return "backend/control/logControl";
    }
}