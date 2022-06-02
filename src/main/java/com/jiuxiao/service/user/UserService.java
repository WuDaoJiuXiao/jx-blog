package com.jiuxiao.service.user;

import com.jiuxiao.pojo.User;
import org.springframework.stereotype.Service;

/**
 * 用户Service层接口
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:29
 * @since: 1.0.0
 */
@Service
public interface UserService {

    /**
     * 根据用户名和密码获得用户
     *
     * @param username
     * @param password
     * @return
     */
    User getUserByUsernameAndPassword(String username, String password);
}
