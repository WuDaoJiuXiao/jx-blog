package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Archive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 归档Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:06
 * @since: 1.0.0
 */
@Mapper
@Repository
public interface ArchiveMapper {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Archive>
     * @decription 查询所有的归档
     * @date 2022/6/12 17:10
     */
    List<Archive> queryAllArchive();

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Archive
     * @decription 根据 ID 查询归档
     * @date 2022/6/12 16:09
     */
    Archive queryArchiveById(@Param("id") Integer id);

    /**
     * @param year
     * @return: java.util.List<com.jiuxiao.pojo.Archive>
     * @decription 根据年份查询归档的id，并按照创建时间降序排列
     * @date 2022/6/12 16:10
     */
    List<Integer> queryArchiveByYear(@Param("year") String year);

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
    void deleteArchiveById(@Param("id") Integer id);

    /**
     * @return: void
     * @decription 设置主键由此自增
     * @date 2022/6/12 16:29
     */
    void increaseArchiveFromThis();
}
