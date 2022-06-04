package com.jiuxiao.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 日志控制器
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 15:29
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class LogController {

    @RequestMapping("/log")
    public String log(){
        return "backend/control/logControl";
    }
}