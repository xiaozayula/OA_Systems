package com.xiaoyu.mapper;

import com.xiaoyu.entity.WorkGroup;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/14:38
 * @Description:
 */
@Mapper
public interface WorkGroupMapper {

    void insert(WorkGroup workGroup);
}
