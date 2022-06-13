package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:07
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface CommentMapper {

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Comment
     * @decription 根据 ID 查询评论
     * @date 2022/6/11 11:52
     */
    Comment queryCommentById(@Param("id") Integer id);

    /**
     * @param blogId
     * @return: java.util.List<com.jiuxiao.pojo.Comment>
     * @decription 根据博客 ID 查询评论列表
     * @date 2022/6/11 11:33
     */
    List<Comment> queryCommentByArticleId(@Param("blogId") Integer blogId);

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

    /**
     * @return: void
     * @decription 设置主键由此递增
     * @date 2022/6/13 13:12
     */
    void increaseCommentFromThis();

    /**
     * @param blogId
     * @return: void
     * @decription 根据文章 ID 删除该文章对应的评论
     * @date 2022/6/13 13:13
     */
    void deleteCommentByBlogId(@Param("blogId") Integer blogId);
}
