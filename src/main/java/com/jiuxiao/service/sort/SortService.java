package com.jiuxiao.service.sort;

import com.jiuxiao.pojo.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类业务层接口
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/02 14:09
 * @since: 1.0.0
 */
@Service
public interface SortService {

    /**
     * 查询所有分类列表
     *
     * @return
     */
    List<Sort> queryAllSortList();

    /**
     * 通过名称查询分类
     *
     * @param name
     * @return
     */
    List<Sort> querySortByName(String name);

    /**
     * 通过 id 查询分类
     *
     * @param id
     * @return
     */
    Sort querySortById(Integer id);

    /**
     * 增加分类
     *
     * @return
     */
    int insertSort(Sort sort);

    /**
     * 通过 id 更新分类
     *
     * @param sort
     * @return
     */
    int updateSortById(Sort sort);

    /**
     * 通过 id 删除分类
     *
     * @param id
     * @return
     */
    int deleteSortById(Integer id);

    /**
     * 查询分类表中的总数量
     *
     * @return
     */
    int querySortCount();

    /**
     * 重新设置数据库表主键自增
     *
     * @return
     */
    int increaseSortFromThis();
}
