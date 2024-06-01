package com.xiaoyu.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.xiaoyu.entity.Result;
import com.xiaoyu.entity.WorkGroup;
import com.xiaoyu.service.WorkGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/14:35
 * @Description:
 */
@RestController
@RequestMapping("/workgroups")
public class WorkGroupController {

    @Autowired
    private WorkGroupService workGroupService;
    @PostMapping("/createWorkGroup")
    public Result<WorkGroup> createWorkGroup(@RequestBody WorkGroup workGroup) {
        try {
            WorkGroup createdWorkGroup = workGroupService.createWorkGroup(workGroup);
            return Result.success(createdWorkGroup);
        } catch (Exception e) {
            // 在这里可以根据实际情况定制错误消息
            return Result.error("创建工作小组失败，请重试");
        }
    }
}
