package com.xiaoyu.service.impl;

import com.xiaoyu.entity.User;
import com.xiaoyu.mapper.UserMapper;
import com.xiaoyu.service.UserService;
import com.xiaoyu.utils.SaltMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/15/14:59
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String userName) {
        User u = userMapper.findByUserName(userName);
        return u;
    }

    @Override
    public User selectUserById(Long id) {

        return userMapper.selectUserById(id);
    }

    @Override
    public void register(String username, String password) {
        // 加密
        String md5String = SaltMD5Util.generateSaltPassword(password);
        // 添加
        userMapper.register(username, md5String);
    }

    @Override
    public String getDepartmentNameByUserId(Long userId) {

        return userMapper.getDepartmentNameByUserId(userId);
    }

    @Override
    public List<User> getUserByDepartmentId(Long departmentId) {
        return userMapper.selectUsersByDepartmentId(departmentId);
    }

    @Override
    public void updateUserDepartment(Long userId, Long departmentId) {
        User user = new User();
        user.setDepartmentId(departmentId);
        user.setUserId(userId);
        userMapper.updateUserDepartment(user);
    }

    @Override
    public Long getDepartmentIdByUserId(Long userId) {
        return userMapper.selectDepartmentIdByUserId(userId);
    }

}
