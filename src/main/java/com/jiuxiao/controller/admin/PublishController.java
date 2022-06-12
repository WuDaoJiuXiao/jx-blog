package com.jiuxiao.controller.admin;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.pojo.Archive;
import com.jiuxiao.pojo.Article;
import com.jiuxiao.pojo.Sort;
import com.jiuxiao.pojo.Tags;
import com.jiuxiao.service.archive.ArchiveService;
import com.jiuxiao.service.article.ArticleService;
import com.jiuxiao.service.sort.SortService;
import com.jiuxiao.service.tags.TagsService;
import com.jiuxiao.tools.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

/**
 * 博客发布控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月05日 17:46
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class PublishController {

    @Autowired
    private TagsService tagsService;

    @Autowired
    private SortService sortService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArchiveService archiveService;

    /**
     * @return: java.lang.String
     * @decription 跳转到博客发布页面
     * @date 2022/6/5 17:47
     */
    @MyLogAnnotation("跳转页面")
    @RequestMapping("/publish")
    public String toPublish(Model model) {
        setModelInfo(model);
        return "backend/control/publish";
    }

    /**
     * @param article
     * @return: java.lang.String
     * @decription 发布文章
     * @date 2022/6/8 21:14
     */
    @MyLogAnnotation("新增")
    @PostMapping("/publish")
    public String publish(Article article) {
        //新增文章
        Timestamp currentTime = TimeTools.getCurrentTime();
        Integer articleId = articleService.queryArticleCount() + 1;
        article.setId(articleId);
        article.setCreatedTime(currentTime);
        article.setLastUpdateTime(currentTime);
        article.setCommentCount(0);
        article.setReadCount(0);
        article.setAuthorName("悟道九霄");
        article.setCopyright("空");   //版权功能去除，默认显示版权信息

        //新增该新文章对应的归档
        Archive archive = new Archive();
        archive.setId(articleId);
        archive.setCreatedTime(currentTime);

        archiveService.insertArchive(archive);
        articleService.insertArticle(article);
        return "redirect:/admin/blog";
    }

    /**
     * @param model
     * @return: void
     * @decription 设置下拉框信息
     * @date 2022/6/7 22:27
     */
    @MyLogAnnotation("设置信息")
    private void setModelInfo(Model model) {
        List<Tags> tagsList = tagsService.queryAllTagsList();
        List<Sort> sortList = sortService.queryAllSortList();
        List<String> typeList = articleService.queryType();

        model.addAttribute("tagsList", tagsList);
        model.addAttribute("sortList", sortList);
        model.addAttribute("typeList", typeList);
    }
}