package com.jiuxiao.controller.admin;

import com.jiuxiao.pojo.Sort;
import com.jiuxiao.service.sort.SortService;
import com.jiuxiao.tools.PageInfoTools;
import com.jiuxiao.tools.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * 分类页面控制器
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
     * 分类管理页面
     *
     * @return
     */
    @RequestMapping("/sort")
    public String sort(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        List<Sort> sortList = sortService.queryAllSortList();
        PageInfoTools<Sort> pageInfo = new PageInfoTools<Sort>(sortList.size(), currentPage);
        Integer pageSize = pageInfo.getPageSize();

        //已经是最后一页，点击下一页依然是最后一页
        if (currentPage >= pageInfo.getTotalPage()) {
            pageInfo.setCurrentPage(pageInfo.getTotalPage());
            pageInfo.setDataList(sortList.subList((pageInfo.getCurrentPage() - 1) * pageSize, sortList.size()));
        } else if (currentPage == 0) {//已经是第一页，点击上一页依然是最后一页
            pageInfo.setCurrentPage(1);
            pageInfo.setDataList(sortList.subList(0, pageSize));
        } else {//正常情况
            pageInfo.setDataList(sortList.subList((currentPage - 1) * pageSize, currentPage * pageSize));
        }

        model.addAttribute("pageInfo", pageInfo);
        return "backend/sortControl";
    }

    /**
     * 跳转到增加分类页
     *
     * @return
     */
    @GetMapping("/addSort")
    public String toAddPage() {
        return "backend/addSort";
    }

    /**
     * 增加分类
     *
     * @return
     */
    @PostMapping("/addSort")
    public String addSort(Sort sort) {
        sort.setId(sortService.queryMaxCount() + 1);
        sort.setRefCount(0);
        Timestamp currentTime = TimeTools.getCurrentTime();
        sort.setCreatedTime(currentTime);
        sort.setLastUpdateTime(currentTime);

        sortService.insertSort(sort);
        return "redirect:/admin/sort";  //要多加一个 "/"
    }

    /**
     * 跳转到修改分类页
     *
     * @return
     */
    @GetMapping("/updateSort/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Sort sort = sortService.querySortById(id);
        model.addAttribute("sort", sort);
        return "backend/updateSort";
    }

    /**
     * 修改分类页
     *
     * @return
     */
    @PostMapping("/updateSort")
    public String updateSort(Sort sort) {
        sort.setLastUpdateTime(TimeTools.getCurrentTime());
        sortService.updateSortById(sort);
        return "redirect:/admin/sort";
    }

    @RequestMapping("/deleteSort/{id}")
    public String deleteSort(@PathVariable("id") Integer id) {
        //删除该条记录后，设置后续的主键 id 从这里开始递增
        sortService.deleteSortById(id);
        sortService.increaseFromThis();
        return "redirect:/admin/sort";
    }

    /**
     * 查询结果页
     *
     * @param name
     * @return
     */
    @PostMapping("/querySort")
    public String querySort(@RequestParam("name") String name, Model model) {
        //没有输入名字，就显示全部结果
        if (name.equals("") || StringUtils.isEmpty(name)){
            return "redirect:/admin/sort";
        }
        Sort querySort = sortService.querySortByName(name);
        model.addAttribute("querySort", querySort);
        return "backend/showSortSearch";
    }
}