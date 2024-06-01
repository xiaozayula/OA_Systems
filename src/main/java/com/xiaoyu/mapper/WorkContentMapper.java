package com.xiaoyu.mapper;

import com.xiaoyu.entity.WorkContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/23/13:12
 * @Description:
 */
@Mapper
public interface WorkContentMapper {
    //查询部门下所有小组的工作内容
    List<WorkContent> selectWorkContentsByDepartmentId(@Param("departmentId") Long departmentId);

    void insert(WorkContent workContent);

    WorkContent selectWorkContentsBycontentId(Long contentId);
}
