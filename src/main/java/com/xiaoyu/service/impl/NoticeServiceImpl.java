package com.xiaoyu.service.impl;

import com.xiaoyu.entity.Notice;
import com.xiaoyu.mapper.NoticeMapper;
import com.xiaoyu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/22/15:57
 * @Description:
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> getNoticesByDepartmentId(Long departmentId) {
        return noticeMapper.findNoticesByDepartmentId(departmentId);
    }

    @Override
    public void publishNotice(Notice notice) {

        noticeMapper.insertNotice(notice);
    }



}
