package com.xiaoyu.service;

import com.xiaoyu.entity.WorkContent;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/23/13:23
 * @Description:
 */
public interface WorkContentService {
    //查询部门下工作内容
    List<WorkContent> getWorkContentsByDepartmentId(Long departmentId);

    WorkContent setWorkContent(WorkContent workContent);
    WorkContent getWorkContentsByCommitId(Long contentId);
    boolean isWorkFinished(Long contentId);
}
