package com.xiaoyu.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.xiaoyu.entity.Result;
import com.xiaoyu.entity.WorkContent;
import com.xiaoyu.service.WorkContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/15:09
 * @Description:
 */

@RestController
@RequestMapping("/departments/")
public class WorkContentController {

    @Autowired
    private WorkContentService workContentService;



    //部门负责人来定当前的工作内容
    @PostMapping("{departmentId}/groups/{groupId}/contents")
    public Result<WorkContent> setWorkContent(@RequestBody WorkContent workContent) {
        WorkContent savedContent = workContentService.setWorkContent(workContent);
        return Result.success(savedContent);
    }
}