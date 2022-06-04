package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 分类Mapper层接口
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:09
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface SortMapper {

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
    List<Sort> querySortByName(@Param("name") String name);

    /**
     * 通过 id 查询分类
     *
     * @param id
     * @return
     */
    Sort querySortById(@Param("id") Integer id);

    /**
     * 增加分类
     */
    int insertSort(Sort sort);

    /**
     * 通过 id 更新分类
     *
     * @param sort
     */
    int updateSortById(Sort sort);

    /**
     * 通过 id 删除分类
     *
     * @param id
     */
    int deleteSortById(@Param("id") Integer id);

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
