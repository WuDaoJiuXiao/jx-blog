package com.jiuxiao.controller.web;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.constants.WebConstants;
import com.jiuxiao.pojo.Article;
import com.jiuxiao.pojo.Tags;
import com.jiuxiao.service.article.ArticleService;
import com.jiuxiao.service.tags.TagsService;
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
 * 前端标签页控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月12日 11:26
 * @Version: 1.0.0
 */
@Controller
public class WebTagsController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagsService tagsService;

    /**
     * @param tagsId
     * @param currentPage
     * @param model
     * @return: java.lang.String
     * @decription 分类页面
     * @date 2022/6/12 10:31
     */
    @MyLogAnnotation("查询")
    @RequestMapping("/tags/{tagsId}/{currentPage}")
    public String sort(@PathVariable("tagsId") Integer tagsId,
                       @PathVariable("currentPage") Integer currentPage,
                       Model model) {
        //从其他页面跳转到分类页，默认页码为 -1
        if (currentPage == -1) {
            currentPage = 1;
        }

        List<Map<Object, Object>> tagsMapList = articleService.queryTagsList();
        Integer pageSize = WebConstants.TAGS_PAGE_SIZE;

        TurnPageTools<Map<Object, Object>> pageTools = new TurnPageTools<>();
        PageInfoTools<Map<Object, Object>> pageInfo = pageTools.getPageInfo(tagsMapList, currentPage, pageSize);

        //从其他页面跳转到分类页，默认传分类的 id 为 -1，
        if (tagsId == -1) {
            tagsId = (Integer)tagsMapList.get(0).get("tid");
        }

        //根据真实的 Id，去文章表中查询该分类名对应的文章列表
        Tags queryTags = tagsService.queryTagsById(tagsId);
        List<Article> articleList = articleService.queryArticleByTagsName(queryTags.getName());

        model.addAttribute("articleList", articleList);
        model.addAttribute("tagsMapList", tagsMapList);
        model.addAttribute("activeId", tagsId);
        model.addAttribute("pageInfo", pageInfo);
        return "mainPage/tagsPage";
    }
}