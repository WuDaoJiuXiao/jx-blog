package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标签Mapper层接口
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:09
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface TagsMapper {

    /**
     * 查询所有的标签列表
     *
     * @return
     */
    List<Tags> queryAllTagsList();

    /**
     * 通过 ID 查询标签
     * @param id
     * @return
     */
    Tags queryTagsById(@Param("id") Integer id);

    /**
     * 通过名称查询标签
     * @param name
     * @return
     */
    List<Tags> queryTagsByName(@Param("name") String name);

    /**
     * 增加标签
     * @param tags
     * @return
     */
    int insertTags(Tags tags);

    /**
     * 通过 ID 更新标签
     * @param tags
     * @return
     */
    int updateTagsById(Tags tags);

    /**
     * 通过 ID 删除标签
     * @param id
     * @return
     */
    int deleteTagsById(@Param("id") Integer id);

    /**
     * 查询标签表中的总数量
     *
     * @return
     */
    int queryTagsCount();

    /**
     * 重新设置数据库表主键自增
     *
     * @return
     */
    int increaseTagsFromThis();
}
