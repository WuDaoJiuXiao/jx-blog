package com.jiuxiao.controller.web;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.constants.WebConstants;
import com.jiuxiao.pojo.Article;
import com.jiuxiao.pojo.Sort;
import com.jiuxiao.service.article.ArticleService;
import com.jiuxiao.service.sort.SortService;
import com.jiuxiao.tools.PageInfoTools;
import com.jiuxiao.tools.TurnPageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 前端分类控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月11日 21:42
 * @Version: 1.0.0
 */
@Controller
public class WebSortController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SortService sortService;

    /**
     * @param sortId
     * @param currentPage
     * @param model
     * @return: java.lang.String
     * @decription 分类页面
     * @date 2022/6/12 10:31
     */
    @MyLogAnnotation("查询")
    @RequestMapping("/sort/{sortId}/{currentPage}")
    public String sort(@PathVariable("sortId") Integer sortId,
                       @PathVariable("currentPage") Integer currentPage,
                       Model model) {
        //从其他页面跳转到分类页，默认页码为 -1
        if (currentPage == -1) {
            currentPage = 1;
        }

        List<Map<Object, Object>> sortMapList = articleService.querySortList();
        Integer pageSize = WebConstants.SORT_PAGE_SIZE;

        TurnPageTools<Map<Object, Object>> pageTools = new TurnPageTools<>();
        PageInfoTools<Map<Object, Object>> pageInfo = pageTools.getPageInfo(sortMapList, currentPage, pageSize);

        //从其他页面跳转到分类页，默认传分类的 id 为 -1，
        if (sortId == -1) {
            sortId = (Integer) sortMapList.get(0).get("sid");
        }
        System.out.println("sortId -->" + sortId);
        //根据真实的 Id，去文章表中查询该分类名对应的文章列表
        Sort querySort = sortService.querySortById(sortId);
        List<Article> articleList = articleService.queryArticleBySortName(querySort.getName());

        model.addAttribute("articleList", articleList);
        model.addAttribute("sortMapList", sortMapList);
        model.addAttribute("activeId", sortId);
        model.addAttribute("pageInfo", pageInfo);
        return "mainPage/sortPage";
    }
}