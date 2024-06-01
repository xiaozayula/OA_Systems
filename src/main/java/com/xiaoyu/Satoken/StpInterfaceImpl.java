package com.xiaoyu.Satoken;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/26/18:20
 * @Description:
 */

import cn.dev33.satoken.stp.StpInterface;
import com.xiaoyu.entity.Permit;
import com.xiaoyu.entity.User;
import com.xiaoyu.mapper.UserMapper;
import com.xiaoyu.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 *
 * @author Ct
 */
@Slf4j
@Component
public class StpInterfaceImpl implements StpInterface {


    @Autowired
    UserService userService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        List<String> permissions = new ArrayList<>();
       //没有使用权限码来鉴权
        return permissions;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> roles = new ArrayList<>();

        try {
            Long userId = Long.parseLong(loginId.toString());
            User user = userService.selectUserById(userId);
            String roleName = user.getRoleName();
            if (user != null) {
                if ("超级管理员".equals(roleName)) {
                    roles.add("admin:super");
                } else if ("部门管理员".equals(roleName)) {
                    roles.add("admin:dept");
                } else if ("普通用户".equals(roleName)) {
                    roles.add("user:basic");
                }
            }
        } catch (NumberFormatException e) {
            log.error("Failed to parse loginId as a number", e);
        } catch (Exception e) {
            log.error("An unexpected error occurred", e);
        }
        return roles;
    }
}