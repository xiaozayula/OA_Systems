package com.xiaoyu.service;

import java.time.LocalDateTime;
import java.util.List;
import com.xiaoyu.entity.Record;
import com.xiaoyu.enums.ApplicationStatus;
import com.xiaoyu.enums.ApplicationType;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/30/20:02
 * @Description:
 */
public interface RecordService {
    void addRecord(Long userId, Long requestId, ApplicationType applicationType, ApplicationStatus status, LocalDateTime actionTime, String details);
    List<Record> getAllRecords();
    // 其他必要的服务方法
}