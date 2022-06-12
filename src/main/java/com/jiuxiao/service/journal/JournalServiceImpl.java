package com.jiuxiao.service.journal;

import com.jiuxiao.mapper.JournalMapper;
import com.jiuxiao.pojo.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 日志业务层接口实现类
 * @Author: 悟道九霄
 * @Date: 2022年06月05日 17:45
 * @Version: 1.0.0
 */
@Service("JournalService")
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalMapper journalMapper;

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Journal>
     * @decription 查询所有日志列表
     * @date 2022/6/6 10:07
     */
    @Override
    public List<Journal> queryAllJournalList() {
        return journalMapper.queryAllJournalList();
    }

    /**
     * @param journal
     * @return: java.util.List<com.jiuxiao.pojo.Journal>
     * @decription 多条件查询日志列表
     * @date 2022/6/6 10:08
     */
    @Override
    public List<Journal> queryJournalByUncertainCondition(Journal journal) {
        return journalMapper.queryJournalByUncertainCondition(journal);
    }

    /**
     * @param journal
     * @return: void
     * @decription 插入日志
     * @date 2022/6/6 11:29
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertJournal(Journal journal) {
        journalMapper.insertJournal(journal);
    }

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询操作名称的种类
     * @date 2022/6/6 11:30
     */
    @Override
    public List<String> queryOperateName() {
        return journalMapper.queryOperateName();
    }

    /**
     * @return: java.util.List<java.lang.Integer>
     * @decription 查询是否成功
     * @date 2022/6/6 15:03
     */
    @Override
    public List<String> querySuccess() {
        return journalMapper.querySuccess();
    }

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询请求者ip的种类
     * @date 2022/6/6 11:30
     */
    @Override
    public List<String> queryRequestIp() {
        return journalMapper.queryRequestIp();
    }

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询请求类名的种类
     * @date 2022/6/6 11:30
     */
    @Override
    public List<String> queryRequestClassName() {
        return journalMapper.queryRequestClassName();
    }

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询请求方法名的种类
     * @date 2022/6/6 11:31
     */
    @Override
    public List<String> queryRequestMethodName() {
        return journalMapper.queryRequestMethodName();
    }

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询请求url的种类
     * @date 2022/6/6 11:31
     */
    @Override
    public List<String> queryRequestUrl() {
        return journalMapper.queryRequestUrl();
    }

    /**
     * @return: java.lang.Integer
     * @decription 查询总的日志数量
     * @date 2022/6/7 11:21
     */
    @Override
    public Integer queryJournalCount() {
        return journalMapper.queryJournalCount();
    }

    /**
     * @param journal
     * @return: java.util.List<com.jiuxiao.pojo.Journal>
     * @decription 查询数据库中是否已经存在该记录
     * @date 2022/6/7 14:51
     */
    @Override
    public List<Journal> queryIfExist(Journal journal) {
        return journalMapper.queryIfExist(journal);
    }
}