package com.jiuxiao.service.link;

import com.jiuxiao.mapper.LinkMapper;
import com.jiuxiao.pojo.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 友链业务层接口实现类
 * @Author: 悟道九霄
 * @Date: 2022年06月05日 10:43
 * @Version: 1.0.0
 */
@Service("LinkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Link>
     * @decription 查询所有友链列表
     * @date 2022/6/5 11:06
     */
    @Override
    public List<Link> queryAllLinkList() {
        return linkMapper.queryAllLinkList();
    }

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Link
     * @decription 根据 ID 查询友链
     * @date 2022/6/5 11:06
     */
    @Override
    public Link queryLinkById(Integer id) {
        return linkMapper.queryLinkById(id);
    }

    /**
     * @param name
     * @return: java.util.List<com.jiuxiao.pojo.Link>
     * @decription 根据名称查询友链
     * @date 2022/6/5 11:06
     */
    @Override
    public List<Link> queryLinkByName(String name) {
        return linkMapper.queryLinkByName(name);
    }

    /**
     * @param link
     * @return: void
     * @decription 增加友链
     * @date 2022/6/5 11:07
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertLink(Link link) {
        linkMapper.insertLink(link);
    }

    /**
     * @param link
     * @return: void
     * @decription 通过 ID 更新友链
     * @date 2022/6/5 11:07
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLink(Link link) {
        linkMapper.updateLink(link);
    }

    /**
     * @param id
     * @return: void
     * @decription 通过 ID 删除友链
     * @date 2022/6/5 11:07
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLinkById(Integer id) {
        linkMapper.deleteLinkById(id);
    }

    /**
     * @return: int
     * @decription 查询友链总数量
     * @date 2022/6/5 11:07
     */
    @Override
    public int queryLinkCount() {
        return linkMapper.queryLinkCount();
    }

    /**
     * @return: void
     * @decription 设置主键由此自增
     * @date 2022/6/5 11:07
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseLinkFromThis() {
        linkMapper.increaseLinkFromThis();
    }
}