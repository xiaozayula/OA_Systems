package com.xiaoyu.controller;

import com.xiaoyu.entity.Result;
import com.xiaoyu.entity.User;
import com.xiaoyu.entity.WorkContent;
import com.xiaoyu.service.UserService;
import com.xiaoyu.service.WorkContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/22/15:43
 * @Description:
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private UserService userService;
    @Autowired
    private WorkContentService workContentService;

    //通过部门id查询部门的员工
    @GetMapping("/{departmentId}/members")
    public Result<List<User>> getMemberByDepartmentId(Long departmentId){
        List<User> members = userService.getUserByDepartmentId(departmentId);
        if(members!=null&& !members.isEmpty()){
            return Result.success(members);
        }else {
            return Result.error("未找到该部门的成员信息");
        }
    }

    //查询部门下所有小组的工作内容
    @GetMapping("/{departmentId}/contents")
    public Result<List<WorkContent>> getDepartmentContents(@PathVariable Long departmentId){
        List<WorkContent> workContents=workContentService.getWorkContentsByDepartmentId(departmentId);
        if (workContents!=null&& !workContents.isEmpty()){
            return  Result.success(workContents);
        }else {
            return Result.error("未找到该部门的工作内容");
        }
    }
}
