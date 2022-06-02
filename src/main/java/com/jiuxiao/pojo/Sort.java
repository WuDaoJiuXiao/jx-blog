package com.jiuxiao.pojo;

import java.sql.Timestamp;

/**
 * 分类实体类
 *
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:26
 * @Version: 1.0.0
 */
public class Sort {

    /**
     * 分类 ID
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 被引用次数
     */
    private Integer refCount;

    /**
     * 创建时间
     */
    private Timestamp createdTime;

    /**
     * 上次修改时间
     */
    private Timestamp lastUpdateTime;

    public Sort() {
    }

    public Sort(Integer id, String name, Integer refCount, Timestamp createdTime, Timestamp lastUpdateTime) {
        this.id = id;
        this.name = name;
        this.refCount = refCount;
        this.createdTime = createdTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRefCount() {
        return refCount;
    }

    public void setRefCount(Integer refCount) {
        this.refCount = refCount;
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

    @Override
    public String toString() {
        return "Sort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", refCount=" + refCount +
                ", createdTime=" + createdTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}