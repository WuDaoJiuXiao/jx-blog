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
     * 归档年份
     */
    private String year;

    /**
     * 归档文章的 ID
     */
    private Integer articleId;

    public Archive() {
    }

    public Archive(Integer id, String year, Integer articleId) {
        this.id = id;
        this.year = year;
        this.articleId = articleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
                ", year='" + year + '\'' +
                ", articleId=" + articleId +
                '}';
    }
}