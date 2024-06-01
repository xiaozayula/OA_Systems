package com.xiaoyu.service.impl;

import com.xiaoyu.entity.WorkContent;
import com.xiaoyu.mapper.WorkContentMapper;
import com.xiaoyu.service.WorkContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/23/13:24
 * @Description:DepartmentController
 */
@Service
public class WorkContentServiceImpl implements WorkContentService {
    @Autowired
    private WorkContentMapper workContentMapper;
    @Override
    public List<WorkContent> getWorkContentsByDepartmentId(Long departmentId) {
        return workContentMapper.selectWorkContentsByDepartmentId(departmentId);
    }

    @Override
    public WorkContent setWorkContent(WorkContent workContent) {
        workContentMapper.insert(workContent);
        return workContent;
    }

    @Override
    public WorkContent getWorkContentsByCommitId(Long contentId) {
        return workContentMapper.selectWorkContentsBycontentId(contentId);
    }

    @Override
    public boolean isWorkFinished(Long contentId) {
        WorkContent workContent = getWorkContentsByCommitId(contentId);
        return workContent != null && workContent.isFinished();
    }
}
