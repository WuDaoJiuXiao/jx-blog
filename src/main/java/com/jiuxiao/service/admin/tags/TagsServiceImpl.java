package com.jiuxiao.service.admin.tags;

import com.jiuxiao.mapper.TagsMapper;
import com.jiuxiao.pojo.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 标签业务层实现类
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 15:12
 * @Version: 1.0.0
 */
@Service("TagsService")
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsMapper tagsMapper;

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Tags>
     * @decription 查询所有的标签列表
     * @date 2022/6/5 10:36
     */
    @Override
    public List<Tags> queryAllTagsList() {
        return tagsMapper.queryAllTagsList();
    }

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Tags
     * @decription 通过 ID 查询标签
     * @date 2022/6/5 10:36
     */
    @Override
    public Tags queryTagsById(Integer id) {
        return tagsMapper.queryTagsById(id);
    }

    /**
     * @param name
     * @return: java.util.List<com.jiuxiao.pojo.Tags>
     * @decription 通过名称查询标签
     * @date 2022/6/5 10:36
     */
    @Override
    public List<Tags> queryTagsByName(String name) {
        return tagsMapper.queryTagsByName(name);
    }

    /**
     * @param tags
     * @return: void
     * @decription 增加标签
     * @date 2022/6/5 10:36
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTags(Tags tags) {
        tagsMapper.insertTags(tags);
    }

    /**
     * @param tags
     * @return: void
     * @decription 通过 ID 更新标签
     * @date 2022/6/5 10:36
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTagsById(Tags tags) {
        tagsMapper.updateTagsById(tags);
    }

    /**
     * @param id
     * @return: void
     * @decription 通过 ID 删除标签
     * @date 2022/6/5 10:36
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTagsById(Integer id) {
        tagsMapper.deleteTagsById(id);
    }

    /**
     * @return: int
     * @decription 查询标签表中的总数量
     * @date 2022/6/5 10:36
     */
    @Override
    public int queryTagsCount() {
        return tagsMapper.queryTagsCount();
    }

    /**
     * @return: void
     * @decription 重新设置数据库表主键自增
     * @date 2022/6/5 10:36
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseTagsFromThis() {
        tagsMapper.increaseTagsFromThis();
    }
}