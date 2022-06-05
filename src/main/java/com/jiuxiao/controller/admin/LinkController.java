package com.jiuxiao.controller.admin;

import com.jiuxiao.constants.BackendConstants;
import com.jiuxiao.pojo.Link;
import com.jiuxiao.service.link.LinkService;
import com.jiuxiao.tools.PageInfoTools;
import com.jiuxiao.tools.TimeTools;
import com.jiuxiao.tools.TurnPageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * 友链控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 15:34
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * @param currentPage
     * @param model
     * @return: java.lang.String
     * @decription 友链管理
     * @date 2022/6/5 15:21
     */
    @RequestMapping("/link")
    public String link(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        List<Link> linkList = linkService.queryAllLinkList();

        Integer linkCount = linkList.size();
        Integer pageSize = BackendConstants.LINK_PAGE_SIZE;
        TurnPageTools<Link> pageTools = new TurnPageTools<>();
        PageInfoTools<Link> pageInfo = pageTools.getPageInfo(linkList, currentPage, pageSize);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("linkCount", linkCount);
        return "backend/control/linkControl";
    }

    /**
     * @return: java.lang.String
     * @decription 跳转到增加友链页
     * @date 2022/6/5 15:24
     */
    @GetMapping("/addLink")
    public String toAdd() {
        return "backend/add/addLink";
    }

    /**
     * @param link
     * @return: java.lang.String
     * @decription 添加友链
     * @date 2022/6/5 15:46
     */
    @PostMapping("/addLink")
    public String addLink(Link link) {
        List<Link> linkList = linkService.queryLinkByName(link.getName());
        if (linkList.isEmpty()) {
            link.setId(linkService.queryLinkCount() + 1);
            Timestamp currentTime = TimeTools.getCurrentTime();
            link.setCreatedTime(currentTime);
            link.setLastUpdateTime(currentTime);
            linkService.insertLink(link);
        }
        return "redirect:/admin/link";
    }

    /**
     * @param id
     * @param model
     * @return: java.lang.String
     * @decription 跳转到修改友链页面
     * @date 2022/6/5 16:44
     */
    @GetMapping("/updateLink/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Link link = linkService.queryLinkById(id);
        model.addAttribute("link", link);
        return "backend/update/updateLink";
    }

    /**
     * @param link
     * @return: java.lang.String
     * @decription 更新友链
     * @date 2022/6/5 16:47
     */
    @PostMapping("/updateLink")
    public String updateLink(Link link) {
        link.setLastUpdateTime(TimeTools.getCurrentTime());
        linkService.updateLink(link);
        return "redirect:/admin/link";
    }

    /**
     * @param id
     * @return: java.lang.String
     * @decription 删除友链
     * @date 2022/6/5 17:22
     */
    @RequestMapping("/deleteLink/{id}")
    public String deleteLink(@PathVariable("id") Integer id) {
        linkService.deleteLinkById(id);
        linkService.increaseLinkFromThis();
        return "redirect:/admin/link";
    }

    /**
     * @param name
     * @param model
     * @return: java.lang.String
     * @decription 查询结果
     * @date 2022/6/5 17:22
     */
    @PostMapping("/queryLink")
    public String queryTags(@RequestParam("name") String name, Model model) {
        if (name.equals("") || StringUtils.isEmpty(name)) {
            return "redirect:/admin/link";
        }
        List<Link> linkList = linkService.queryLinkByName(name);
        for (Link link : linkList) {
            System.out.println(link);
        }

        model.addAttribute("linkList", linkList);
        return "backend/show/showLinkSearch";
    }
}