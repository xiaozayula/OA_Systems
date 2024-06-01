package com.xiaoyu.service.impl;

import com.xiaoyu.entity.WorkContent;
import com.xiaoyu.entity.WorkProgressCommit;
import com.xiaoyu.mapper.WorkProgressMapper;
import com.xiaoyu.service.WorkContentService;
import com.xiaoyu.service.WorkProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/15:36
 * @Description:
 */
@Service
public class WorkProgressServiceImpl implements WorkProgressService {

    @Autowired
    private WorkProgressMapper workProgressMapper;
    @Autowired
    private WorkContentService workContentService;

    @Override
    public WorkProgressCommit updateWorkProgress(WorkProgressCommit commit) {
        WorkContent content = workContentService.getWorkContentsByCommitId(commit.getContentId());
        if (content.isFinished()) {
            throw new RuntimeException("工作已结束，无法更新进度");
        }
        workProgressMapper.insertCommit(commit);
        return commit;
    }
}
