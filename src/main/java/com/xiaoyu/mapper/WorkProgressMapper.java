package com.xiaoyu.mapper;

import com.xiaoyu.entity.WorkProgressCommit;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/15:37
 * @Description:
 */
@Mapper
public interface WorkProgressMapper {
    void insertCommit(WorkProgressCommit commit);
}
