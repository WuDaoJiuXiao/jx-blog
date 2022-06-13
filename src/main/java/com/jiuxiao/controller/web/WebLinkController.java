package com.jiuxiao.controller.web;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.pojo.Link;
import com.jiuxiao.service.link.LinkService;
import com.jiuxiao.tools.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 前端友链页面控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月13日 10:45
 * @Version: 1.0.0
 */
@Controller
public class WebLinkController {

    @Autowired
    private LinkService linkService;

    @MyLogAnnotation("查询")
    @RequestMapping("/link")
    public String link(Model model) {
        List<Link> linkList = linkService.queryAllLinkList();
        ArrayList<Link> successLink = new ArrayList<>();
        for (Link link : linkList) {
            if (link.getIsCheck().equals("是")) {
                successLink.add(link);
            }
        }

        model.addAttribute("successLink", successLink);
        return "mainPage/linkPage";
    }

    /**
     * @param link
     * @return: java.lang.String
     * @decription 提交友链
     * @date 2022/6/13 12:45
     */
    @MyLogAnnotation("设置信息")
    @PostMapping("/auditLink")
    public String auditLink(Link link) {
        Timestamp currentTime = TimeTools.getCurrentTime();

        link.setId(linkService.queryLinkCount() + 1);
        link.setCreatedTime(currentTime);
        link.setLastUpdateTime(currentTime);
        link.setIsCheck("否");

        linkService.insertLink(link);
        return "redirect:/link";
    }
}