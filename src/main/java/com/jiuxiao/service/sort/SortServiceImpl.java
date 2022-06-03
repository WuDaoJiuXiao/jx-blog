package com.jiuxiao.service.sort;

import com.jiuxiao.mapper.SortMapper;
import com.jiuxiao.pojo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 分类业务层接口实现类
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月02日 14:09
 * @Version: 1.0.0
 */
@Service("SortService")
public class SortServiceImpl implements SortService {

    @Autowired
    private SortMapper sortMapper;

    /**
     * 查询所有分类列表
     *
     * @return
     */
    @Override
    public List<Sort> queryAllSortList() {
        return sortMapper.queryAllSortList();
    }

    /**
     * 通过名称查询分类
     *
     * @param name
     * @return
     */
    @Override
    public Sort querySortByName(String name) {
        return sortMapper.querySortByName(name);
    }

    /**
     * 通过 id 查询分类
     *
     * @param id
     * @return
     */
    @Override
    public Sort querySortById(Integer id) {
        return sortMapper.querySortById(id);
    }

    /**
     * 增加分类
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSort(Sort sort) {
        return sortMapper.insertSort(sort);
    }

    /**
     * 通过 id 更新分类
     *
     * @param sort
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSortById(Sort sort) {
        return sortMapper.updateSortById(sort);
    }

    /**
     * 通过 id 删除分类
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteSortById(Integer id) {
        return sortMapper.deleteSortById(id);
    }

    /**
     * 查询分类表中的总数量
     *
     * @return
     */
    @Override
    public int queryMaxCount() {
        return sortMapper.queryMaxCount();
    }

    /**
     * 重新设置数据库表主键自增
     *
     * @return
     */
    @Override
    public int increaseFromThis() {
        return sortMapper.increaseFromThis();
    }
}