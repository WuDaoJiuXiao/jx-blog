package com.jiuxiao.controller.web;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.constants.WebConstants;
import com.jiuxiao.pojo.Article;
import com.jiuxiao.service.admin.article.ArticleService;
import com.jiuxiao.service.admin.sort.SortService;
import com.jiuxiao.service.admin.tags.TagsService;
import com.jiuxiao.tools.PageInfoTools;
import com.jiuxiao.tools.TurnPageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月09日 9:20
 * @Version: 1.0.0
 */
@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SortService sortService;

    @Autowired
    private TagsService tagsService;

    /**
     * @param currentPage
     * @param model
     * @return: java.lang.String
     * @decription 首页博客、侧边栏组件展示
     * @date 2022/6/9 17:27
     */
    @MyLogAnnotation("查询")
    @RequestMapping("/")
    public String index(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        //博客列表的相关数据
        List<Article> articleList = articleService.queryAllArticleListDESC();
        Integer articleCount = articleList.size();
        Integer pageSize = WebConstants.BLOG_PAGE_SIZE;
        TurnPageTools<Article> pageTools = new TurnPageTools<>();
        PageInfoTools<Article> pageInfo = pageTools.getPageInfo(articleList, currentPage, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("articleCount", articleCount);

        //阅读排行榜相关数据
        Integer readNum = WebConstants.READ_TOP_SIZE <= articleCount ? WebConstants.READ_TOP_SIZE : articleCount;
        List<Map<Object, Object>> readTop = articleService.DescendingArticleByReadCount().subList(0, readNum);
        model.addAttribute("readTop", readTop);

        //最新文章相关数据
        Integer newNum = WebConstants.NEW_ARTICLE_SIZE <= articleCount ? WebConstants.NEW_ARTICLE_SIZE : articleCount;
        List<Map<Object, Object>> newTop = articleService.DescendingArticleByCreatedTime().subList(0, newNum);
        model.addAttribute("newTop", newTop);

        //分类列表相关数据
        Integer sortCount = sortService.querySortCount();
        Integer sortNum = WebConstants.SORT_TOP_SIZE <= sortCount ? WebConstants.SORT_TOP_SIZE : sortCount;
        List<Map<Object, Object>> sortMap = sortService.DescendingSort().subList(0, sortNum);
        model.addAttribute("sortMap", sortMap);

        //标签列表相关数据
        Integer tagsCount = tagsService.queryTagsCount();
        Integer tagsNum = WebConstants.TAGS_TOP_SIZE <= tagsCount ? WebConstants.TAGS_TOP_SIZE : tagsCount;
        List<Map<Object, Object>> tagsMap = tagsService.DescendingTags().subList(0, tagsNum);
        model.addAttribute("tagsMap", tagsMap);

        return "index";
    }

    @MyLogAnnotation("页面跳转")
    @RequestMapping("/blog")
    public String toBlogPage(@RequestParam("id") Integer id, Model model) {
        Article article = articleService.queryArticleById(id);
        //这里还要将 md 转换为 html，然后在返回给前端

        model.addAttribute("article", article);
        return "mainPage/blogContents";
    }
}