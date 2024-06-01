package com.xiaoyu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/13/16:30
 * @Description: 用户表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    private  Long userId;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    // 让springmvc把当前对象转换成json字符串的时候忽略password，最终的json字符串中就没有password
    @JsonIgnore
    @NotBlank(message = "密码不能为空")
    private  String  password;
    private  String  roleName;//普通用户 部门管理员 超级管理员
    private Long departmentId;

}
