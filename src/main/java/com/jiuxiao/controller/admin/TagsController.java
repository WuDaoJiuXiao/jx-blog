package com.jiuxiao.controller.admin;

import com.jiuxiao.constants.BackendConstants;
import com.jiuxiao.pojo.Tags;
import com.jiuxiao.service.tags.TagsService;
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
 * 标签页控制器
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 15:12
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    /**
     * 标签管理
     *
     * @param currentPage
     * @param model
     * @return
     */
    @RequestMapping("/tags")
    public String tags(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        List<Tags> tagsList = tagsService.queryAllTagsList();

        Integer pageSize = BackendConstants.TAGS_PAGE_SIZE;
        TurnPageTools<Tags> sortTurnPageTools = new TurnPageTools<>();
        PageInfoTools<Tags> pageInfo = sortTurnPageTools.getPageInfo(tagsList, currentPage, pageSize);

        model.addAttribute("pageInfo", pageInfo);
        return "backend/control/tagsControl";
    }

    /**
     * 跳转到增加标签
     *
     * @return
     */
    @GetMapping("/addTags")
    public String toAddPage() {
        return "backend/add/addTags";
    }

    /**
     * 增加标签
     *
     * @param name
     * @param tags
     * @param model
     * @return
     */
    @PostMapping("/addTags")
    public String addTags(@RequestParam("name") String name, Tags tags, Model model) {
        //如果要添加的分类已经在数据库中，则不能添加
        List<Tags> queryTags = tagsService.queryTagsByName(name);
        if (queryTags.isEmpty()) {
            tags.setId(tagsService.queryTagsCount() + 1);
            tags.setRefCount(0);
            Timestamp currentTime = TimeTools.getCurrentTime();
            tags.setCreatedTime(currentTime);
            tags.setLastUpdateTime(currentTime);

            model.addAttribute("msg", null);
            tagsService.insertTags(tags);
        }
        return "redirect:/admin/tags";
    }

    /**
     * 跳转到修改标签
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updateTags/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Tags tags = tagsService.queryTagsById(id);
        model.addAttribute("tags", tags);
        return "backend/update/updateTags";
    }

    /**
     * 修改标签页
     *
     * @param tags
     * @return
     */
    @PostMapping("/updateTags")
    public String updateTags(Tags tags) {
        tags.setLastUpdateTime(TimeTools.getCurrentTime());
        tagsService.updateTagsById(tags);
        return "redirect:/admin/tags";
    }

    /**
     * 删除标签
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteTags/{id}")
    public String deleteTags(@PathVariable("id") Integer id) {
        //删除该条记录后，设置后续的主键 id 从这里开始递增
        tagsService.deleteTagsById(id);
        tagsService.increaseTagsFromThis();
        return "redirect:/admin/tags";
    }

    /**
     * 查询结果
     *
     * @param name
     * @param model
     * @return
     */
    @PostMapping("/queryTags")
    public String queryTags(@RequestParam("name") String name, Model model) {
        //没有输入名字，就显示全部结果
        if (name.equals("") || StringUtils.isEmpty(name)) {
            return "redirect:/admin/tags";
        }
        List<Tags> queryTags = tagsService.queryTagsByName(name);
        model.addAttribute("queryTags", queryTags);
        return "backend/show/showTagsSearch";
    }
}