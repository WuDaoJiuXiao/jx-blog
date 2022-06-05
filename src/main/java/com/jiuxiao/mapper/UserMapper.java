package com.jiuxiao.mapper;

import com.jiuxiao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:10
 * @since: 1.0.0
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * @param username
     * @param password
     * @return: com.jiuxiao.pojo.User
     * @decription 根据用户名和密码获得用户
     * @date 2022/6/5 10:06
     */
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * @return: java.util.List<com.jiuxiao.pojo.User>
     * @decription 获取所有用户的列表
     * @date 2022/6/5 10:06
     */
    List<User> getAllUserList();
}