package com.jiuxiao.controller.admin;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.constants.BackendConstants;
import com.jiuxiao.pojo.Article;
import com.jiuxiao.pojo.Sort;
import com.jiuxiao.pojo.Tags;
import com.jiuxiao.service.archive.ArchiveService;
import com.jiuxiao.service.article.ArticleService;
import com.jiuxiao.service.sort.SortService;
import com.jiuxiao.service.tags.TagsService;
import com.jiuxiao.tools.PageInfoTools;
import com.jiuxiao.tools.TimeTools;
import com.jiuxiao.tools.TurnPageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * 文章管理控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月01日 14:40
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagsService tagsService;

    @Autowired
    private SortService sortService;

    @Autowired
    private ArchiveService archiveService;

    /**
     * @return: java.lang.String
     * @decription 文章管理页面
     * @date 2022/6/5 9:55
     */
    @MyLogAnnotation("查询")
    @RequestMapping("/blog")
    public String blog(@RequestParam(defaultValue = "1") Integer currentPage, Model model) {
        List<Article> articleList = articleService.queryAllArticleList();

        Integer articleCount = articleList.size();
        Integer pageSize = BackendConstants.BLOG_PAGE_SIZE;
        TurnPageTools<Article> pageTools = new TurnPageTools<>();
        PageInfoTools<Article> pageInfo = pageTools.getPageInfo(articleList, currentPage, pageSize);

        setAllModelInfo(model);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("articleCount", articleCount);
        return "backend/control/blogControl";
    }

    /**
     * @param title
     * @param tags
     * @param sort
     * @param type
     * @param article
     * @param model
     * @return: java.lang.String
     * @decription 未定条件查询文章
     * @date 2022/6/8 10:47
     */
    @MyLogAnnotation("查询")
    @PostMapping("/queryArticle")
    public String queryArticle(@RequestParam("title") String title,
                               @RequestParam("tags") String tags,
                               @RequestParam("sort") String sort,
                               @RequestParam("type") String type,
                               Article article, Model model) {
        //全部为空，就显示全部信息
        if ((title.equals("") || StringUtils.isEmpty(title))
                && (tags.equals("") || StringUtils.isEmpty(tags))
                && (sort.equals("") || StringUtils.isEmpty(sort))
                && (type.equals("") || StringUtils.isEmpty(type))) {
            return "redirect:/admin/blog";
        }

        setAllModelInfo(model);

        List<Article> articleList = articleService.queryArticleByUncertainCondition(title, tags, sort, type);
        model.addAttribute("articleList", articleList);
        return "backend/show/showArticleSearch";
    }

    /**
     * @param model
     * @return: void
     * @decription 设置下拉框信息
     * @date 2022/6/7 22:27
     */
    @MyLogAnnotation("设置信息")
    private void setAllModelInfo(Model model) {
        List<Tags> tagsList = tagsService.queryAllTagsList();
        List<Sort> sortList = sortService.queryAllSortList();
        List<String> typeList = articleService.queryType();

        model.addAttribute("tagsList", tagsList);
        model.addAttribute("sortList", sortList);
        model.addAttribute("typeList", typeList);
    }

    /**
     * @param id
     * @return: java.lang.String
     * @decription 删除文章(同时要删除该文章对应的归档)
     * @date 2022/6/8 10:46
     */
    @MyLogAnnotation("删除")
    @RequestMapping("/deleteArticle/{id}")
    public String delete(@PathVariable("id") Integer id) {
        //因为文章的 id 与归档 id 相一致，所以根据文章 id 直接删除归档记录即可
        archiveService.deleteArchiveById(id);
        archiveService.increaseArchiveFromThis();

        articleService.deleteArticleById(id);
        articleService.increaseArticleFromThis();
        return "redirect:/admin/blog";
    }

    /**
     * @param id
     * @param model
     * @return: java.lang.String
     * @decription 跳转到文章修改页面（博客发布页面）
     * @date 2022/6/8 11:31
     */
    @MyLogAnnotation("跳转页面")
    @RequestMapping("/updateArticle/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Article article = articleService.queryArticleById(id);
        setAllModelInfo(model);
        model.addAttribute("article", article);
        return "backend/update/updateArticle";
    }

    /**
     * @param article
     * @return: java.lang.String
     * @decription 修改文章
     * @date 2022/6/8 11:52
     */
    @MyLogAnnotation("更新")
    @PostMapping("/updateArticle")
    public String updateArticle(Article article) {
        //这里如果不设置，创建时间会被改变，改变为和更新时间一样，一个不知所云的 bug...
        article.setCreatedTime(articleService.queryArticleById(article.getId()).getCreatedTime());
        article.setLastUpdateTime(TimeTools.getCurrentTime());
        articleService.updateArticleById(article);
        return "redirect:/admin/blog";
    }
}