package com.xiaoyu.controller;

import com.xiaoyu.entity.Result;
import com.xiaoyu.entity.WorkContent;
import com.xiaoyu.entity.WorkProgressCommit;
import com.xiaoyu.service.WorkContentService;
import com.xiaoyu.service.WorkProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/15:33
 * @Description:
 */

@RestController
@RequestMapping("/groups")
public class WorkProgressController {

    @Autowired
    private WorkProgressService workProgressService;
    @Autowired
    private WorkContentService workContentService;

    @PostMapping
    public Result<WorkProgressCommit> updateWorkProgress(@PathVariable Long contentId,@RequestBody WorkProgressCommit commit) {

        // 检查工作是否已经结束
        if (workContentService.isWorkFinished(contentId)) {
            return Result.error("工作已结束，无法更新进度");
        }
        WorkProgressCommit savedCommit = workProgressService.updateWorkProgress(commit);
        return Result.success(savedCommit);
    }

}
