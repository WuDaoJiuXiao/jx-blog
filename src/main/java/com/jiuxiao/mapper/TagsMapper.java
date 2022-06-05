package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标签Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:09
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface TagsMapper {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Tags>
     * @decription 查询所有的标签列表
     * @date 2022/6/5 10:04
     */
    List<Tags> queryAllTagsList();

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Tags
     * @decription 通过 ID 查询标签
     * @date 2022/6/5 10:05
     */
    Tags queryTagsById(@Param("id") Integer id);

    /**
     * @param name
     * @return: java.util.List<com.jiuxiao.pojo.Tags>
     * @decription 通过名称查询标签
     * @date 2022/6/5 10:05
     */
    List<Tags> queryTagsByName(@Param("name") String name);

    /**
     * @param tags
     * @decription 增加标签
     * @date 2022/6/5 10:05
     */
    void insertTags(Tags tags);

    /**
     * @param tags
     * @decription 通过 ID 更新标签
     * @date 2022/6/5 10:05
     */
    void updateTagsById(Tags tags);

    /**
     * @param id
     * @decription 通过 ID 删除标签
     * @date 2022/6/5 10:05
     */
    void deleteTagsById(@Param("id") Integer id);

    /**
     * @return: int
     * @decription 查询标签表中的总数量
     * @date 2022/6/5 10:05
     */
    int queryTagsCount();

    /**
     * @decription 重新设置数据库表主键自增
     * @date 2022/6/5 10:05
     */
    void increaseTagsFromThis();
}
