package com.xiaoyu.service;

import com.xiaoyu.entity.WorkProgressCommit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/15:35
 * @Description:
 */
public interface WorkProgressService {
    WorkProgressCommit updateWorkProgress(WorkProgressCommit commit);
}
