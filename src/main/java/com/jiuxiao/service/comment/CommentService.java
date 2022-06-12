package com.jiuxiao.service.comment;

import com.jiuxiao.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论业务层接口
 * @Author: 悟道九霄
 * @Date: 2022/06/11 11:57
 * @Version: 1.0.0
 */
@Service
public interface CommentService {

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Comment
     * @decription 根据 ID 查询评论
     * @date 2022/6/11 11:52
     */
    Comment queryCommentById(Integer id);

    /**
     * @param blogId
     * @return: java.util.List<com.jiuxiao.pojo.Comment>
     * @decription 根据博客 ID 查询评论列表
     * @date 2022/6/11 11:33
     */
    List<Comment> queryCommentByArticleId(Integer blogId);

    /**
     * @return: java.lang.Integer
     * @decription 查询评论的总数量
     * @date 2022/6/11 11:51
     */
    Integer queryCommentCount();

    /**
     * @param comment
     * @return: void
     * @decription 新增评论
     * @date 2022/6/11 11:53
     */
    void insertComment(Comment comment);
}
