package com.jiuxiao.mapper;

import com.jiuxiao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 获取所有用户的列表
     *
     * @return
     */
    List<User> getAllUserList();
}