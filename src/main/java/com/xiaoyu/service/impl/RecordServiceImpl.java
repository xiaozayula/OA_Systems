package com.xiaoyu.service.impl;

import com.xiaoyu.enums.ApplicationStatus;
import com.xiaoyu.enums.ApplicationType;
import com.xiaoyu.mapper.RecordMapper;
import com.xiaoyu.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.entity.Record;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/30/20:03
 * @Description:
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;


    @Override
    public void addRecord(Long userId, Long requestId, ApplicationType applicationType, ApplicationStatus status, LocalDateTime actionTime, String details) {

        Record record = new Record();
        record.setUserId(userId);
        record.setRequestId(requestId);
        record.setApplicationType(applicationType);
        record.setStatus(status);
        record.setActionTime(actionTime);
        record.setDetails(details);
        recordMapper.insertRecord(record);
    }

    @Override
    public List<Record> getAllRecords() {
        return recordMapper.selectAllRecords();
    }


}