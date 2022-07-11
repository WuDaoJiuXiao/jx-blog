package com.jiuxiao.controller.web;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.constants.WebConstants;
import com.jiuxiao.pojo.Article;
import com.jiuxiao.pojo.Comment;
import com.jiuxiao.service.article.ArticleService;
import com.jiuxiao.service.comment.CommentService;
import com.jiuxiao.service.sort.SortService;
import com.jiuxiao.service.tags.TagsService;
import com.jiuxiao.tools.MarkdownToHtmlTools;
import com.jiuxiao.tools.PageInfoTools;
import com.jiuxiao.tools.TurnPageTools;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
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

    @Autowired
    private CommentService commentService;

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
        Integer sortCount = sortService.DescendingSort().size();
        Integer sortNum = WebConstants.SORT_TOP_SIZE <= sortCount ? WebConstants.SORT_TOP_SIZE : sortCount;
        List<Map<Object, Object>> sortMap = sortService.DescendingSort().subList(0, sortNum);
        model.addAttribute("sortMap", sortMap);

        //标签列表相关数据
        Integer tagsCount = tagsService.DescendingTags().size();
        Integer tagsNum = WebConstants.TAGS_TOP_SIZE <= tagsCount ? WebConstants.TAGS_TOP_SIZE : tagsCount;
        List<Map<Object, Object>> tagsMap = tagsService.DescendingTags().subList(0, tagsNum);
        model.addAttribute("tagsMap", tagsMap);

        return "index";
    }

    /**
     * @param id
     * @param model
     * @return: java.lang.String
     * @decription 跳转到博客正文页面
     * @date 2022/6/9 20:43
     */
    @MyLogAnnotation("页面跳转")
    @RequestMapping("/blog")
    public String toBlogPage(@RequestParam("id") Integer id, Model model) {
        Integer articleCount = articleService.queryArticleCount();
        //若传回的文章 id 不存在，则返回 404 页面
        if (id < 1 || id > articleCount){
            return "error/404";
        }

        Article article = articleService.queryArticleById(id);
        List<Comment> commentList = commentService.queryCommentByArticleId(id);
        Map<Integer, Comment> parentMap = new HashMap<>(commentList.size());

        //文章 id 正确的情况下，每访问一次该文章，该文章的阅读量就加一
        article.setReadCount(article.getReadCount() + 1);
        articleService.updateArticleById(article);

        //为每个评论查询出它的父评论，若为 -1 则父评论为 Null 对象
        for (Comment comment : commentList) {
            Integer commentId = comment.getId();
            if (comment.getParentCommentId() != -1){
                Integer parentId = comment.getParentCommentId();
                Comment parentComment = commentService.queryCommentById(parentId);
                parentMap.put(commentId, parentComment);
            }else{
                parentMap.put(commentId, null);
            }
        }

        //这里要将 md 转换为 html，然后在返回给前端
        Article oldArticle = articleService.queryArticleById(id);

        //这里需要复制一份文章返回给前端，不然数据库中的 content 会被改变为 html 格式
        Article newArticle = new Article();
        BeanUtils.copyProperties(oldArticle, newArticle);
        String content = newArticle.getContent();
        newArticle.setContent(MarkdownToHtmlTools.markdownToHtmlExtensions(content));

        model.addAttribute("article", newArticle);
        model.addAttribute("commentList", commentList);
        model.addAttribute("parentMap", parentMap);
        return "mainPage/blogContents";
    }

    /**
     * @param queryText
     * @param model
     * @return: java.lang.String
     * @decription 搜索框查询结果跳转
     * @date 2022/6/9 21:29
     */
    @MyLogAnnotation("跳转页面")
    @PostMapping("/search")
    public String queryText(@RequestParam("queryText") String queryText, Model model) {
        List<Map<Object, Object>> mapList = articleService.searchText(queryText);
        if (mapList.size() == 0) {
            return "mainPage/noSearchRes";
        }

        model.addAttribute("mapList", mapList);
        return "mainPage/search";
    }
}