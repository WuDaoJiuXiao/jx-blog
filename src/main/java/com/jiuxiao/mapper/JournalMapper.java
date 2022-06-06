package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Journal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 日志Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:08
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface JournalMapper {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Journal>
     * @decription 查询所有日志列表
     * @date 2022/6/6 9:03
     */
    List<Journal> queryAllJournalList();

    /**
     * @param journal
     * @return: java.util.List<com.jiuxiao.pojo.Journal>
     * @decription 多条件查询日志列表
     * @date 2022/6/6 9:06
     */
    List<Journal> queryJournalByUncertainCondition(Journal journal);

    /**
     * @param journal
     * @return: void
     * @decription 插入日志
     * @date 2022/6/6 10:51
     */
    void insertJournal(Journal journal);

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询操作名称的种类
     * @date 2022/6/6 11:25
     */
    List<String> queryOperateName();

    /**
     * @return: java.util.List<java.lang.Integer>
     * @decription 查询是否成功
     * @date 2022/6/6 15:02
     */
    List<String> querySuccess();

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询请求者ip的种类
     * @date 2022/6/6 11:27
     */
    List<String> queryRequestIp();

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询请求的类名的种类
     * @date 2022/6/6 11:27
     */
    List<String> queryRequestClassName();

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询请求的方法名的种类
     * @date 2022/6/6 11:27
     */
    List<String> queryRequestMethodName();

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询请求地址的种类
     * @date 2022/6/6 11:28
     */
    List<String> queryRequestUrl();
}
