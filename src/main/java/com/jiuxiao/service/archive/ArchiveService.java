package com.jiuxiao.service.archive;

import com.jiuxiao.pojo.Archive;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 归档业务层接口
 * @Author: 悟道九霄
 * @Date: 2022/06/12 15:49
 * @Version: 1.0.0
 */
@Service
public interface ArchiveService {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Archive>
     * @decription 查询所有的归档
     * @date 2022/6/12 17:12
     */
    List<Archive> queryAllArchive();

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Archive
     * @decription 根据 ID 查询归档
     * @date 2022/6/12 16:09
     */
    Archive queryArchiveById(Integer id);

    /**
     * @param year
     * @return: java.util.List<com.jiuxiao.pojo.Archive>
     * @decription 根据年份查询归档的id，并按照创建时间降序排列
     * @date 2022/6/12 16:10
     */
    List<Integer> queryArchiveByYear(String year);

    /**
     * @param archive
     * @return: void
     * @decription 新增归档
     * @date 2022/6/12 16:10
     */
    void insertArchive(Archive archive);

    /**
     * @param id
     * @return: void
     * @decription 通过 ID 删除归档
     * @date 2022/6/12 16:19
     */
    void deleteArchiveById(Integer id);

    /**
     * @return: void
     * @decription 设置主键由此自增
     * @date 2022/6/12 16:29
     */
    void increaseArchiveFromThis();
}
