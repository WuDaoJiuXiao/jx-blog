package com.jiuxiao.service.user;

import com.jiuxiao.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:29
 * @since: 1.0.0
 */
@Service
public interface UserService {

    /**
     * @param username
     * @param password
     * @return: com.jiuxiao.pojo.User
     * @decription 根据用户名和密码获得用户
     * @date 2022/6/5 10:37
     */
    User getUserByUsernameAndPassword(String username, String password);

    /**
     * @return: java.util.List<com.jiuxiao.pojo.User>
     * @decription 获取所有用户的列表
     * @date 2022/6/5 10:37
     */
    List<User> getAllUserList();
}
