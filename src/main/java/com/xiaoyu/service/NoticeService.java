package com.xiaoyu.service;

import com.xiaoyu.entity.Notice;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/22/15:56
 * @Description:
 */
public interface NoticeService {
    //查询部门的所有公告
    List<Notice> getNoticesByDepartmentId(Long departmentId);

    //发布部门公告
    void publishNotice(Notice notice);

}
