package com.jiuxiao.service.user;

import com.jiuxiao.mapper.UserMapper;
import com.jiuxiao.pojo.User;
import com.jiuxiao.tools.MD5Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service层接口实现类
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月01日 9:29
 * @Version: 1.0.0
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名和密码获得用户
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, MD5Tools.getMD5(password));
    }

    /**
     * 获取所有用户的列表
     *
     * @return
     */
    @Override
    public List<User> getAllUserList() {
        return userMapper.getAllUserList();
    }
}