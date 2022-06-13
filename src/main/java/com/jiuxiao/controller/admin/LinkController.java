package com.jiuxiao.controller.admin;

import com.jiuxiao.annotation.MyLogAnnotation;
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
import java.util.ArrayList;
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
    @MyLogAnnotation("查询")
    @RequestMapping("/link")
    public String link(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        List<Link> linkList = linkService.queryAllLinkList();

        ArrayList<Link> successLink = new ArrayList<>();
        ArrayList<Link> failLink = new ArrayList<>();
        //通过审核的和未通过审核的分开展示
        for (Link link : linkList) {
            if (link.getIsCheck().equals("是")) {
                successLink.add(link);
            } else {
                failLink.add(link);
            }
        }

        Integer linkCount = successLink.size();
        Integer pageSize = BackendConstants.LINK_PAGE_SIZE;
        TurnPageTools<Link> pageTools = new TurnPageTools<>();
        PageInfoTools<Link> pageInfo = pageTools.getPageInfo(successLink, currentPage, pageSize);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("failLink", failLink);
        model.addAttribute("linkCount", linkCount);
        return "backend/control/linkControl";
    }

    /**
     * @return: java.lang.String
     * @decription 跳转到增加友链页
     * @date 2022/6/5 15:24
     */
    @MyLogAnnotation("跳转页面")
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
    @MyLogAnnotation("新增")
    @PostMapping("/addLink")
    public String addLink(Link link) {
        List<Link> linkList = linkService.queryLinkByName(link.getName());
        if (linkList.isEmpty()) {
            link.setId(linkService.queryLinkCount() + 1);
            Timestamp currentTime = TimeTools.getCurrentTime();
            link.setCreatedTime(currentTime);
            link.setLastUpdateTime(currentTime);
            link.setIsCheck("是");
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
    @MyLogAnnotation("跳转页面")
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
    @MyLogAnnotation("更新")
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
    @MyLogAnnotation("删除")
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
    @MyLogAnnotation("查询")
    @PostMapping("/queryLink")
    public String queryTags(@RequestParam("name") String name, Model model) {
        if (name.equals("") || StringUtils.isEmpty(name)) {
            return "redirect:/admin/link";
        }

        //只查询通过申请的友链
        List<Link> linkList = linkService.queryLinkByName(name);
        ArrayList<Link> successList = new ArrayList<>();
        for (Link link : linkList) {
            if (link.getIsCheck().equals("是")) {
                successList.add(link);
            }
        }

        model.addAttribute("successList", successList);
        return "backend/show/showLinkSearch";
    }

    /**
     * @param id
     * @return: java.lang.String
     * @decription 同意友链申请
     * @date 2022/6/13 10:36
     */
    @MyLogAnnotation("更新")
    @RequestMapping("/passLink/{id}")
    public String checkLink(@PathVariable("id") Integer id) {
        //通过友链申请，只需要将 isCheck 属性由 “否” 改变为 “是” 即可
        Link link = linkService.queryLinkById(id);
        Timestamp currentTime = TimeTools.getCurrentTime();
        link.setCreatedTime(currentTime);
        link.setLastUpdateTime(currentTime);
        link.setIsCheck("是");

        linkService.updateLink(link);
        return "redirect:/admin/link";
    }
}