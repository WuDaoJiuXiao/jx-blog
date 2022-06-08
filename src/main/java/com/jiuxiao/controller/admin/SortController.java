package com.jiuxiao.controller.admin;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.constants.BackendConstants;
import com.jiuxiao.pojo.Sort;
import com.jiuxiao.service.admin.sort.SortService;
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
     * @param currentPage
     * @param model
     * @return: java.lang.String
     * @decription 分类管理
     * @date 2022/6/5 9:59
     */
    @MyLogAnnotation("查询")
    @RequestMapping("/sort")
    public String sort(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        List<Sort> sortList = sortService.queryAllSortList();

        Integer sortCount = sortList.size();
        Integer pageSize = BackendConstants.SORT_PAGE_SIZE;
        TurnPageTools<Sort> sortTurnPageTools = new TurnPageTools<>();
        PageInfoTools<Sort> pageInfo = sortTurnPageTools.getPageInfo(sortList, currentPage, pageSize);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("sortCount", sortCount);
        return "backend/control/sortControl";
    }

    /**
     * @return: java.lang.String
     * @decription 跳转到增加分类
     * @date 2022/6/5 9:59
     */
    @MyLogAnnotation("跳转页面")
    @GetMapping("/addSort")
    public String toAddPage() {
        return "backend/add/addSort";
    }

    /**
     * @param name
     * @param sort
     * @return: java.lang.String
     * @decription 增加分类
     * @date 2022/6/5 9:59
     */
    @MyLogAnnotation("新增")
    @PostMapping("/addSort")
    public String addSort(@RequestParam("name") String name, Sort sort) {
        //如果要添加的分类已经在数据库中，则不能添加
        List<Sort> querySorts = sortService.querySortByName(name);
        if (querySorts.isEmpty()) {
            sort.setId(sortService.querySortCount() + 1);
            sort.setRefCount(0);
            Timestamp currentTime = TimeTools.getCurrentTime();
            sort.setCreatedTime(currentTime);
            sort.setLastUpdateTime(currentTime);

            sortService.insertSort(sort);
        }
        return "redirect:/admin/sort";
    }

    /**
     * @param id
     * @param model
     * @return: java.lang.String
     * @decription 跳转到修改分类
     * @date 2022/6/5 9:59
     */
    @MyLogAnnotation("跳转页面")
    @GetMapping("/updateSort/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Sort sort = sortService.querySortById(id);
        model.addAttribute("sort", sort);
        return "backend/update/updateSort";
    }

    /**
     * @param sort
     * @return: java.lang.String
     * @decription 修改分类页
     * @date 2022/6/5 9:59
     */
    @MyLogAnnotation("更新")
    @PostMapping("/updateSort")
    public String updateSort(Sort sort) {
        sort.setLastUpdateTime(TimeTools.getCurrentTime());
        sortService.updateSortById(sort);
        return "redirect:/admin/sort";
    }

    /**
     * @param id
     * @return: java.lang.String
     * @decription 删除分类
     * @date 2022/6/5 9:59
     */
    @MyLogAnnotation("删除")
    @RequestMapping("/deleteSort/{id}")
    public String deleteSort(@PathVariable("id") Integer id) {
        //删除该条记录后，设置后续的主键 id 从这里开始递增
        sortService.deleteSortById(id);
        sortService.increaseSortFromThis();
        return "redirect:/admin/sort";
    }

    /**
     * @param name
     * @param model
     * @return: java.lang.String
     * @decription 查询结果
     * @date 2022/6/5 10:00
     */
    @MyLogAnnotation("查询")
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