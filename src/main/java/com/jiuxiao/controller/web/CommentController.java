package com.jiuxiao.controller.web;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.constants.WebConstants;
import com.jiuxiao.pojo.Article;
import com.jiuxiao.pojo.Comment;
import com.jiuxiao.service.article.ArticleService;
import com.jiuxiao.service.comment.CommentService;
import com.jiuxiao.tools.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 评论控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月11日 11:11
 * @Version: 1.0.0
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    /**
     * @param comment
     * @param attributes
     * @return: java.lang.String
     * @decription 新增评论
     * @date 2022/6/11 20:51
     */
    @MyLogAnnotation("新增")
    @PostMapping("/comment")
    public String comment(Comment comment, RedirectAttributes attributes) {
        comment.setId(commentService.queryCommentCount() + 1);
        //用户头像统一
        comment.setAvatar(WebConstants.AVATAR);
        comment.setCreatedTime(TimeTools.getCurrentTime());
        commentService.insertComment(comment);

        Integer blogId = comment.getBlogId();
        //提交评论后，重定向到该文章，因此需要携带博客的 id 参数，这里使用 RedirectAttributes 完成
        attributes.addAttribute("id", blogId.toString());

        //每提交一次评论，该文章的评论数就应该加一
        Article article = articleService.queryArticleById(blogId);
        article.setCommentCount(article.getCommentCount() + 1);
        articleService.updateArticleById(article);

        return "redirect:/blog";
    }
}