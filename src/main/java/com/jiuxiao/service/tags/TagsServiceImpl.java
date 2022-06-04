package com.jiuxiao.service.tags;

import com.jiuxiao.mapper.TagsMapper;
import com.jiuxiao.pojo.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 标签业务层实现类
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 15:12
 * @Version: 1.0.0
 */
@Service("TagsService")
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsMapper tagsMapper;

    /**
     * 查询所有的标签列表
     *
     * @return
     */
    @Override
    public List<Tags> queryAllTagsList() {
        return tagsMapper.queryAllTagsList();
    }

    /**
     * 通过 ID 查询标签
     *
     * @param id
     * @return
     */
    @Override
    public Tags queryTagsById(Integer id) {
        return tagsMapper.queryTagsById(id);
    }

    /**
     * 通过名称查询标签
     *
     * @param name
     * @return
     */
    @Override
    public List<Tags> queryTagsByName(String name) {
        return tagsMapper.queryTagsByName(name);
    }

    /**
     * 增加标签
     *
     * @param tags
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertTags(Tags tags) {
        return tagsMapper.insertTags(tags);
    }

    /**
     * 通过 ID 更新标签
     *
     * @param tags
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateTagsById(Tags tags) {
        return tagsMapper.updateTagsById(tags);
    }

    /**
     * 通过 ID 删除标签
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteTagsById(Integer id) {
        return tagsMapper.deleteTagsById(id);
    }

    /**
     * 查询标签表中的总数量
     *
     * @return
     */
    @Override
    public int queryTagsCount() {
        return tagsMapper.queryTagsCount();
    }

    /**
     * 重新设置数据库表主键自增
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int increaseTagsFromThis() {
        return tagsMapper.increaseTagsFromThis();
    }
}