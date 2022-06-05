package com.jiuxiao.pojo;

import java.sql.Timestamp;

/**
 * 文章实体类
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:24
 * @Version: 1.0.0
 */
public class Article {

    /** 文章 ID */
    private Integer id;

    /** 文章标题 */
    private String title;

    /** 文章首图地址 */
    private String headImageAddress;

    /** 文章内容 */
    private String content;

    /** 文章发布时间 */
    private Timestamp createdTime;

    /** 文章上次修改时间 */
    private Timestamp lastUpdateTime;

    /** 文章评论数量 */
    private Integer commentCount;

    /** 文章浏览量 */
    private Integer readCount;

    /** 文章作者名 */
    private String authorName;

    /** 文章下方版权信息 */
    private String copyright;

    /** 文章标签名 */
    private String tags;

    /** 文章分类名 */
    private String sort;

    /** 是否打开文章下方的评论 */
    private boolean openComment;

    /** 是否打开文章下方的版权信息 */
    private boolean openCopyright;

    /** 文章类型 */
    private String type;

    /** 文章作者的 ID */
    private Integer authorId;

    /** 文章分类的 ID */
    private Integer sortId;

    /** 文章标签的 ID */
    private Integer tagsId;

    /** 文章对应的归档 ID */
    private Integer archiveId;

    public Article() {
    }

    public Article(Integer id, String title, String headImageAddress, String content, Timestamp createdTime,
                   Timestamp lastUpdateTime, Integer commentCount, Integer readCount, String authorName,
                   String copyright, String tags, String sort, boolean openComment, boolean openCopyright,
                   String type, Integer authorId, Integer sortId, Integer tagsId, Integer archiveId) {
        this.id = id;
        this.title = title;
        this.headImageAddress = headImageAddress;
        this.content = content;
        this.createdTime = createdTime;
        this.lastUpdateTime = lastUpdateTime;
        this.commentCount = commentCount;
        this.readCount = readCount;
        this.authorName = authorName;
        this.copyright = copyright;
        this.tags = tags;
        this.sort = sort;
        this.openComment = openComment;
        this.openCopyright = openCopyright;
        this.type = type;
        this.authorId = authorId;
        this.sortId = sortId;
        this.tagsId = tagsId;
        this.archiveId = archiveId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadImageAddress() {
        return headImageAddress;
    }

    public void setHeadImageAddress(String headImageAddress) {
        this.headImageAddress = headImageAddress;
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

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isOpenComment() {
        return openComment;
    }

    public void setOpenComment(boolean openComment) {
        this.openComment = openComment;
    }

    public boolean isOpenCopyright() {
        return openCopyright;
    }

    public void setOpenCopyright(boolean openCopyright) {
        this.openCopyright = openCopyright;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getTagsId() {
        return tagsId;
    }

    public void setTagsId(Integer tagsId) {
        this.tagsId = tagsId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", headImageAddress='" + headImageAddress + '\'' +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", commentCount=" + commentCount +
                ", readCount=" + readCount +
                ", authorName='" + authorName + '\'' +
                ", copyright='" + copyright + '\'' +
                ", tags='" + tags + '\'' +
                ", sort='" + sort + '\'' +
                ", openComment=" + openComment +
                ", openCopyright=" + openCopyright +
                ", type='" + type + '\'' +
                ", authorId=" + authorId +
                ", sortId=" + sortId +
                ", tagsId=" + tagsId +
                ", archiveId=" + archiveId +
                '}';
    }
}