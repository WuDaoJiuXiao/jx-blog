package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 友链Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:08
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface LinkMapper {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Link>
     * @decription 查询所有友链列表
     * @date 2022/6/5 10:03
     */
    List<Link> queryAllLinkList();

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Link
     * @decription 根据 ID 查询友链
     * @date 2022/6/5 10:54
     */
    Link queryLinkById(@Param("id") Integer id);

    /**
     * @param name
     * @return: java.util.List<com.jiuxiao.pojo.Link>
     * @decription 根据名称查询友链
     * @date 2022/6/5 10:54
     */
    List<Link> queryLinkByName(@Param("name") String name);

    /**
     * @param link
     * @return: void
     * @decription 增加友链
     * @date 2022/6/5 10:55
     */
    void insertLink(Link link);

    /**
     * @param link
     * @return: void
     * @decription 通过 ID 更新友链
     * @date 2022/6/5 10:57
     */
    void updateLink(Link link);

    /**
     * @param id
     * @return: void
     * @decription 通过 ID 删除友链
     * @date 2022/6/5 10:57
     */
    void deleteLinkById(@Param("id") Integer id);

    /**
     * @return: int
     * @decription 查询友链总数量
     * @date 2022/6/5 10:58
     */
    int queryLinkCount();

    /**
     * @return: void
     * @decription 设置主键由此自增
     * @date 2022/6/5 10:59
     */
    void increaseLinkFromThis();
}
