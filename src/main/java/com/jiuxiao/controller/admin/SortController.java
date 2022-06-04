package com.jiuxiao.controller.admin;

import com.jiuxiao.constants.BackendConstants;
import com.jiuxiao.pojo.Sort;
import com.jiuxiao.service.sort.SortService;
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
 * 分类页控制器
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月02日 15:34
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class SortController {

    @Autowired
    private SortService sortService;

    /**
     * 分类管理
     *
     * @param currentPage
     * @param model
     * @return
     */
    @RequestMapping("/sort")
    public String sort(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        List<Sort> sortList = sortService.queryAllSortList();

        Integer pageSize = BackendConstants.SORT_PAGE_SIZE;
        TurnPageTools<Sort> sortTurnPageTools = new TurnPageTools<>();
        PageInfoTools<Sort> pageInfo = sortTurnPageTools.getPageInfo(sortList, currentPage, pageSize);

        model.addAttribute("pageInfo", pageInfo);
        return "backend/control/sortControl";
    }

    /**
     * 跳转到增加分类
     *
     * @return
     */
    @GetMapping("/addSort")
    public String toAddPage() {
        return "backend/add/addSort";
    }

    /**
     * 增加分类
     *
     * @return
     */
    @PostMapping("/addSort")
    public String addSort(@RequestParam("name") String name, Sort sort, Model model) {
        //如果要添加的分类已经在数据库中，则不能添加
        List<Sort> querySorts = sortService.querySortByName(name);
        if (querySorts.isEmpty()) {
            sort.setId(sortService.querySortCount() + 1);
            sort.setRefCount(0);
            Timestamp currentTime = TimeTools.getCurrentTime();
            sort.setCreatedTime(currentTime);
            sort.setLastUpdateTime(currentTime);

            model.addAttribute("msg", null);
            sortService.insertSort(sort);
        }
        return "redirect:/admin/sort";
    }

    /**
     * 跳转到修改分类
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updateSort/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Sort sort = sortService.querySortById(id);
        model.addAttribute("sort", sort);
        return "backend/update/updateSort";
    }

    /**
     * 修改分类页
     *
     * @param sort
     * @return
     */
    @PostMapping("/updateSort")
    public String updateSort(Sort sort) {
        sort.setLastUpdateTime(TimeTools.getCurrentTime());
        sortService.updateSortById(sort);
        return "redirect:/admin/sort";
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteSort/{id}")
    public String deleteSort(@PathVariable("id") Integer id) {
        //删除该条记录后，设置后续的主键 id 从这里开始递增
        sortService.deleteSortById(id);
        sortService.increaseSortFromThis();
        return "redirect:/admin/sort";
    }

    /**
     * 查询结果
     *
     * @param name
     * @param model
     * @return
     */
    @PostMapping("/querySort")
    public String querySort(@RequestParam("name") String name, Model model) {
        //没有输入名字，就显示全部结果
        if (name.equals("") || StringUtils.isEmpty(name)) {
            return "redirect:/admin/sort";
        }
        List<Sort> querySort = sortService.querySortByName(name);
        model.addAttribute("querySort", querySort);
        return "backend/show/showSortSearch";
    }
}