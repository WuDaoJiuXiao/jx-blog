package com.jiuxiao.service.tags;

import com.jiuxiao.pojo.Tags;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签业务层
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/04 15:12
 * @since: 1.0.0
 */
@Service
public interface TagsService {

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
    Tags queryTagsById(Integer id);

    /**
     * 通过名称查询标签
     * @param name
     * @return
     */
    List<Tags> queryTagsByName(String name);

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
    int deleteTagsById(Integer id);

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
