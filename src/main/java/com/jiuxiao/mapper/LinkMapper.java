package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Link;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 友链Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:08
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface LinkMapper {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Link>
     * @decription 查询所有友链列表
     * @date 2022/6/5 10:03
     */
    List<Link> queryAllLinkList();
}
