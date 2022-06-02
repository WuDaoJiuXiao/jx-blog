package com.jiuxiao.pojo;

/**
 * 归档实体类
 *
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:23
 * @Version: 1.0.0
 */
public class Archive {

    /**
     * 归档 ID
     */
    private Integer id;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 上次修改时间
     */
    private String lastUpdateTime;

    /**
     * 归档文章的 ID
     */
    private Integer articleId;

    public Archive() {
    }

    public Archive(Integer id, String createdTime, String lastUpdateTime, Integer articleId) {
        this.id = id;
        this.createdTime = createdTime;
        this.lastUpdateTime = lastUpdateTime;
        this.articleId = articleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
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
        return "Archive{" +
                "id=" + id +
                ", createdTime='" + createdTime + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", articleId=" + articleId +
                '}';
    }
}