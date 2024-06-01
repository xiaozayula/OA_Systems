package com.xiaoyu.service.impl;

import com.xiaoyu.entity.WorkGroup;
import com.xiaoyu.mapper.WorkGroupMapper;
import com.xiaoyu.service.WorkGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/14:37
 * @Description:
 */
@Service
public class WorkGroupServiceImpl implements WorkGroupService {

    @Autowired
    private WorkGroupMapper workGroupMapper;

    @Override
    public WorkGroup createWorkGroup(WorkGroup workGroup) {
        workGroupMapper.insert(workGroup);
        return workGroup;
    }
}
