package com.xiaoyu.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.xiaoyu.utils.SaltMD5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xiaoyu.entity.Result;
import com.xiaoyu.entity.User;
import com.xiaoyu.service.UserService;

import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/15/14:55
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    @PostMapping("/register")
    public Result register (@Pattern(regexp = "^\\S{3,16}$")String userName,//@Pattern 来验证这两个参数的格式
                            @Pattern(regexp = "^\\S{5,16}$") String passWord){// \S{5,16} 表示用户名和密码必须由 5 到 16 个非空白字符组成
        if (userName != null && userName.length() <= 16 && userName.length() >= 5 && passWord != null
                && passWord.length() <= 16 && passWord.length() >= 5) {
            // 查询用户
            User u = userService.findByUserName(userName);
            if (u == null) {
                // 没有占用
                // 注册
                userService.register(userName, passWord);
                return Result.success();
            } else {
                // 占用
                return Result.error("用户名已被占用");
            }
        } else {
            return Result.error("参数不合法");
        }
    }

    @PostMapping("/login")
    public SaResult login (@Pattern(regexp = "^\\S{3,16}$")String userName,
                           @Pattern(regexp = "^\\S{5,16}$") String passWord){
        User loginUser = userService.findByUserName(userName);
        if(loginUser==null){
            return SaResult.error("用户名不存在");
        }// 判断密码是否正确
        if (SaltMD5Util.generateSaltPassword(passWord).equals(loginUser.getPassword())){
            // StpUtil.login(id) 方法利用了 Cookie 自动注入的特性，保持登录状态，省略了你手写返回 token的代码。
            StpUtil.login(loginUser.getUserId());
            return SaResult.ok("登录成功");
        }
        return SaResult.error("密码错误");

    }
    // 根据用户名查询用户
    @GetMapping("/userInfo")
    public Result<User> useInfo( ) {
        // 获取当前登录用户的ID
        Long loginId = StpUtil.getLoginIdAsLong();
        User user = userService.selectUserById(loginId);
        return Result.success(user);
    }
    //查询自己所属部门
    @GetMapping("/{userId}/departmentName")
    public Result<String> getDepartmentNameByUserId(@PathVariable Long userId) {
        try {
            String departmentName = userService.getDepartmentNameByUserId(userId);
            return Result.success(departmentName);
        } catch (Exception e) {
            return Result.error("获取部门名称失败");
        }
    }
}
