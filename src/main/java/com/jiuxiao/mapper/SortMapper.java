package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 分类Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:09
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface SortMapper {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Sort>
     * @decription 查询所有分类列表
     * @date 2022/6/5 10:03
     */
    List<Sort> queryAllSortList();

    /**
     * @param name
     * @return: java.util.List<com.jiuxiao.pojo.Sort>
     * @decription 通过名称查询分类
     * @date 2022/6/5 10:03
     */
    List<Sort> querySortByName(@Param("name") String name);

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Sort
     * @decription 通过 id 查询分类
     * @date 2022/6/5 10:03
     */
    Sort querySortById(@Param("id") Integer id);

    /**
     * @param sort
     * @return: int
     * @decription 增加分类
     * @date 2022/6/5 10:03
     */
    int insertSort(Sort sort);

    /**
     * @param sort
     * @return: int
     * @decription 通过 id 更新分类
     * @date 2022/6/5 10:04
     */
    int updateSortById(Sort sort);

    /**
     * @param id
     * @return: int
     * @decription 通过 id 删除分类
     * @date 2022/6/5 10:04
     */
    int deleteSortById(@Param("id") Integer id);

    /**
     * @return: int
     * @decription 查询分类表中的总数量
     * @date 2022/6/5 10:04
     */
    int querySortCount();

    /**
     * @return: int
     * @decription 重新设置数据库表主键自增
     * @date 2022/6/5 10:04
     */
    int increaseSortFromThis();
}
