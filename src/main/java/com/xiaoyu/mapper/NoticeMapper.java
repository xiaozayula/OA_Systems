package com.xiaoyu.mapper;

import com.xiaoyu.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/22/15:52
 * @Description:
 */
@Mapper
public interface NoticeMapper {
    List<Notice> findNoticesByDepartmentId(@Param("departmentId") Long departmentId);

    void insertNotice(@Param("notice") Notice notice);
}

