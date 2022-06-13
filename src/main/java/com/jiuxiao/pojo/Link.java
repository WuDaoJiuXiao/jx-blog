package com.jiuxiao.pojo;

import java.sql.Timestamp;

/**
 * 友链实体类
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:25
 * @Version: 1.0.0
 */
public class Link {

    /** 友链 ID */
    private Integer id;

    /** 友链名称 */
    private String name;

    /** 友链地址 */
    private String address;

    /** 友链头像地址 */
    private String imageAddress;

    /** 创建时间 */
    private Timestamp createdTime;

    /** 上次修改时间 */
    private Timestamp lastUpdateTime;

    /** 是否通过审核 */
    private String isCheck;

    public Link() {
    }

    public Link(Integer id, String name, String address, String imageAddress,
                Timestamp createdTime, Timestamp lastUpdateTime, String isCheck) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.imageAddress = imageAddress;
        this.createdTime = createdTime;
        this.lastUpdateTime = lastUpdateTime;
        this.isCheck = isCheck;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
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

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", imageAddress='" + imageAddress + '\'' +
                ", createdTime=" + createdTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", isCheck='" + isCheck + '\'' +
                '}';
    }
}