package com.jiuxiao.pojo;

import java.sql.Timestamp;

/**
 * 评论实体类
 *
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:24
 * @Version: 1.0.0
 */
public class Comment {

    /**
     * 评论 ID
     */
    private Integer id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论发布时间
     */
    private Timestamp createdTime;

    /**
     * 评论者 ID
     */
    private Integer authorId;

    /**
     * 文章 ID
     */
    private String articleId;

    public Comment() {
    }

    public Comment(Integer id, String content, Timestamp createdTime, Integer authorId, String articleId) {
        this.id = id;
        this.content = content;
        this.createdTime = createdTime;
        this.authorId = authorId;
        this.articleId = articleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                ", authorId=" + authorId +
                ", articleId='" + articleId + '\'' +
                '}';
    }
}

