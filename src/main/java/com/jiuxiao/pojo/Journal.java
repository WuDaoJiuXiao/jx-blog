package com.jiuxiao.pojo;

import java.sql.Timestamp;

/**
 * 日志实体类
 * @Author: 悟道九霄
 * @Date: 2022年05月31日 18:25
 * @Version: 1.0.0
 */
public class Journal {

    /** 日志 ID */
    private Integer id;

    /** 操作名称 */
    private String operateName;

    /** 是否成功 */
    private String success;

    /** 请求者 IP */
    private String requestIp;

    /** 请求的类名 */
    private String requestClassName;

    /** 请求的方法名 */
    private String requestMethodName;

    /** 请求的URL */
    private String requestUrl;

    /** 日志产生时间 */
    private Timestamp createdTime;

    public Journal() {
    }

    public Journal(Integer id, String operateName, String success, String requestIp, String requestClassName,
                   String requestMethodName, String requestUrl, Timestamp createdTime) {
        this.id = id;
        this.operateName = operateName;
        this.success = success;
        this.requestIp = requestIp;
        this.requestClassName = requestClassName;
        this.requestMethodName = requestMethodName;
        this.requestUrl = requestUrl;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getRequestClassName() {
        return requestClassName;
    }

    public void setRequestClassName(String requestClassName) {
        this.requestClassName = requestClassName;
    }

    public String getRequestMethodName() {
        return requestMethodName;
    }

    public void setRequestMethodName(String requestMethodName) {
        this.requestMethodName = requestMethodName;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", operateName='" + operateName + '\'' +
                ", success='" + success + '\'' +
                ", requestIp='" + requestIp + '\'' +
                ", requestClassName='" + requestClassName + '\'' +
                ", requestMethodName='" + requestMethodName + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}