package com.jiuxiao.mapper;

import com.jiuxiao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户Mapper层接口
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:10
 * @since: 1.0.0
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 根据用户名和密码获得用户
     *
     * @return
     */
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}