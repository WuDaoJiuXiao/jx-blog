package com.jiuxiao.pojo;

import java.sql.Timestamp;

/**
 * 评论实体类
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:24
 * @Version: 1.0.0
 */
public class Comment {

    /** 评论 ID */
    private Integer id;

    /** 评论者昵称 */
    private String nickname;

    /** 评论者邮箱 */
    private String email;

    /** 评论者头像地址 */
    private String avatar;

    /** 评论内容 */
    private String content;

    /** 评论发布时间 */
    private Timestamp createdTime;

    /** 评论所属的文章id */
    private Integer blogId;

    /** 评论的父id */
    private Integer parentCommentId;

    /** 父评论 */
    private Comment parentComment;

    public Comment() {
    }

    public Comment(Integer id, String nickname, String email, String avatar, String content,
                   Timestamp createdTime, Integer blogId, Integer parentCommentId, Comment parentComment) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.avatar = avatar;
        this.content = content;
        this.createdTime = createdTime;
        this.blogId = blogId;
        this.parentCommentId = parentCommentId;
        this.parentComment = parentComment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                ", blogId=" + blogId +
                ", parentCommentId=" + parentCommentId +
                ", parentComment=" + parentComment +
                '}';
    }
}

