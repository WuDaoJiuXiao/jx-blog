package com.jiuxiao.service.admin.sort;

import com.jiuxiao.mapper.SortMapper;
import com.jiuxiao.pojo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 分类业务层接口实现类
 * @Author: 悟道九霄
 * @Date: 2022年06月02日 14:09
 * @Version: 1.0.0
 */
@Service("SortService")
public class SortServiceImpl implements SortService {

    @Autowired
    private SortMapper sortMapper;

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Sort>
     * @decription 查询所有分类列表
     * @date 2022/6/5 10:32
     */
    @Override
    public List<Sort> queryAllSortList() {
        return sortMapper.queryAllSortList();
    }

    /**
     * @param name
     * @return: java.util.List<com.jiuxiao.pojo.Sort>
     * @decription 通过名称查询分类
     * @date 2022/6/5 10:32
     */
    @Override
    public List<Sort> querySortByName(String name) {
        return sortMapper.querySortByName(name);
    }

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Sort
     * @decription 通过 id 查询分类
     * @date 2022/6/5 10:33
     */
    @Override
    public Sort querySortById(Integer id) {
        return sortMapper.querySortById(id);
    }

    /**
     * @param sort
     * @decription 增加分类
     * @date 2022/6/5 10:33
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSort(Sort sort) {
        sortMapper.insertSort(sort);
    }

    /**
     * @param sort
     * @decription 通过 id 更新分类
     * @date 2022/6/5 10:33
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSortById(Sort sort) {
        sortMapper.updateSortById(sort);
    }

    /**
     * @param id
     * @decription 通过 id 删除分类
     * @date 2022/6/5 10:33
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSortById(Integer id) {
        sortMapper.deleteSortById(id);
    }

    /**
     * @return: int
     * @decription 查询分类表中的总数量
     * @date 2022/6/5 10:33
     */
    @Override
    public int querySortCount() {
        return sortMapper.querySortCount();
    }

    /**
     * @decription 重新设置数据库表主键自增
     * @date 2022/6/5 10:33
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseSortFromThis() {
        sortMapper.increaseSortFromThis();
    }

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Sort>
     * @decription 将分类进行降序排列
     * @date 2022/6/9 10:12
     */
    @Override
    public List<Map<Object, Object>> DescendingSort() {
        return sortMapper.DescendingSort();
    }
}