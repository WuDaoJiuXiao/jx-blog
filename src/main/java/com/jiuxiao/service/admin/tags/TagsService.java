package com.jiuxiao.service.admin.tags;

import com.jiuxiao.pojo.Tags;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 标签业务层
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/04 15:12
 * @since: 1.0.0
 */
@Service
public interface TagsService {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Tags>
     * @decription 查询所有的标签列表
     * @date 2022/6/5 10:34
     */
    List<Tags> queryAllTagsList();

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Tags
     * @decription 通过 ID 查询标签
     * @date 2022/6/5 10:34
     */
    Tags queryTagsById(Integer id);

    /**
     * @param name
     * @return: java.util.List<com.jiuxiao.pojo.Tags>
     * @decription 通过名称查询标签
     * @date 2022/6/5 10:34
     */
    List<Tags> queryTagsByName(String name);

    /**
     * @param tags
     * @decription 增加标签
     * @date 2022/6/5 10:34
     */
    void insertTags(Tags tags);

    /**
     * @param tags
     * @decription 通过 ID 更新标签
     * @date 2022/6/5 10:34
     */
    void updateTagsById(Tags tags);

    /**
     * @param id
     * @decription 通过 ID 删除标签
     * @date 2022/6/5 10:34
     */
    void deleteTagsById(Integer id);

    /**
     * @return: int
     * @decription 查询标签表中的总数量
     * @date 2022/6/5 10:34
     */
    int queryTagsCount();

    /**
     * @decription 重新设置数据库表主键自增
     * @date 2022/6/5 10:34
     */
    void increaseTagsFromThis();

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Tags>
     * @decription 将标签进行降序排列
     * @date 2022/6/9 10:13
     */
    List<Map<Object, Object>> DescendingTags();
}
