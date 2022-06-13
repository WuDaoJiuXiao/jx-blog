package com.jiuxiao.service.comment;

import com.jiuxiao.mapper.CommentMapper;
import com.jiuxiao.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 评论业务层接口实现类
 * @Author: 悟道九霄
 * @Date: 2022年06月11日 11:58
 * @Version: 1.0.0
 */
@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Comment
     * @decription 根据 ID 查询评论
     * @date 2022/6/11 12:03
     */
    @Override
    public Comment queryCommentById(Integer id) {
        return commentMapper.queryCommentById(id);
    }

    /**
     * @param blogId
     * @return: java.util.List<com.jiuxiao.pojo.Comment>
     * @decription 根据博客 ID 查询评论列表
     * @date 2022/6/11 12:03
     */
    @Override
    public List<Comment> queryCommentByArticleId(Integer blogId) {
        return commentMapper.queryCommentByArticleId(blogId);
    }

    /**
     * @return: java.lang.Integer
     * @decription 查询评论总数量
     * @date 2022/6/11 12:04
     */
    @Override
    public Integer queryCommentCount() {
        return commentMapper.queryCommentCount();
    }

    /**
     * @param comment
     * @return: void
     * @decription 新增评论
     * @date 2022/6/11 12:04
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    /**
     * @return: void
     * @decription 设置主键由此递增
     * @date 2022/6/13 13:17
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseCommentFromThis() {
        commentMapper.increaseCommentFromThis();
    }

    /**
     * @param blogId
     * @return: void
     * @decription 根据博客 ID 删除评论
     * @date 2022/6/13 13:18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCommentByBlogId(Integer blogId) {
        commentMapper.deleteCommentByBlogId(blogId);
    }
}