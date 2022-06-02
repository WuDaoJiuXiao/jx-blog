package com.jiuxiao.controller.admin;

import com.jiuxiao.constants.UserConstants;
import com.jiuxiao.pojo.User;
import com.jiuxiao.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 管理员登录控制器
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月01日 10:43
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 从 index 跳转到用户登录页
     *
     * @return
     */
    @RequestMapping
    public String toLogin() {
        return "backend/adminLogin";
    }

    /**
     * 用户登录页
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "backend/welcome";
        } else {
            attributes.addFlashAttribute("message", UserConstants.NAME_AND_PWD_ERROR);
            return "redirect:/admin";
        }
    }

    /**
     * 用户注销
     *
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}