package com.xiaoyu.service;

import com.xiaoyu.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/15/14:59
 * @Description:
 */
public interface UserService {
    // 根据用户名查询用户
    User findByUserName(String userName);
    //根据id查询用户
    User selectUserById(Long id);

    // 注册
    void register(String userName, String passWord);

    //根据用户id查询所属部门
    String getDepartmentNameByUserId(Long userId);

    //通过部门ID查询该部门中的所有成员
    List<User> getUserByDepartmentId (Long departmentId);
    //更新用户的部门信息
    void updateUserDepartment(Long userId, Long departmentId);

    Long getDepartmentIdByUserId(Long userId);


}
