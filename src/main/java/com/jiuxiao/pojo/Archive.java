package com.jiuxiao.pojo;

import java.sql.Timestamp;

/**
 * 归档实体类
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:23
 * @Version: 1.0.0
 */
public class Archive {

    /** 归档 ID */
    private Integer id;

    /** 创建时间 */
    private Timestamp createdTime;

    public Archive() {
    }

    public Archive(Integer id, Timestamp createdTime) {
        this.id = id;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Archive{" +
                "id=" + id +
                ", createdTime=" + createdTime +
                '}';
    }
}