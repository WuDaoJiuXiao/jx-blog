package com.jiuxiao.service.admin.sort;

import com.jiuxiao.pojo.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 分类业务层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/02 14:09
 * @since: 1.0.0
 */
@Service
public interface SortService {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Sort>
     * @decription 查询所有分类列表
     * @date 2022/6/5 10:16
     */
    List<Sort> queryAllSortList();

    /**
     * @param name
     * @return: java.util.List<com.jiuxiao.pojo.Sort>
     * @decription 通过名称查询分类
     * @date 2022/6/5 10:16
     */
    List<Sort> querySortByName(String name);

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Sort
     * @decription 通过 id 查询分类
     * @date 2022/6/5 10:16
     */
    Sort querySortById(Integer id);

    /**
     * @param sort
     * @decription 增加分类
     * @date 2022/6/5 10:16
     */
    void insertSort(Sort sort);

    /**
     * @param sort
     * @decription 通过 id 更新分类
     * @date 2022/6/5 10:16
     */
    void updateSortById(Sort sort);

    /**
     * @param id
     * @decription 通过 id 删除分类
     * @date 2022/6/5 10:16
     */
    void deleteSortById(Integer id);

    /**
     * @return: int
     * @decription 查询分类表中的总数量
     * @date 2022/6/5 10:16
     */
    int querySortCount();

    /**
     * @decription 重新设置数据库表主键自增
     * @date 2022/6/5 10:16
     */
    void increaseSortFromThis();

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Sort>
     * @decription 将分类进行降序排列
     * @date 2022/6/9 10:07
     */
    List<Map<Object, Object>> DescendingSort();
}
