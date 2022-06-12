package com.jiuxiao.service.archive;

import com.jiuxiao.mapper.ArchiveMapper;
import com.jiuxiao.pojo.Archive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 归档业务层接口实现类
 * @Author: 悟道九霄
 * @Date: 2022年06月12日 15:49
 * @Version: 1.0.0
 */
@Service("ArchiveService")
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private ArchiveMapper archiveMapper;

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Archive>
     * @decription 查询所有归档
     * @date 2022/6/12 17:13
     */
    @Override
    public List<Archive> queryAllArchive() {
        return archiveMapper.queryAllArchive();
    }

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Archive
     * @decription 根基 ID 查询归档
     * @date 2022/6/12 16:16
     */
    @Override
    public Archive queryArchiveById(Integer id) {
        return archiveMapper.queryArchiveById(id);
    }

    /**
     * @param year
     * @return: java.util.List<com.jiuxiao.pojo.Archive>
     * @decription 根据年份查询归档的id，并按照创建时间降序排列
     * @date 2022/6/12 16:17
     */
    @Override
    public List<Integer> queryArchiveByYear(String year) {
        return archiveMapper.queryArchiveByYear(year);
    }

    /**
     * @param archive
     * @return: void
     * @decription 新增归档
     * @date 2022/6/12 16:17
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertArchive(Archive archive) {
        archiveMapper.insertArchive(archive);
    }

    /**
     * @param id
     * @return: void
     * @decription 通过 ID 删除归档
     * @date 2022/6/12 16:23
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteArchiveById(Integer id) {
        archiveMapper.deleteArchiveById(id);
    }

    /**
     * @return: void
     * @decription 设置主键由此自增
     * @date 2022/6/12 16:29
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseArchiveFromThis() {
        archiveMapper.increaseArchiveFromThis();
    }
}