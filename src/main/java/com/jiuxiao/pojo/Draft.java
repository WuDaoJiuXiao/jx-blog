package com.jiuxiao.pojo;

import java.sql.Timestamp;

/**
 * 草稿实体类
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:25
 * @Version: 1.0.0
 */
public class Draft {

    /** 草稿 ID */
    private Integer id;

    /** 是否删除 */
    private boolean deleted;

    /** 上次修改时间 */
    private Timestamp lastUpdateTime;

    /** 文章 ID */
    private Integer articleId;

    public Draft() {
    }

    public Draft(Integer id, boolean deleted, Timestamp lastUpdateTime, Integer articleId) {
        this.id = id;
        this.deleted = deleted;
        this.lastUpdateTime = lastUpdateTime;
        this.articleId = articleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Draft{" +
                "id=" + id +
                ", deleted=" + deleted +
                ", lastUpdateTime=" + lastUpdateTime +
                ", articleId=" + articleId +
                '}';
    }
}